package io.wesquad.kata.java8.date;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTimeTest {

    private static final LocalDateTime DATE_TIME_20190528_17070350 =
            LocalDateTime.of(2019, 5, 28, 17, 7, 3, 500000000);

    @Test
    public void localDateTimeOf() {
        LocalDateTime localDateTime = LocalDateTime.of(2019, 5, 28, 17, 7, 3);

        assertThat(localDateTime.toString()).isEqualTo("2019-05-28T17:07:03");
    }

    @Test
    public void localDateTimeParse() {
        LocalDateTime localDateTime = LocalDateTime.parse("2019-05-28T17:07:03");

        assertThat(localDateTime.toString()).isEqualTo("2019-05-28T17:07:03");
    }

    @Test
    public void localDateTimeWith() {
        LocalDateTime localDateTime = LocalDateTime.of(2018, 8, 5, 6, 6, 36);
        localDateTime = localDateTime.withYear(2019).withMonth(5).withDayOfMonth(28).withHour(17).withMinute(7).withSecond(3);

        assertThat(localDateTime.getYear()).isEqualTo(2019);
        assertThat(localDateTime.getMonthValue()).isEqualTo(5);
        assertThat(localDateTime.getDayOfMonth()).isEqualTo(28);
        assertThat(localDateTime.getHour()).isEqualTo(17);
        assertThat(localDateTime.getMinute()).isEqualTo(7);
        assertThat(localDateTime.getSecond()).isEqualTo(3);
    }

    @Test
    public void localTimeWithAdjuster() {
        LocalDateTime localDateTime = DATE_TIME_20190528_17070350
                .with(TemporalAdjusters.firstDayOfNextMonth())
                .truncatedTo(ChronoUnit.HOURS);

        assertThat(localDateTime.toString()).isEqualTo("2019-06-01T17:00");
    }

    @Test
    public void localDatePlusMinus() {
        LocalDateTime localDateTime = DATE_TIME_20190528_17070350.plusMonths(5).minusHours(5);

        assertThat(localDateTime.toString()).isEqualTo("2019-10-28T12:07:03.500");

    }

    @Test
    public void localDateTimeFormat() {
        String strLdt = DATE_TIME_20190528_17070350.format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));

        assertThat(strLdt).isEqualTo("2019_05_28_17_07_03");
    }

    @Test
    public void toLocalDateAndTime() {
        LocalDate localDate = DATE_TIME_20190528_17070350.toLocalDate();
        LocalTime localTime = DATE_TIME_20190528_17070350.toLocalTime();

        assertThat(localDate.toString()).isEqualTo("2019-05-28");
        assertThat(localTime.toString()).isEqualTo("17:07:03.500");
    }

    @Test
    public void toLocalDateTime() {
        LocalDate localDate = LocalDate.parse("2019-05-28");
        LocalTime localTime = LocalTime.parse("17:07:03.1");

        LocalDateTime localDateTime1 = localDate.atTime(localTime);
        LocalDateTime localDateTime2 = localTime.atDate(localDate);

        assertThat(localDateTime1.toString()).isEqualTo("2019-05-28T17:07:03.100");
        assertThat(localDateTime2.toString()).isEqualTo("2019-05-28T17:07:03.100");
        assertThat(localDateTime1).isEqualTo(localDateTime2);
    }

    @Test
    public void localDateTime2Timestamp() {
        Timestamp timestamp = Timestamp.valueOf(DATE_TIME_20190528_17070350);

        assertThat(timestamp.toString()).isEqualTo("2019-05-28 17:07:03.5");
    }

    @Test
    public void timestamp2LocalDateTime() {
        Timestamp timestamp = Timestamp.valueOf("2019-05-28 17:07:03.5");;
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        assertThat(localDateTime.toString()).isEqualTo("2019-05-28T17:07:03.500");
    }
}
