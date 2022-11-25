package com.pradip.elasticsearch.repositories;

import com.pradip.elasticsearch.models.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository
        extends ElasticsearchRepository<Product, String> {
    List<Product> findByName(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByManufacturerAndCategory
            (String manufacturer, String category);
}