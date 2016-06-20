package org.roy.lessons.agent;

import org.apache.commons.lang3.StringUtils;
import org.roy.lessons.agent.trans.Duration;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 */
public class Agent {
    public static void premain(String args, Instrumentation inst) {

        System.out.println("prepain invoked!!");
        System.out.println("premain args:" + args);
        if (StringUtils.isNotBlank(args)) {
            inst.addTransformer(new Duration("org/roy/lessons/agent/client/ClientMain"));
        }
    }

    public static void agentmain(String args, Instrumentation inst) {
        System.out.println("agentmain invoked!!");
        System.out.println("agentmain args:" + args);
        inst.addTransformer(new Duration("org/roy/lessons/agent/client/service/CalService"));
    }
}
