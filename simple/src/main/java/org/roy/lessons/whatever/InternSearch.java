package org.roy.lessons.whatever;

/**
 * Created by lilei on 16/9/7.
 */
public class InternSearch {

    public static void main(String[] args) {
        // JDK 1.7开始,intern()方法不再将字符串复制到永久代,而是在常量池中记录首次出现的示例引用
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        // 这个例子更好的说明了问题,不是首次出现的字符串常量
        // todo 常量池是如何记录首次出现的字符串的引用的?
        String str1_1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1_1.intern() == str1_1);

        // "java"字符串不是首次出现的示例引用
        String str2 = new StringBuilder("jav").append("a").toString();
        System.out.println(str2.intern() == str2);
    }
}
