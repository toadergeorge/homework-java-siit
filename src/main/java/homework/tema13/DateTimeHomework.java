package homework.tema13;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DateTimeHomework {
    public static void main(String[] args) {

        //2. Write a method that, for a given year, reports the length of each month within that year.
        LinkedHashMap<String, Integer> monthsLength = getAllMonthDaysByYears(2020);
        monthsLength.forEach((month, days) -> System.out.println("month = " + month + " days " + days));

        //3. Write a method that, for a given month of the current year, lists all of the Mondays in that month.
        ArrayList mondaysOfMonth = getMondaysFromMonth(13);
        mondaysOfMonth.forEach(System.out::println);


        // 4. Write an example that tests whether a given date occurs on Friday the 13th.
        boolean isFriday = isFridayThirteen("03-13-2020");
        System.out.println("isFriday = " + isFriday);
    }

    /**
     * @param date
     * @return
     */
    public static boolean isFridayThirteen(String date) {
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        DayOfWeek dayOfWeek = inputDate.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.FRIDAY && inputDate.getDayOfMonth() == 13) {
            return true;
        }
        return false;
    }

    /**
     * @param monthNumber
     * @return
     */
    public static ArrayList<Integer> getMondaysFromMonth(int monthNumber) {
        ArrayList<Integer> mondayDays = new ArrayList<>();

        if (monthNumber > 12 || monthNumber < 1) {
            return mondayDays;
        }
        LocalDate today = LocalDate.now();
        int currentYear = today.getYear();

        LocalDate date = LocalDate.of(currentYear, monthNumber, 1);
        int daysOfMonth = date.lengthOfMonth();

        for (int day = 1; day <= daysOfMonth; day++) {
            LocalDate dateNew = LocalDate.of(currentYear, monthNumber, day);
            if (dateNew.getDayOfWeek() == DayOfWeek.MONDAY) {
                mondayDays.add(day);
            }
        }

        return mondayDays;
    }


    /**
     * @param year
     * @return
     */
    public static LinkedHashMap<String, Integer> getAllMonthDaysByYears(int year) {
        LinkedHashMap<String, Integer> daysOfMonths = new LinkedHashMap<>();
        for (int i = 1; i < 12; i++) {
            LocalDate date = LocalDate.of(year, i, 1);
            int days = date.lengthOfMonth();
            daysOfMonths.put(date.getMonth().name(), days);
        }
        return daysOfMonths;
    }
}
