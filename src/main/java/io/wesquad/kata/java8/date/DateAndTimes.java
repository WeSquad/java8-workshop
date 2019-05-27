package io.wesquad.kata.java8.date;

import java.time.*;

public class DateAndTimes {
    public LocalDate Date_20190618 = LocalDate.of(2019, 5, 28);
    public LocalTime Time_17070350 = LocalTime.of(17, 7, 3, 500000000);
    public LocalDateTime DateTime_20190528_17070350 =
            LocalDateTime.of(2019, 5, 28, 17, 7, 3, 500000000);
    public ZonedDateTime DateTimeZone_20190528_17070350 =
            ZonedDateTime.of(DateTime_20190528_17070350, ZoneId.of("Europe/Paris"));
}
