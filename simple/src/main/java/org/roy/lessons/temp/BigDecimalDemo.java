package org.roy.lessons.temp;

import java.math.BigDecimal;

/**
 * Created by lilei on 2017/2/6.
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal first = new BigDecimal(11);
        System.out.println("first to plain string : " + first.toPlainString());

        BigDecimal second = BigDecimal.valueOf(112.3);
        System.out.println("second to plain string: "+second.toPlainString());

        BigDecimal third = BigDecimal.valueOf(-3112.3);
        System.out.println("third to plain string: "+third.toPlainString());

        BigDecimal fourth = BigDecimal.valueOf(3.0);
        System.out.println("fourth to plain string: "+fourth.toPlainString());
    }
}
