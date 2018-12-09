package org.roy.lessons.temp;


public class PatternDemo {
    public static final String HOTEL_INFO_COMPLETE_URL_NEW = "https://tdc.meituan.com/hfe/insert/hotel_error/index.html?poiId={poiId}#/baseinfo";
    private static final String PATTERN = "^1[0-9]{10}|[0-9]{3,4}-[0-9]{7,8}$";

    public static void main(String[] args) {
//        String s1 = "0021-05510102";
//        sout(s1, PATTERN);
//
//        String s2 = "10102030405";
//        sout(s2, PATTERN);
//
//        String s3 = "";
//        sout(s3, PATTERN);

//        String s4 = HOTEL_INFO_COMPLETE_URL_NEW.replace("{poiId}", "12333");
//        System.out.println("s4=" + s4);

        String s5 = "aaaa";
       String s6= s5.replace("aa","a");
        System.out.println("s6="+s6);
    }

    private static void sout(String s, String pattern) {
        System.out.println("[" + s + "]" + ".match(" + PATTERN + ")=" + s.matches(pattern));
    }
}
