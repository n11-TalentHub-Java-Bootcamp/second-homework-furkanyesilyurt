package com.furkanyesilyurt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springBeans.Dao;
import springBeans.Service;

@Configuration
public class SpringCoreApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringCoreApplication.class);

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
