package zikzakjack;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoField;

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

		System.out.println("\n********** Instant **********\n");

		System.out.println("\n********** Duration **********\n");

		System.out.println("\n********** Period **********\n");

	}

}
