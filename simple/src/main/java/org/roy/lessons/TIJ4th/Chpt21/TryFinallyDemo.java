package org.roy.lessons.TIJ4th.Chpt21;

public class TryFinallyDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getString());

	}

	static String getString() {
		try {
			System.out.println("in try");
			return "SUCCESS";
		} catch (Exception e) {

		} finally {
			System.out.println("Finally is executing");
//			return "ERROR";// 如果这句放在finally之外呢？
		}
		return "  ";
	}
}
