package org.roy.lessons.TIJ4th.Chpt21;

import java.util.concurrent.*;

class Task1 implements Runnable{
	@Override
	public void run() {
		synchronized(this){
			System.out.println("Task1 start to wait...");
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Task1 interrupted");
			}
			System.out.println("Task1 wait over");
		}
	}
}

class Task2 implements Runnable{
	private Runnable otherTask;
	public Task2(Task1 t){otherTask = t;}
	@Override
	public void run() {
		try {
			System.out.println("Task2 wait some time");
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Task2 notifyAll");
		synchronized(otherTask){
			otherTask.notifyAll();
		}
	}
}

public class Ex21 {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Task1 t = new Task1();
		exec.execute(t);
		exec.execute(new Task2(t));
		exec.shutdown();
	}
}
