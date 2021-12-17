package com.furkanyesilyurt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.furkanyesilyurt.springApps.Dao;
import com.furkanyesilyurt.springApps.Service;

@Configuration
public class JavaBasedApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaBasedApplication.class);

        Service service = applicationContext.getBean(Service.class);
        service.test();
    }

    @Bean
    public Service getService(){
        return new Service(getDao());
    }
    @Bean
    public Dao getDao(){
        return new Dao();
    }

}
