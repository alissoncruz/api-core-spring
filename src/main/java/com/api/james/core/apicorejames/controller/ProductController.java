package com.api.james.core.apicorejames.controller;


import com.api.james.core.apicorejames.Repository.ProductRepository;
import com.api.james.core.apicorejames.api.ProductApi;
import com.api.james.core.apicorejames.model.*;
import com.api.james.core.apicorejames.service.ProductService;
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
    private ProductService productService;

    @Override
    public ResponseEntity<ProductCodeTO> createProduct(@Valid ProductTO newProduct)  {

        Product product = Product.builder()
                .product(newProduct.getName())
                .description(newProduct.getDescription())
                .category(newProduct.getCategory())
                .user(newProduct.getUser())
                .date(newProduct.getDate())
                .price(newProduct.getPrice())
                .build();

        String code = productService.createProduct(product);

        ProductCodeTO response = new ProductCodeTO();
        response.setCode(code);
        return new ResponseEntity<>(response, CREATED);
    }

    @Override
    public ResponseEntity<ResponseProductsTO> getProduct(String code) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseProductsTO> getProducts() {
        List<Product> products = productService.findProducts();

        ResponseProductsTO responseProductsTO = new ResponseProductsTO();
        List<ResponseProductsTO> list = new ArrayList<ResponseProductsTO>();
        products.forEach(product -> {
            ProductResponseTO to = convertValue(product, ProductResponseTO.class);
            responseProductsTO.addProductItem(to);
        });

        return  new ResponseEntity<>(responseProductsTO, OK);
    }

    @Override
    public ResponseEntity<Void> updateProduct(String code, @Valid UpdateProductTO product) {
        return null;
    }


}


