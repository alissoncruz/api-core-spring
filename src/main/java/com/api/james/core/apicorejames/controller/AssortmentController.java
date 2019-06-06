package com.api.james.core.apicorejames.controller;

import com.api.james.core.apicorejames.api.AssortmentApi;
import com.api.james.core.apicorejames.model.Assortment;
import com.api.james.core.apicorejames.model.AssortmentResponseTO;
import com.api.james.core.apicorejames.model.AssortmentTO;
import com.api.james.core.apicorejames.service.AssortmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;

import static com.api.james.core.apicorejames.service.utils.ParserUtil.convertValue;

@Controller
public class AssortmentController extends BaseController implements AssortmentApi {

    private final Logger log =  LoggerFactory.getLogger(AssortmentController.class);

    @Autowired
    private AssortmentService assortmentService;

    @Override
    public ResponseEntity<Void> createAssortment(@Valid AssortmentTO assortmentTO) {
        log.debug(" Start method createAssortment");

        Assortment assortment = convertValue(assortmentTO, Assortment.class);

        assortmentService.createAssortment(assortment);

        log.debug(" Start method createAssortment");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AssortmentResponseTO> getProduct(String code) {
        return null;
    }
}
