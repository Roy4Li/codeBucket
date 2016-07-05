package org.roy.lessons.TIJ4th.Chpt17;

import java.util.AbstractList;
import static org.roy.lessons.TIJ4th.common.util.Print.*;

public class CountingIntegerList extends AbstractList<Integer> {
	
	private int size;
	
	public CountingIntegerList(int i){
		this.size = i;
	}
	
	@Override
	public Integer get(int index) {
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		print(new CountingIntegerList(25));
	}
}
