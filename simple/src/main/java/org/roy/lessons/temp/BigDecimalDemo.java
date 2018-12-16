package org.roy.lessons.temp;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by lilei on 2017/2/6.
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal first = new BigDecimal(11);
        System.out.println("first to plain string : " + first.toPlainString());

        BigDecimal second = BigDecimal.valueOf(112.3);
        System.out.println("second to plain string: " + second.toPlainString());

        BigDecimal third = BigDecimal.valueOf(-3112.3);
        System.out.println("third to plain string: " + third.toPlainString());

        BigDecimal fourth = BigDecimal.valueOf(3.0);
        System.out.println("fourth to plain string: " + fourth.toPlainString());

        //
        List<Integer> iArr = Lists.newArrayList(0, 333, 1100, 11010, 11011);
        iArr.forEach(e -> strip(e));
    }

    private static void strip(int raw) {
        String str = BigDecimal.valueOf((float) raw / 100).setScale(2, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
        System.out.println(String.format("raw=%s,str=%s", raw, str));
    }
}
