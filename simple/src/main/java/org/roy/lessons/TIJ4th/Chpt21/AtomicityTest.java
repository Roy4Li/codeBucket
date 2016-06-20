package org.roy.lessons.TIJ4th.Chpt21;

//: concurrency/AtomicityTest.java
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AtomicityTest implements Runnable {
	private int i = 0;
	private Lock lock = new ReentrantLock();
	private Object lock1 = new Object();
	public synchronized int getValue() {
		return i;
	}

	private synchronized void evenIncrement() {
		i++;
		i++;
	}

	public void run() {
		while (true)
			evenIncrement();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while (true) {
			int val = at.getValue();
			if (val % 2 != 0) {
				System.out.println(val);
				System.exit(0);
			}
		}
	}
} 

/*
 * Output: (Sample) 191583767
 */// :~

