package org.roy.lessons.TIJ4th.Chpt21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Ex01 {
	private static int taskId = 0; 
	public class MessagePrinter implements Runnable{
		private final int cnt = taskId++;
		public MessagePrinter(){
			print("message printer #("+ cnt+") was born");
		}
		@Override
		public void run() {
			for(int i=0;i<3;i++){
				print("message printer #("+ cnt+") was running");
//				Thread.yield();
				try {
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally{
					System.out.println("message printer #("+ cnt+") "+"lasts forever ?? ");
				}
			}
			print("message printer #("+ cnt+") exits");
			return;
		}
	}
	public void useOriginalThread(){
		for(int i=0;i<5;i++){
			Thread t = new Thread(this.new MessagePrinter());
			t.start();
		}
	}
	
	public void useCachedThreadPool(){
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(this.new MessagePrinter());
		}
		exec.shutdown();
	}
	
	public void useNumFixedThreadPool(){
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exec.execute(this.new MessagePrinter());
		}
		exec.shutdown();
	}
	
	public void useSingletonThreadPool(){
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++){
			exec.execute(this.new MessagePrinter());
		}
		exec.shutdown();
	}
	
	public void useDaemonThread(){
		ExecutorService exec = Executors.newCachedThreadPool(new ThreadFactory(){
			public Thread newThread(Runnable r){
				Thread t = new Thread(r);
				t.setDaemon(true);
				return t;
			}
		});
		for(int i=0;i<5;i++){
			exec.execute(this.new MessagePrinter());
		}
		Thread t = new Thread(new Runnable(){
			public void run(){
				System.out.println("Non-daemon thread running");
				try {
					TimeUnit.MILLISECONDS.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println("Non-daemon thread interrupted");
					e.printStackTrace();
				} finally {
					System.out.println("Non-daemon thread exit");
				}
			}
		});
		t.start();
		exec.shutdown();
	}
	
	public static void main(String[] args) {
		Ex01 inst = new Ex01();
//		inst.useCachedThreadPool();
//		inst.useNumFixedThreadPool();
//		inst.useOriginalThread();
//		inst.useSingletonThreadPool();
		inst.useDaemonThread();
	}
}
