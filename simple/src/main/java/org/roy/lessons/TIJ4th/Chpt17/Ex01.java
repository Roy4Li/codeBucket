package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;

public class Ex01 {

	public static void main(String[] args) {
		int cnt = 10;
		List<String> arrlist = new ArrayList<String>(Countries.names(10));
		print("before shuffle: " + arrlist + "\r\n");
		for (int i = 0; i < cnt; i++) {
			Collections.shuffle(arrlist);
			print("after shuffle " + (i+1) + ": " + arrlist + "\r\n");
		}

		List<String> llist = new LinkedList<String>(Countries.names(10));
		print("before shuffle: " + llist + "\r\n");
	}
}
