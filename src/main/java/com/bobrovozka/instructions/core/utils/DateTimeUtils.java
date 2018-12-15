package com.bobrovozka.instructions.core.utils;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class DateTimeUtils {

    public static long nowUTCSeconds() {
        return LocalDateTime.now(Clock.systemUTC()).toEpochSecond(ZoneOffset.UTC);
    }

    public static LocalDate nowUTCDate() {
        return LocalDateTime.now(Clock.systemUTC()).toLocalDate();
    }


}
