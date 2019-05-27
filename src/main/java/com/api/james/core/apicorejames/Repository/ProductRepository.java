package com.api.james.core.apicorejames.Repository;


import com.api.james.core.apicorejames.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
