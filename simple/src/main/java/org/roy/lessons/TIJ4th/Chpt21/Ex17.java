package org.roy.lessons.TIJ4th.Chpt21;

import java.util.concurrent.*;

public class Ex17 {

	static class RadioCount {
		private int cnt = 0;

		public synchronized void increment() {
			cnt++;
		}

		public synchronized int getCnt() {
			return cnt;
		}
	}

	static class Sensor implements Runnable {
		private static volatile boolean canceld = false;
		private static RadioCount radioCount = new RadioCount();
		
		private int id;
		private int num = 0;
		
		public Sensor(int n){
			id = n;
		}
		
		@Override
		public void run() {
			while (!canceld) {
				num++;
				radioCount.increment();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(this + " stopped;Total="+radioCount.getCnt());
		}
		
		public static void cancel(){canceld = true;}
		@Override
		public String toString(){
			return "Sensor#("+id+"):num="+num;
		}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exec.execute(new Sensor(i));
		}
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Sensor.cancel();
		exec.shutdown();
		try {
			if(!exec.awaitTermination(1, TimeUnit.SECONDS)){
				System.out.println("Threads still running...");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
