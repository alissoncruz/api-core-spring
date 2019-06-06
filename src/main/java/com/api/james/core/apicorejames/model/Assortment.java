package com.api.james.core.apicorejames.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assortment implements Serializable {

    private String product;

    private String codeStore;

    private BigDecimal price;

    private BigDecimal priceCurrent;

    private String description;

    private String shortDescription;

    private Integer stock;

    private String codeEAN1;

    private String codeEAN2;

    private String codeEAN3;

    private String section;

    private String codeGroup;

    private String codeSubgroup;
}
