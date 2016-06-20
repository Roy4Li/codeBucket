package org.roy.lessons.TIJ4th.Chpt21;

import java.util.Random;
import java.util.concurrent.*;

public class ThreadLocalDemo {
	static private ThreadLocal<Integer> intLocal = new ThreadLocal<Integer>(){
		@Override
		protected Integer initialValue(){
			Random rand = new Random();
			return rand.nextInt(1000);
		}
	};
	
	static private ThreadLocal<String> strLocal = new ThreadLocal<String>(){
		@Override
		protected String initialValue(){
			Random rand = new Random();
			int len = rand.nextInt(10) + 1;
			char[] chs = new char[len];
			for(int i=0;i<len;i++){
				chs[i] = (char)((int)'a' + rand.nextInt(27));
			}
			return new String(chs);
		}
	};
	
	static class Task implements Runnable{
		private int id;
		public Task(int n){
			id = n;
		}
		@Override
		public void run(){
			System.out.println("#("+id+") intLocal is: "+intLocal.get());
			System.out.println("#("+id+") StringLocal is: "+strLocal.get());
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<10;i++){
			exec.execute(new Task(i));
		}
		exec.shutdown();
	}

}
