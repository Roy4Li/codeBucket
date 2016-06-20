package org.roy.lessons.TIJ4th.Chpt21;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

public class Ex06 {

	class TaskSleep implements Callable<Integer>{
		private int id;
		public TaskSleep(int n){
			id = n;
		}
		
		public Integer call(){
			Random rand = new Random();
			int sleepSec = rand.nextInt(11);
			Long startMil = System.currentTimeMillis();
			System.out.println(new Date().toString() + " TaskSleep id :"+id+" begin to sleep");
			try {
				TimeUnit.SECONDS.sleep(sleepSec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Long endMil = System.currentTimeMillis();
			System.out.println(new Date().toString()+" TaskSleep id :"+id+" wake up");
			System.out.println("TaskSleep id :"+id+" sleeped "+(endMil - startMil)/1000+" seconds");
			return sleepSec;
		}
	}
	
	public void simpleRun(){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<Integer>> res = new ArrayList<Future<Integer>>();
		for(int i=0;i<10;i++){
			res.add(exec.submit(this.new TaskSleep(i)));	
		}
		int index = 0;
		for(Future<Integer> s:res){
			try {
				System.out.println(index++ +" : "+ s.get());
			} catch (Exception e) {
				System.out.println(e);
			} finally{
				exec.shutdown();
			}
		}
	}
	
	public static void main(String[] args) {
		Ex06 inst = new Ex06();
		inst.simpleRun();
	}

}
