package com.telran;

import com.sun.deploy.perf.PerfRollup;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
        // the same
        System.out.println(today.format(DateTimeFormatter.ISO_DATE));

        String str = "Dan " + today;
        System.out.println(str);

//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        System.out.println(today.format(formatter));
//        LocalDate dr = LocalDate.parse("1985/08/01", formatter);
//        System.out.println(dr.format(DateTimeFormatter.ofPattern("dd.MM.yy")));

        // my version
        LocalDate hbThisYear = LocalDate.of(2020, 10, 18);
        System.out.println(hbThisYear.isBefore(today));
        // class work
        hbThisYear = LocalDate.of(LocalDate.now().getYear(), Month.OCTOBER, 18);
        System.out.println("The hb already was: " + hbThisYear.isBefore(today));

        // my version
        LocalDate newYear = LocalDate.MAX.withYear(2020);
        Period period = Period.between(newYear, today);
        System.out.println(period);

        // class work
        LocalDate newYearDate = LocalDate.of(today.getYear(), 12, 31);
        LocalDateTime newYear1 = LocalDateTime.of(newYearDate, LocalTime.of(10, 0));

        LocalDateTime todayWithTime = LocalDateTime.now();
        Duration todayBetweenNY = Duration.between(todayWithTime, newYear1);
        System.out.println(todayBetweenNY.toDays());

        // better to use this one
        System.out.println(ChronoUnit.DAYS.between(todayWithTime, newYear1));

        ZonedDateTime zonedNow = ZonedDateTime.of(todayWithTime, ZoneId.systemDefault());
        System.out.println(zonedNow);

        ZonedDateTime zonedNowKyiv = zonedNow.withZoneSameInstant(ZoneId.of("Europe/Kiev"));
        System.out.println(zonedNowKyiv);

        ZonedDateTime zonedNowKyivWrong = ZonedDateTime.of(todayWithTime, ZoneId.of("Europe/Kiev"));
        System.out.println(zonedNowKyivWrong);

    }
}
