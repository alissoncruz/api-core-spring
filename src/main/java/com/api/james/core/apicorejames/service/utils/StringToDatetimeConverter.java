package com.api.james.core.apicorejames.service.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.joda.time.DateTime;

import static com.api.james.core.apicorejames.service.utils.DateTimeToStringConverter.DATE_TIME_FORMATTER;


public class StringToDatetimeConverter extends StdConverter<String, DateTime> {

    @Override
    public DateTime convert(String value) {
        return DateTime.parse(value, DATE_TIME_FORMATTER);
    }
}
