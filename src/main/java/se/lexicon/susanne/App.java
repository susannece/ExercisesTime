package se.lexicon.susanne;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class App
{
    public static void main( String[] args )
    {
        //Exercise 1: Create a LocalDate of the current day and print it out
        LocalDate today = LocalDate.now();
        System.out.println( "Date today " + today );

        //Exercise2:
        //Create a LocalDate of the current day and print it out in the following pattern
        // using DateTimeFormatter: Torsdag 29 mars.
        String formatDate = today.format(DateTimeFormatter.ofPattern("eeee dd MMM"));
        System.out.println(formatDate);

        //Exercise3:
        //Create a LocalDate of last Monday.
        // Then print out the entire week in a loop using standard ISO format.

        LocalDate oneWeek = LocalDate.parse("2021-12-20");
        for (int i = 0; i < 7; i++) {
            System.out.println(oneWeek);
            oneWeek = oneWeek.plus(Period.ofDays(1));
        }
        //Exercise 4:
        //Create a LocalDate object from a String by using the .parse() method.
        LocalDate date = LocalDate.parse("2021-12-29");
        System.out.println(date);

        //Exercise5
        //The date time api provides enums for time units such as day and month.
        // Create a LocalDate of 1945-05-08 and extract the day of week for that date.
        LocalDate date5 = LocalDate.parse("1945-05-08");
        DayOfWeek day = date5.getDayOfWeek();
        System.out.println(day);

        //Exercise6
        //Create a LocalDate of current date plus 10 years and minus 10 months.
        //From that date extract the month and print it out.
        LocalDate date6 = LocalDate.now();
        date6 = date6.plusYears(10).minusMonths(10);
        System.out.println(date6);
        Month month = date6.getMonth();
        System.out.println(month);

        //Exercise7
        //Using the LocalDate from exercise 6 and your birthdate, create a Period
        // between your birthdate and the date from exercise 5.
        // Print out the elapsed years, months and days.
        LocalDate myBirthDate = LocalDate.parse("1964-08-13");
        Period period = Period.between(date5, myBirthDate);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        System.out.println( years + "years," + months + " months, and " + days + " days" );

        //Exercise 8
        // ++++ Fungerar men inte som uppgiften
        //Create a period of 4 years, 7 months and 29 days. Then create a LocalDate of
        //current date and add the period you created to the current date.
 //       Period period8 = new Period(4,7,29);
        LocalDate currentDate = LocalDate.now();
        currentDate.plus(Period.ofYears(4));
        currentDate.plus(Period.ofMonths(7));
        currentDate.plus(Period.ofDays(29));
        System.out.println(currentDate);

        //Exercise 9
        //Create a LocalTime object of the current time.
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);

        // Exercise 10
        //Extract the nanoseconds of a LocalTime object of current time.
        //Print out the nanoseconds.
        System.out.println("Nanoseconds:" + nowTime.getNano());

        //Exercise 11
        //Create a LocalTime object from a String using the .parse() method.
        LocalTime myTime = LocalTime.parse("09:18:35");
        System.out.println(myTime);

        //Exercise 12
        //Using DateTimeFormatter format LocalTime from current time and
        // print it out as following pattern: 10:32:53
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime.truncatedTo(ChronoUnit.SECONDS));

        //Exercise 13
        //Create a LocalDateTime with the date and time components as:
        // date: 2018-04-05, time: 10.00.
        LocalDateTime dateTime = LocalDateTime.parse("2018-04-05T10:00");
        System.out.println("Date " + dateTime.toLocalDate() + ", Time " + dateTime.toLocalTime());

        //Exercise 14
        //Using DateTimeFormatter format the LocalDateTime object from exercise 11
        // to a String that should look tile this: torsdag 5 april 10:00
        String str = dateTime.format(DateTimeFormatter.ofPattern("eeee dd MMM HH:mm"));
        System.out.println(str);

        //Exercise 15
        //Create a LocalDateTime object by combining LocalDate object and LocalTime object.
        LocalDateTime combo = LocalDateTime.of( LocalDate.now(), LocalTime.now() ) ;
        System.out.println("combo " + combo);

        //Exercise 16
        //Create a LocalDateTime object. Then get the LocalDate and LocalTime components
        // into separate objects of respective types from the LocalDateTime object.
        LocalDateTime obj = LocalDateTime.now();
        LocalDate sepDate = obj.toLocalDate();
        LocalTime sepTime = obj.toLocalTime();
        System.out.println("Date: " + sepDate + " Time: " + sepTime);
    }
}
