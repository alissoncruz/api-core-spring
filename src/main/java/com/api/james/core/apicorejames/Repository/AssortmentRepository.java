package com.api.james.core.apicorejames.Repository;

import com.api.james.core.apicorejames.model.Assortment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssortmentRepository extends MongoRepository<Assortment, String> {
}
