package com.api.james.core.apicorejames.service.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;

public class ParserJsonUtil {

    public static String convertObjectToJson(Object object) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new Jdk8Module());
            mapper.registerModule(new JavaTimeModule());
            return  mapper.writeValueAsString(object);
        } catch (Exception ex){
            throw new IllegalArgumentException(ex);
        }

    }

    public static <T> T convertJsonToObject(String json, Class<T> toValueType) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new JavaTimeModule());
        return mapper.readValue(json, toValueType);
    }

}
