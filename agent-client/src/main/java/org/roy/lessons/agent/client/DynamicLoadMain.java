package org.roy.lessons.agent.client;

import com.sun.tools.attach.VirtualMachine;
import org.roy.lessons.agent.client.service.CalService;

import java.lang.management.ManagementFactory;

/**
 * Created by lilei on 16/6/20.
 */
public class DynamicLoadMain {
    private static final String jarPath = "/Users/lilei/Dev/codeBucket/agent/agent-jar-with-dependencies.jar";

    public static void main(String[] args) {
        hello();
        loadAgent();
        CalService calService = new CalService();
        System.out.println("add ret = " + calService.add(3, 4));
    }

    private static void hello() {
        System.out.println("say hello to every one!");
        for (int i = 0; i < 3; i++) {
            System.out.println("hello,i = " + i);
        }
    }

    public static void loadAgent() {
        String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        int p = nameOfRunningVM.indexOf('@');
        String pid = nameOfRunningVM.substring(0, p);

        try {
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(jarPath, "helloAgentMain");
            vm.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
