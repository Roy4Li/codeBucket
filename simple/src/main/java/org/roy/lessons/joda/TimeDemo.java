package org.roy.lessons.joda;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Created by lilei on 16/7/5.
 */
public class TimeDemo {
    public static void main(String[] args) {
        LocalDate localDate = new LocalDate();
        System.out.println(localDate);
        System.out.println("day of week is : " + localDate.getDayOfWeek());
        System.out.println("formatDatekey : "+ formatDatekey());
    }

    /**
     * datekey like 20160629
     */
    private static LocalDate formatDatekey(){
        int datekey = 20160629;
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");
        return dtf.parseLocalDate(Integer.toString(datekey));
    }

}
