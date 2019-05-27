package com.api.james.core.apicorejames.service.utils;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;

import java.util.ResourceBundle;

public class PropertiesUtil {
    private static final String ERROR_PROPERTIES = "messages_en";
    private static final Logger log = ESAPI.getLogger(ParserUtil.class);

    private PropertiesUtil() {
    }

    public static String getErrorMessage(String key) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("messages_en");
            return bundle.getString(key);
        } catch (Exception var2) {
            log.error(Logger.EVENT_FAILURE, var2.getMessage(), var2);
            return "";
        }
    }
}
