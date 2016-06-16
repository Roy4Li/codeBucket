package org.roy.lessons.TIJ4th.Chpt21;

import java.util.concurrent.*;

public class Ex18 {
	static class SleepKing {
		public static void justSleep() throws InterruptedException {
			TimeUnit.SECONDS.sleep(5);
		}
	}

	static class Task1 implements Runnable {
		public void run() {
			System.out.println("task begin running,call justSleep()");
			try {
				SleepKing.justSleep();
			} catch (InterruptedException e) {
				System.out.println("InterruptedException!");
			} finally {
				System.out.println("task end 1");
			}
			System.out.println("task over");
		}
	}

	static class Task2 implements Runnable {
		@Override
		public void run() {
			double[] nums = new double[0x10000];
			int index = 0;
			while (!Thread.interrupted()) {
				// time-consuming operating
				nums[index] = Math.PI + index + 1 / Math.E;
				index = index >= nums.length - 1 ? 0 : index + 1;
			}
			System.out.println("Exit after interrupt");
			// clean interrupt
			if(!Thread.currentThread().isInterrupted()){
				System.out.println("Interrupt flag been cleaned");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 1; i++) {
			exec.execute(new Task2());
		}
		TimeUnit.MILLISECONDS.sleep(100);
		exec.shutdownNow();
		// exec.shutdown();
	}
}
