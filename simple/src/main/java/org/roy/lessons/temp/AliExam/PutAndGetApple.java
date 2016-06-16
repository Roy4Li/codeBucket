package org.roy.lessons.temp.AliExam;

// add test
public class PutAndGetApple {

	static final int basketVol = 5;
	int appleCount = 0;
	Object lock = new Object();

	public static void main(String[] args) {
		PutAndGetApple game = new PutAndGetApple();
		Thread putThread = new Thread(game.new ApplePutter());
		Thread getThread = new Thread(game.new AppleGetter());
		putThread.start();
		getThread.start();
	}

	public class ApplePutter implements Runnable {
		synchronized void putApple() {
			synchronized (lock) {
				if (appleCount < basketVol) {
					appleCount++;
					System.out.println("put 1 apple,now has " + appleCount
							+ "  apples");
				}
			}
		}

		public void run() {
			while (true) {
				this.putApple();
			}
		}
	}

	public class AppleGetter implements Runnable {
		synchronized void getApple() {
			synchronized (lock) {
				if (appleCount > 0) {
					appleCount--;
					System.out.println("Get 1 apple,now left " + appleCount
							+ "  apples");
				}
			}

		}

		public void run() {
			while (true) {
				this.getApple();
			}
		}
	}

}
