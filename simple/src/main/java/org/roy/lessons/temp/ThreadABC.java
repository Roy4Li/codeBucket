package org.roy.lessons.temp;

import java.util.concurrent.atomic.AtomicInteger;

// 3个线程循环打印ABC，一个打印A，一个打印B，一个打印C
public class ThreadABC implements Runnable {
	private static int lock = 0;
	private char ch;
	private int key = 0;
	private ThreadABC(char c,int keyV) {
		this.ch = c;
		this.key = keyV;
	}

	public void run() {
		AtomicInteger ac = new AtomicInteger();
		ac.incrementAndGet();
		int cnt = 10;
		while (cnt > 0) {
			if(key == lock){
				System.out.print(ch);
				cnt--;
				lock++;
				lock %= 3;
			}
		}
	}

	public static void main(String[] args) {
		ThreadABC pa = new ThreadABC('A',0);
		ThreadABC pb = new ThreadABC('B',1);
		ThreadABC pc = new ThreadABC('C',2);
		new Thread(pa).start();
		new Thread(pb).start();
		new Thread(pc).start();
	}
}
