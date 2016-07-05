package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;
import static org.roy.lessons.TIJ4th.common.util.Print.*;

public class Ex02 {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		Set<String> set = map.keySet();
		int cnt = 0;
		String regex = "^A.*";
		for (String name : Countries.names()) {
			if (name.matches(regex)) {
				map.put(name, cnt++);
			}
		}
		print(set);
		print(map);
	}
}
