package io.wesquad.kata.java8.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class DateTimeZoneTest {

    private static final LocalDateTime DATE_TIME_20190528_17070350 =
            LocalDateTime.of(2019, 5, 28, 17, 7, 3, 500000000);

    public static final ZonedDateTime DATE_TIME_ZONE_20190528_17070350 =
            ZonedDateTime.of(DATE_TIME_20190528_17070350, ZoneId.of("Europe/Paris"));

    @Test
    public void zonedDateTimeOf() {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2019, 5, 28, 17, 7, 3, 500000000, ZoneId.of("Europe/Paris"));

        assertThat(zonedDateTime.toString()).isEqualTo("2019-05-28T17:07:03.500+02:00[Europe/Paris]");
    }

    @Test
    public void zonedDateTimeParse() {
        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2019-05-28T17:07:03.500+02:00[Europe/Paris]");

        assertThat(zonedDateTime.toString()).isEqualTo("2019-05-28T17:07:03.500+02:00[Europe/Paris]");
    }

    @Test
    public void zonedDateTimeFormat() {
        String strZdt = DATE_TIME_ZONE_20190528_17070350.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss_z"));

        assertThat(strZdt).isEqualTo("2019_05_28_17_07_03_CEST");
    }

    @Test
    public void toPST() {
        ZonedDateTime zonedDateTime = DATE_TIME_20190528_17070350.atZone(ZoneId.of("America/Los_Angeles"));

        assertThat(zonedDateTime.toLocalDateTime()).isEqualTo(DATE_TIME_20190528_17070350);
        assertThat(zonedDateTime.getZone().toString()).isEqualTo("America/Los_Angeles");
    }

    @Test
    public void sameInstantAs() {
        ZonedDateTime zonedDateTime = DATE_TIME_ZONE_20190528_17070350.withZoneSameInstant(ZoneId.of("America/Los_Angeles"));

        assertThat(zonedDateTime.toString()).isEqualTo("2019-05-28T08:07:03.500-07:00[America/Los_Angeles]");
    }

    @Test
    public void sameLocalAs() {
        ZonedDateTime zonedDateTime = DATE_TIME_ZONE_20190528_17070350.withZoneSameLocal(ZoneId.of("America/Los_Angeles"));

        assertThat(zonedDateTime.toString()).isEqualTo("2019-05-28T17:07:03.500-07:00[America/Los_Angeles]");
    }
}
