package org.roy.lessons.agent.client.service;

/**
 * Created by lilei on 16/6/20.
 */
public class CalService {
    public CalService() {
        System.out.println("CalService constructed!");
    }

    public Integer add(int i, int j) {
        System.out.println("CalService add , i=" + i + " ,j=" + j);
        return i + j;
    }
}
