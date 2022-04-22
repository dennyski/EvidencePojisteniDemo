package cz.denny.itccave;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    public static final DateTimeFormatter FORMAT_DATE_TIME = DateTimeFormatter.ofPattern("dd'.'MM'.'y HH:mm"); // dd MM maintains menuTime consistent.
    public static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("d'.'M'.'yyyy");

    public static LocalDateTime getDateTime() {
        return LocalDateTime.now();
    }

    public static void printNow() {
        System.out.println(FORMAT_DATE.format(LocalDateTime.now()));
    }

    public static void printFull() {
        System.out.println(LocalDateTime.now().getDayOfWeek() + " " + FORMAT_DATE_TIME.format(LocalDateTime.now()));
    }

    @Override
    public String toString() {
        return "Today is [" + LocalDateTime.now().getDayOfWeek() +
                " " + FORMAT_DATE_TIME.format(LocalDateTime.now()) +
                "]";
    }
}
