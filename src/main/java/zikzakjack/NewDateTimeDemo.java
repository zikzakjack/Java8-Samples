package zikzakjack;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewDateTimeDemo {

	public static void main(String[] args) {

		System.out.println("\n********** LocalDate : Immutable object representing just a plain date without the time of day **********\n");
		System.out.println("LocalDate.now() = " + LocalDate.now());
		System.out.println("LocalDate.parse(\"2015-10-06\") = " + LocalDate.parse("2015-10-06"));
		LocalDate date = LocalDate.of(2015, 10, 06);
		int year = date.getYear();
		Month month = date.getMonth();
		int day = date.getDayOfMonth();
		DayOfWeek dow = date.getDayOfWeek();
		int len = date.lengthOfMonth();
		boolean leap = date.isLeapYear();
		System.out.println("date = " + date);
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		System.out.println("day = " + day);
		System.out.println("dow = " + dow);
		System.out.println("len = " + len);
		System.out.println("leap = " + leap);

		System.out.println("year (Using ChronoField) = " + date.get(ChronoField.YEAR));
		System.out.println("month (Using ChronoField) = " + Month.of(date.get(ChronoField.MONTH_OF_YEAR)));
		System.out.println("day (Using ChronoField) = " + date.get(ChronoField.DAY_OF_MONTH));
		System.out.println("dow (Using ChronoField) = " + DayOfWeek.of(date.get(ChronoField.DAY_OF_WEEK)));

		System.out.println("\n********** LocalTime : Immutable object representing just a plain time without the date **********\n");
		
		System.out.println("LocalTime.now() = " + LocalTime.now());
		System.out.println("LocalTime.parse(\"13:45:20\") = " + LocalTime.parse("13:45:20"));
		LocalTime time = LocalTime.of(14, 10, 06);
		int hours = time.getHour();
		int minutes = time.getMinute();
		int seconds = time.getSecond();
		System.out.println("time = " + time);
		System.out.println("hours = " + hours);
		System.out.println("minutes = " + minutes);
		System.out.println("seconds = " + seconds);
		System.out.println("hours (Using ChronoField) = " + time.get(ChronoField.HOUR_OF_DAY));
		System.out.println("minutes (Using ChronoField) = " + time.get(ChronoField.MINUTE_OF_HOUR));
		System.out.println("seconds (Using ChronoField) = " + time.get(ChronoField.SECOND_OF_MINUTE));

		System.out.println("\n********** LocalDateTime : represents both a date and a time, without a time zone, and can be created either directly or by combining a date and time **********\n");
		System.out.println("LocalDateTime.now() = " + LocalDateTime.now());
		LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
		LocalDateTime dt2 = LocalDateTime.of(date, time);
		LocalDateTime dt3 = date.atTime(13, 45, 20);
		LocalDateTime dt4 = date.atTime(time);
		LocalDateTime dt5 = time.atDate(date);
		System.out.println("dt1 = " + dt1);
		System.out.println("dt2 = " + dt2);
		System.out.println("dt3 = " + dt3);
		System.out.println("dt4 = " + dt4);
		System.out.println("dt5 = " + dt5);

		System.out.println("\n********** Instant : represents the number of seconds passed since the Unix epoch time **********\n");
		System.out.println("Instant.now() = " + Instant.now());
		System.out.println("Instant.ofEpochSecond(3) = " + Instant.ofEpochSecond(3));
		System.out.println("Instant.ofEpochSecond(3,4) = " + Instant.ofEpochSecond(3,4));
		System.out.println("Instant.ofEpochSecond(3,1_000_000_000) = " + Instant.ofEpochSecond(3,1_000_000_000));
		System.out.println("Instant.ofEpochSecond(3,-1_000_000_000) = " + Instant.ofEpochSecond(3,-1_000_000_000));

		System.out.println("\n********** Duration : Time elapsed between two LocalTime / LocalDateTime / Instant **********\n");
		Duration d1 = Duration.between(time, LocalTime.now());
		Duration d2 = Duration.between(dt1, LocalDateTime.now());
		Duration d3 = Duration.between(Instant.ofEpochSecond(3), Instant.now());
		Duration threeMinutes = Duration.ofMinutes(3);
		Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println("threeMinutes = " + threeMinutes);
		System.out.println("threeMinutes1 = " + threeMinutes1);

		System.out.println("\n********** Period : Days/Months/Years elapsed between two LocalDate **********\n");
		Period tenDays = Period.between(LocalDate.of(2014, 3, 8), LocalDate.of(2014, 3, 18));
		Period tenDays1 = Period.ofDays(10);
		Period threeWeeks = Period.ofWeeks(3);
		Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
		System.out.println("tenDays = " + tenDays);
		System.out.println("tenDays1 = " + tenDays1);
		System.out.println("threeWeeks = " + threeWeeks);
		System.out.println("twoYearsSixMonthsOneDay = " + twoYearsSixMonthsOneDay);
	}

}
