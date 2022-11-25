package com.pradip.elasticsearch.services;

import com.pradip.elasticsearch.models.Product;
import com.pradip.elasticsearch.repositories.ProductRepository;

import java.util.List;

public class ProductSearchService {
    private ProductRepository productRepository;

    public void createProductIndexBulk(final List<Product> products) {
        productRepository.saveAll(products);
    }

    public void createProductIndex(final Product product) {
        productRepository.save(product);
    }
}
