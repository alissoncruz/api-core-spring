package com.api.james.core.apicorejames.service;

import com.api.james.core.apicorejames.model.Product;

import java.util.List;

public interface ProductService {

    String createProduct(Product product);

    List<Product> findProducts();

}
