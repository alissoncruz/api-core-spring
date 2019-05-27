package com.api.james.core.apicorejames.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@RedisHash("product")
public class Product {

    @Id
    private String id;

    private String name;

    private String description;

    private String category;

    private BigDecimal price;

    private String user;

    private DateTime date;


}
