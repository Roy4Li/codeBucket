package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;

public class Ex07 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>(Countries.names(10));
		print("list1 : "+list1);
		List<String> list2 = new LinkedList<String>(Countries.names(10));
		print("list2 : "+list2);
		Iterator<String> it1 = list1.iterator();
		Iterator<String> it2 = list2.iterator();
		print("---ArrayList iterator ----");
		while(it1.hasNext())
			print(it1.next());
		print("---LinkedList iterator ----");
		while(it2.hasNext())
			print(it2.next());
		ListIterator<String> lit1 = list1.listIterator(list1.size());
		ListIterator<String> lit2 = list2.listIterator();
		while(lit2.hasNext()){
			lit1.add(lit2.next());
			lit1.previous();
			lit1.previous();
		}
		print("After one by one insert : \nlist 1 : "+list1);
	}

}
