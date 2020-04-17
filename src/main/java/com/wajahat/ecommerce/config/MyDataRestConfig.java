package com.wajahat.ecommerce.config;

import com.wajahat.ecommerce.entity.Product;
import com.wajahat.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

/**
 * Created by Syed Wajahat on 4/5/2020.
 * Configuration class for making Spring Data Rest methods for GET - Read only
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    HttpMethod[] theUnsupportedMethods = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        //disable HTTP Methods  for Product: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(Product.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));

        //disable HTTP Methods  for ProductCategory: PUT, POST and DELETE
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class).withItemExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods))
                .withCollectionExposure((metadata, httpMethods) -> httpMethods.disable(theUnsupportedMethods));


    }
}
