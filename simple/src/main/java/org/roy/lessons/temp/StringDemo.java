package org.roy.lessons.temp;

/**
 * Created by lilei on 2017/4/1.
 */
public class StringDemo {
    public static void main(String[] args) {
//        String s = "/workorder/pmsApp/api/v1/";
//        System.out.println("result=" + s.startsWith("/workorder/pmsApp/"));

        String s1 = "2017-03-03";
        System.out.println("s1.matches=" + s1.matches("\\d{4}-\\d{2}-\\d{2}"));
    }
}
