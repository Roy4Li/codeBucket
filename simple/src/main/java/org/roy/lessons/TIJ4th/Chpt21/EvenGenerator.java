package org.roy.lessons.TIJ4th.Chpt21;

import java.util.concurrent.locks.*;

public class EvenGenerator extends IntGenerator {

	private int currentEvenValue = 0;
	// one instance per class
	private static final Lock lock = new ReentrantLock();
	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue; // Danger point here!
			Thread.yield();
			++currentEvenValue;
			Thread.yield();
			return currentEvenValue;
		} finally{
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}
}
