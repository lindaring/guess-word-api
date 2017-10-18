package com.lindaring.guess.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggingUtil {

    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Log method.
     */
    public void logMethodDebug(Object className, String methodName, Object returnValue, String... parameterArray) {
        int count = 0;
        String params = "";
        for (String p : parameterArray) {
            count++;
            params += p;
            if (parameterArray.length != count) {
                params += ", ";
            }
        }
        log.debug(String.format("%s :: %s(%s) :: returned :: %s", className, methodName, params, returnValue));
    }

    /**
     * Log method response.
     */
    public void logMethodDebug( Object className, String methodName, String returnValue) {
        log.debug(String.format("%s :: %s :: returned :: %s"), className, methodName, returnValue);
    }

}
