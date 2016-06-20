package org.roy.lessons.agent.client;

import java.util.concurrent.TimeUnit;

/**
 * Created by lilei on 16/6/17.
 */
public class ClientMain {

    public static void main(String[] args) {
//        int n = 3;
//        System.out.println("client main starts!!");
//        try {
//            System.out.println("client main starts sleep " + n + " seconds");
//            TimeUnit.SECONDS.sleep(n);
//        } catch (InterruptedException e) {
//            System.out.println("client main sleep got exception!");
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//        System.out.println("client main ends");
        hello();
    }

    private static void hello() {
        System.out.println("say hello to every one!");
        for (int i = 0; i < 10; i++) {
            System.out.println("hello,i = " + i);
        }
    }

}
