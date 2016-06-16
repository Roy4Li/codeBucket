package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;

public class Ex11 {

	static class PriorityType implements Comparable<PriorityType> {
		private Integer first;

		public PriorityType() {
			first = new Random().nextInt(100);
		}

		public PriorityType(Integer i) {
			first = i;
		}
		
		
		public int compareTo(PriorityType o) {
			return first < o.first ? -1 : (first == o.first ? 0 : 1);
		}

		public String toString() {
			return first.toString();
		}

		public List<PriorityType> getList(int num) {
			List<PriorityType> list = new ArrayList<PriorityType>(num);
			for (; num > 0; num--)
				list.add(new PriorityType());
			return list;
		}
	}

	public static void main(String[] args) {
		PriorityQueue<PriorityType> queue = new PriorityQueue<PriorityType>();
		for(int i=0;i<10;i++){
			PriorityType ele = new PriorityType();
			print("add "+ ele.first+" ");
			queue.add(ele);
		}
		print();
		print(queue);
		while(!queue.isEmpty()){
			print(queue.poll()+" ");
		}
	}
}
