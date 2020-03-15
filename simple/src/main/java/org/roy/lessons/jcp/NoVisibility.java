package org.roy.lessons.jcp;

public class NoVisibility {
    private static boolean ready;
    private static int number;
    private Object lock = new Object();

    public  void method1() {
        synchronized (lock) {
            number++;
        }
    }

    public  void method2() {
        // 字节码中有 MONITORENTER/MONITOREXIT指令
        synchronized (lock) {
            number--;
        }
    }

    public static void main(String[] args) {
        NoVisibility instance = new NoVisibility();
        instance.method1();
        instance.method2();
    }
}
