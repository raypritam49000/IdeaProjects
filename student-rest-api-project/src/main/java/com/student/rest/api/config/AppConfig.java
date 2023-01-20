package com.student.rest.api.config;

import org.hibernate.ogm.jpa.HibernateOgmPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableWebMvc
public class AppConfig {


    @Bean
    public PlatformTransactionManager transactionManager(){
        PlatformTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        Map<String,Object> properties = new HashMap<String, Object>();
        properties.put("javax.persistence.transactionType","resource_local");
        properties.put("hibernate.ogm.datastore.provider","org.hibernate.ogm.datastore.mongodb.impl.MongoDBDatastoreProvider");
        properties.put("hibernate.ogm.datastore.database","test");
        properties.put("hibernate.ogm.datastore.create_database",true);

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setPackagesToScan("com.student.rest.api.entity");
        entityManager.setPersistenceUnitName("mongoPersistenceUnit");
        entityManager.setJpaVendorAdapter(new MyJpaVendorAdapter());
        entityManager.setJpaPropertyMap(properties);
        entityManager.setPersistenceProviderClass(HibernateOgmPersistence.class);
        return entityManager;
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
