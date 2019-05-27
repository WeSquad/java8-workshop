package io.wesquad.kata.java8.date;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalTimeTest {

    private final static LocalTime TIME_17070350 = LocalTime.of(17, 7, 3, 500000000);

    @Test
    public void localTimeOfHourToMinute() {
        LocalTime localTime = LocalTime.of(17, 7);

        assertThat(localTime.toString()).isEqualTo("17:07");
    }

    @Test
    public void localTimeOfHourToNanoSec() {
        LocalTime localTime = LocalTime.of(17, 7, 3, 100000000);

        assertThat(localTime.toString()).isEqualTo("17:07:03.100");
    }

    @Test
    public void localTimeParse() {
        LocalTime localTime = LocalTime.parse("17:07:03.1");

        assertThat(localTime.toString()).isEqualTo("17:07:03.100");
    }

    @Test
    public void localTimeWith() {
        LocalTime localTime = TIME_17070350.withHour(21);
        assertThat(localTime.getHour()).isEqualTo(21);
        assertThat(localTime.getMinute()).isEqualTo(7);
        assertThat(localTime.getSecond()).isEqualTo(3);
    }

    @Test
    public void localTimeWithChronoField() {
        LocalTime localTime = TIME_17070350.with(ChronoField.HOUR_OF_DAY, 21);
        assertThat(localTime.getHour()).isEqualTo(21);
        assertThat(localTime.getMinute()).isEqualTo(7);
        assertThat(localTime.getSecond()).isEqualTo(3);
    }

    @Test
    public void localTimePlus() {
        LocalTime localTime = TIME_17070350.plusHours(1).plusMinutes(30).plusSeconds(30);

        assertThat(localTime.getHour()).isEqualTo(18);
        assertThat(localTime.getMinute()).isEqualTo(37);
        assertThat(localTime.getSecond()).isEqualTo(33);
    }

    @Test
    public void localTimeMinus() {
        LocalTime localTime = TIME_17070350.minusHours(1).minusMinutes(7).minusSeconds(3);

        assertThat(localTime.getHour()).isEqualTo(16);
        assertThat(localTime.getMinute()).isEqualTo(0);
        assertThat(localTime.getSecond()).isEqualTo(0);
    }


    @Test
    public void localTimeMinusDuration() {
        Duration duration = Duration.ofSeconds( 2);
        LocalTime localTime = TIME_17070350.minus(duration);

        assertThat(localTime.getHour()).isEqualTo(17);
        assertThat(localTime.getMinute()).isEqualTo(7);
        assertThat(localTime.getSecond()).isEqualTo(1);
    }

    @Test
    public void localDateIsBefore() {
        LocalTime localTime = LocalTime.of(15, 7);
        boolean isBefore = localTime.isBefore(TIME_17070350);

        assertThat(isBefore).isTrue();
    }

    @Test
    public void localTimeTruncatedTo() {
        LocalTime localTime = TIME_17070350.truncatedTo(ChronoUnit.MINUTES);

        assertThat(TIME_17070350.toString()).isEqualTo("17:07:03.500");
        assertThat(localTime.toString()).isEqualTo("17:07");
    }
}
