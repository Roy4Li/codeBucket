package org.roy.lessons.agent.client;

import org.roy.lessons.agent.client.service.CalService;
import org.roy.lessons.agent.client.service.MultiService;

import java.util.concurrent.TimeUnit;

/**
 * Created by lilei on 16/6/17.
 */
public class ClientMain {

    public static void main(String[] args) {
        int n = 3;
        System.out.println("client main invoked !!");
        try {
            System.out.println("client main starts sleep " + n + " seconds");
            TimeUnit.SECONDS.sleep(n);
        } catch (InterruptedException e) {
            System.out.println("client main sleep got exception!");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("client main ends");
        hello();
        new MultiService().mul(3,4);

        DynamicLoadMain.loadAgent();
        new CalService().add(3,4);
    }

    public static void hello() {
        System.out.println("say hello to every one!");
        for (int i = 0; i < 3; i++) {
            System.out.println("hello,i = " + i);
        }
    }

}
