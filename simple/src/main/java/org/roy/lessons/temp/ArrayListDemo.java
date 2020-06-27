package org.roy.lessons.temp;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        System.out.println( 15 >> 1);
        // 初始化size为0的一个Object数组
        // 第一次add时,
        ArrayList<Integer> toAddList = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            toAddList.add(i);
        }

        ArrayList<Integer> intList = new ArrayList<>(20);
        intList.addAll(toAddList);
        intList.add(20);
        intList.add(21);
        System.out.println(intList.size());
    }
}
