package com.student.rest.api.config;

import org.hibernate.ogm.jpa.HibernateOgmPersistence;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.persistence.spi.PersistenceProvider;

@Component
public class MyJpaVendorAdapter extends HibernateJpaVendorAdapter {

    @Override
    public PersistenceProvider getPersistenceProvider() {
        PersistenceProvider persistenceProvider = new HibernateOgmPersistence();
        return persistenceProvider;
    }
}
