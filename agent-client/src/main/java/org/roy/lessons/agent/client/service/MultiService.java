package org.roy.lessons.agent.client.service;

/**
 * Created by lilei on 16/6/20.
 */
public class MultiService {
    public MultiService() {
        System.out.println("MultiService constructed!");
    }

    public Integer mul(int i, int j) {
        System.out.println("MultiService mul , i=" + i + " ,j=" + j);
        return i * j;
    }
}
