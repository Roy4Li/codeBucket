package org.roy.lessons.agent;

import org.apache.commons.lang3.StringUtils;
import org.roy.lessons.agent.trans.Timing;

import java.lang.instrument.Instrumentation;

/**
 * Hello world!
 */
public class AgentMain {
    public static void premain(String args, Instrumentation inst) {

        System.out.println("agent starts! prepain invoked!!");
        System.out.println("args:" + args);
        if (StringUtils.isNotBlank(args)) {
            inst.addTransformer(new Timing(args));
        }
    }
}
