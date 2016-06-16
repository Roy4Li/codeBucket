package org.roy.lessons.TIJ4th.Chpt21;

import java.util.*;
import java.util.concurrent.*;

public class CallableDemo {
	
	class TaskWithResult implements Callable<String>{
		private int id;
		public TaskWithResult(int n) {
			id = n;
		}
		
		@Override
		public String call(){
			return "TaskWithResult id is : "+ id;
		}
	}
	
	public void simpleRun(){
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> res = new ArrayList<Future<String>>();
		for(int i=0;i<5;i++){
			res.add(exec.submit(this.new TaskWithResult(i)));
		}
		for(Future<String> s:res){
			try {
				System.out.println(s.get());
			} catch (Exception e) {
				System.out.println(e);
			} finally{
				exec.shutdown();
			}
		}
	}
	
	public static void main(String[] args) {
		CallableDemo inst = new CallableDemo();
		inst.simpleRun();
	}
}
