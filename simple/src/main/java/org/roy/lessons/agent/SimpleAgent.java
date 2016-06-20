package org.roy.lessons.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by lilei on 16/6/16.
 */
public class SimpleAgent {
    public static void premain(String args, Instrumentation inst) {
        System.out.println("args: " + args);
        System.out.println("Simple java Agent");
        System.out.println("inst: " + inst);
        System.out.println("loaded class length: " + inst.getAllLoadedClasses().length);
    }
}
