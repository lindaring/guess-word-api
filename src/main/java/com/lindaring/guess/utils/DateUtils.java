package com.lindaring.guess.utils;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Component
public class DateUtils {

    /**
     * Convert from Timestamp to sql.Date.
     * @param localDate the local date.
     * @return the sql.Timestamp.
     */
    public Timestamp convertLocalDate(LocalDateTime localDate) {
        return (localDate != null) ? Timestamp.valueOf(localDate) : null;
    }

    /**
     * Convert sql.Timpestamp to LocalDateTime.
     * @param sqlTimpestamp the sql.Timpestamp.
     * @return the local date.
     */
    public LocalDateTime convertSqlDate(Timestamp sqlTimpestamp) {
        return (sqlTimpestamp != null) ? sqlTimpestamp.toLocalDateTime() : null;
    }

}
