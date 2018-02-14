package zikzakjack;

import java.time.DayOfWeek;
import java.time.LocalDate;
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

		System.out.println("\n********** LocalDateTime **********\n");

		System.out.println("\n********** Instant **********\n");

		System.out.println("\n********** Duration **********\n");

		System.out.println("\n********** Period **********\n");

	}

}
