package org.stylizedsubstance.mybank.util;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class DateTimeUtil {
    // Create timestamp in format "yyyy-MM-ddTHH:mmZ"
    public String createTimeStamp() {
        ZoneId utcZone = ZoneId.of("Z");
        ZonedDateTime now = ZonedDateTime.now(utcZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'`T'`HH:mm'`Z'`");
        return now.format(formatter);
    }
}
