package org.roy.lessons.jvm;

import java.util.*;

public class HeapOOMDemo {
	
	private Integer age;
	private String name;
	private Byte[]  ptr;
	public static void testTmp(){
		List<HeapOOMDemo> objs = new ArrayList<HeapOOMDemo>();
		while(true){
			HeapOOMDemo t = new HeapOOMDemo();
			t.ptr = new Byte[1024 * 1024 * 2];
			objs.add(t);
		}
	}
	
	public static void main(String[] args) {
		testAllocation();
	}
	
	/**	
	 * vm args: -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	 * 
	 */
	public static void testAllocation(){
		byte[] alc1,alc2,alc3,alc4,alc5;
		alc1 = new byte[4 * 1024 * 1024];
//		alc2 = new byte[4 * 1024 * 1024];
//		alc3 = new byte[4 * 1024 * 1024];
//		alc4 = new byte[3 * 1024 * 1024];
//		alc5 = new byte[4 * 1024 * 1024];
	}
}
