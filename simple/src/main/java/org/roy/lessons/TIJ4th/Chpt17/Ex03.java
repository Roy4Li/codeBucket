package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;

public class Ex03 {

	public static void main(String[] args) {
		int size1 = 0,size2=0;
		Set<String> set = new HashSet<String>();
		set.addAll(Countries.names());
		size1 = set.size();
		print("size1 : "+size1);
		set.addAll(Countries.names());
		size2 = set.size();
		print("size2 : "+size2);
	}
}
