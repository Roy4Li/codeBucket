/*
 * Copyright (c) 2010-2018 meituan.com
 * All rights reserved.
 * 
 */
package org.roy.lessons.xjtdd;

/**
 * @author lilei
 * @date 2019/06/09
 */
public class GameNumber {

    public static String say(int i) {
        if (isRelatedTo(i, 3) && isRelatedTo(i, 5)) {
            return "FizzBuzz";
        }
        if (isRelatedTo(i, 3)) {
            return "Fizz";
        }
        if (isRelatedTo(i, 5)) {
            return "Buzz";
        }
        return i + "";
    }

    private static boolean isRelatedTo(int i, int y) {
        return i % y == 0 || Integer.toString(i).contains(y + "");
    }
}