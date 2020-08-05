package org.roy.lessons.temp;

public class IntDemo {

    public static void main(String[] args) {
        // 两个Integer对象
        Integer i10_1 = new Integer(10);
        Integer i10_2 = new Integer(10);
        System.out.println("Int10 == Int10:" + (i10_1 == i10_2));
        System.out.println("Int10 equals Int10:" + (i10_1.equals(i10_2)));

        // valueOf < 128的情况
        Integer v10_1 = 10;
        Integer v10_2 = 10;
        System.out.println("v10==v10" + (v10_1 == v10_2));

        Integer v129_1 = Integer.valueOf(127);
        Integer v129_2 = Integer.valueOf(127);
        System.out.println("v129 == v129" + (v129_1 == v129_2));

    }
}
