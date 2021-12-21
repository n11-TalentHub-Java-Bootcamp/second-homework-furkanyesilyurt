package com.furkanyesilyurt.springboot.springboottraining.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.springboot.springboottraining.converter.CommentConverter;
import com.furkanyesilyurt.springboot.springboottraining.dto.CommentDto;
import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import com.furkanyesilyurt.springboot.springboottraining.exception.CommentNotFoundException;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.CommentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentEntityService commentEntityService;

    public List<ProductReview> findAllComments(){
        return commentEntityService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        commentEntityService.deleteById(id);
    }

    @PostMapping("/comment")
    public ResponseEntity<Object> saveComment(@Valid @RequestBody CommentDto commentDto){

        ProductReview productReview = CommentConverter.INSTANCE.convertCommentDtoToComment(commentDto);

        productReview = commentEntityService.save(productReview);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productReview.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{kullaniciId}")
    public MappingJacksonValue findByKullaniciId(@PathVariable String kullaniciId){

        ProductReview productReview = commentEntityService.findByKullaniciId(kullaniciId);

        if(productReview == null){
            throw  new CommentNotFoundException("Kullanici henuz bir yorum yapmamistir");
        }

        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllComments()
        );

        CommentDto commentDto = CommentConverter.INSTANCE.convertCommentToCommentDto(productReview);

        String filterName = "CommentDtoFilter";

        SimpleFilterProvider filters = getUrunFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(commentDto);

        entityModel.add(linkToUrun.withRel("tum-yorumlar"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;


    }

    private SimpleFilterProvider getUrunFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getUrunFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getUrunFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "yorum", "yorumTarihi", "urunId");
    }

}
