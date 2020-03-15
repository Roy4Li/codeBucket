package org.roy.lessons.jcp;

public class ThreadLocalCase {

    public void putToThreadLocal(ThreadLocal<String> local,String value){
        local.set(value);
    }

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("abc");
        System.out.println("before="+local.get());
        ThreadLocalCase oneCase = new ThreadLocalCase();
        oneCase.putToThreadLocal(local,"111");
        System.out.println("after="+local.get());
    }
}
