package org.roy.lessons.temp;

import com.google.common.collect.Lists;

import java.util.ArrayList;

public class DIDIDemo {


    // split
    public static void main(String[] args) {
        ArrayList<String> result = split("abcdefg", "cd");
        System.out.println(result);


    }

    // input delimeter array
    // ab cd e fg, cd,fg
    public static ArrayList<String> split(String str, String d1) {
        ArrayList<String> retList = Lists.newArrayList();
        String temp = str;
        while(temp.indexOf(d1) > 0){
            int firstMatch = temp.indexOf(d1);
            String matched = temp.substring(0, firstMatch);
            retList.add(matched);
            temp = temp.substring(firstMatch + d1.length());
        }
        retList.add(temp);
        return retList;
    }

    // 菜品 标准tag

}
