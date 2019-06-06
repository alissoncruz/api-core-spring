package com.api.james.core.apicorejames.service;

import com.api.james.core.apicorejames.model.Assortment;

import java.util.List;

public interface AssortmentService {

    void createAssortment(Assortment assortment);
    void createAssortments(List<Assortment> assortments);
}
