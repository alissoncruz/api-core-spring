package com.api.james.core.apicorejames.model;

import com.api.james.core.apicorejames.service.utils.DateTimeToStringConverter;
import com.api.james.core.apicorejames.service.utils.StringToDatetimeConverter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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

    private String product;

    private String description;

    private String category;

    private BigDecimal price;

    private String user;

    @JsonSerialize(converter = DateTimeToStringConverter.class)
    @JsonDeserialize(converter = StringToDatetimeConverter.class)
    private DateTime date;


}
