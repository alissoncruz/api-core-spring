package com.api.james.core.apicorejames.service.utils;

import com.fasterxml.jackson.databind.util.StdConverter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeToStringConverter extends StdConverter<DateTime, String> {

    final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSZZ");

    @Override
    public String convert(DateTime dateTime) {

         return DATE_TIME_FORMATTER.print(dateTime);
    }
}
