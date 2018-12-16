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

        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");
        int datekey = 20160720;
        LocalDate localDate1 = dtf.parseLocalDate(Integer.toString(datekey));
        int datekey2 = Integer.parseInt(dtf.print(localDate1));
        System.out.println("datekey="+datekey +",datekey2="+datekey2);

        System.out.println("上月1号: "+ dtf.print(localDate1.minusMonths(1)
                .dayOfMonth()
                .withMinimumValue()));

        System.out.println("localDate1 changed to "+localDate1);
    }

    /**
     * datekey like 20160629
     */
    private static LocalDate formatDatekey(int datekey){
        DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");
        return dtf.parseLocalDate(Integer.toString(datekey));
    }



}
