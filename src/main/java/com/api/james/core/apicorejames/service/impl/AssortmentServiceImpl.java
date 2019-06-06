package com.api.james.core.apicorejames.service.impl;

import com.api.james.core.apicorejames.Repository.AssortmentRepository;
import com.api.james.core.apicorejames.model.Assortment;
import com.api.james.core.apicorejames.service.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssortmentServiceImpl implements AssortmentService {

    private final Logger log =  LoggerFactory.getLogger(AssortmentServiceImpl.class);

    @Autowired
    private AssortmentRepository assortmentRepository;

    @Override
    public void createAssortment(Assortment assortment) {
        log.debug("Start method createAssortment");
        assortmentRepository.save(assortment);
        log.debug("Finish method createAssortment");
    }

    @Override
    public void createAssortments(List<Assortment> assortments) {
        assortments.stream().forEach(assortment -> {
            assortmentRepository.save(assortment);
        });
    }
}
