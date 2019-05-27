package com.api.james.core.apicorejames.controller;


import com.api.james.core.apicorejames.Repository.ProductRepository;
import com.api.james.core.apicorejames.api.ProductApi;
import com.api.james.core.apicorejames.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

import static com.api.james.core.apicorejames.service.utils.ParserUtil.convertValue;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
public class ProductController extends BaseController implements ProductApi {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity<ApiProductCodeTO> createProduct(@Valid ApiProductTO newProduct) {

        Product product = Product.builder()
                .name(newProduct.getName())
                .description(newProduct.getDescription())
                .category(newProduct.getCategory())
                .user(newProduct.getUser())
                .date(newProduct.getDate())
                .build();

        productRepository.save(product);

        ApiProductCodeTO response = new ApiProductCodeTO();
        return new ResponseEntity<>( CREATED);
    }

    @Override
    public ResponseEntity<ApiResponseProductsTO> getProduct(String code) {
        return null;
    }

    @Override
    public ResponseEntity<ApiResponseProductsTO> getProducts() {
        List<Product> products = productRepository.findAll();


        ApiResponseProductsTO responseProductsTO = convertValue(products, ApiResponseProductsTO.class);

        return  new ResponseEntity<>(responseProductsTO, OK);
    }

    @Override
    public ResponseEntity<Void> updateProduct(String code, @Valid ApiUpdateProductTO product) {
        return null;
    }
}


