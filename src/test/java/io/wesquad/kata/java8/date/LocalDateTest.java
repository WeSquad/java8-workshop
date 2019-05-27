package io.wesquad.kata.java8.date;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalDateTest {

    private final static LocalDate DATE_20190528 = LocalDate.of(2019, 5, 28);
    private LocalDateTime DATETIME_20190528_09073050 = LocalDateTime.of(2019, 5, 28, 9, 7, 30, 500000000);

    @Test
    public void localDateOf() {
        LocalDate localDate = LocalDate.of(2019, Month.MAY, 28);

        assertThat(localDate.toString()).isEqualTo("2019-05-28");
    }

    @Test
    public void localDateParse() {
        LocalDate localDate = LocalDate.parse("2019-05-28");

        assertThat(localDate.toString()).isEqualTo("2019-05-28");
    }

    @Test
    public void localDateWith() {
        LocalDate localDate = LocalDate.of(2017, 7, 17);
        localDate = localDate.withYear(2019).withMonth(5).withDayOfMonth(28);

        assertThat(localDate.getYear()).isEqualTo(2019);
        assertThat(localDate.getMonthValue()).isEqualTo(5);
        assertThat(localDate.getDayOfMonth()).isEqualTo(28);
    }

    @Test
    public void localDateWithAdjuster() {
        LocalDate localDate = LocalDate.of(2019, 5, 28);
        localDate = localDate.with(TemporalAdjusters.firstDayOfNextYear());

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JANUARY);
        assertThat(localDate.getDayOfMonth()).isEqualTo(1);
    }

    @Test
    public void localDatePlus() {
        LocalDate localDate = DATE_20190528.plusYears(1).plusMonths(1).plusWeeks(1).plusDays(1);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonth()).isEqualTo(Month.JULY);
        assertThat(localDate.getDayOfMonth()).isEqualTo(6);
    }

    @Test
    public void localDateMinus() {

        LocalDate localDate = DATE_20190528.minusYears(1).minusMonths(1).minusWeeks(1).minusDays(1);

        assertThat(localDate.getYear()).isEqualTo(2018);
        assertThat(localDate.getMonthValue()).isEqualTo(4);
        assertThat(localDate.getDayOfMonth()).isEqualTo(20);
    }


    @Test
    public void localDatePlusPeriod() {
        Period period = Period.of(1, 2, 3);

        LocalDate localDate = DATE_20190528.plus(period);

        assertThat(localDate.getYear()).isEqualTo(2020);
        assertThat(localDate.getMonthValue()).isEqualTo(7);
        assertThat(localDate.getDayOfMonth()).isEqualTo(31);
    }

    @Test
    public void localDateIsAfter() {
        LocalDate localDate = LocalDate.parse("2018-01-28");

        boolean isAfter = DATE_20190528.isAfter(localDate);

        assertThat(isAfter).isEqualTo(true);
    }

    @Test
    public void localDateUntil() {
        LocalDate localDate = LocalDate.parse("2018-01-28");

        Period period = localDate.until(DATE_20190528);

        assertThat(period.getYears()).isEqualTo(1);
        assertThat(period.getMonths()).isEqualTo(4);
        assertThat(period.getDays()).isEqualTo(0);
    }

    @Test
    public void localDate2date() {
        Date date = Date.valueOf(DATE_20190528);

        assertThat(date.toString()).isEqualTo("2019-05-28");
    }

    @Test
    public void date2LocalDate() {
        Date date = Date.valueOf("2019-05-28");
        LocalDate localDate = date.toLocalDate();

        assertThat(localDate.toString()).isEqualTo("2019-05-28");
    }
}
