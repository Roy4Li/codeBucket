package org.roy.lessons.TIJ4th.Chpt11;

import java.util.*;

public class Generator extends Base{
	static private String[] filmNames = {"Star war","American story","God Father",
		"American Pie","Hungry Game","The Fast And Furious"};
	static private int index = 0; 
	
	public static String next(){
		return filmNames[index++ % filmNames.length];
	}
	
	public static void main(String[] args) {
		//fill arrays
		String[] arr = new String[8];
		for(int i=0;i<8;i++)
			arr[i] = next();
		// fill ArrayList
		List<String> arrList = new ArrayList<String>();
		Collections.addAll(arrList, arr);
		// fill LinkedList
		LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList(arr));
		// fill HashSet
		HashSet<String> hashSet = new HashSet<String>(Arrays.asList(arr));
		// fill LinkedHashSet
		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(Arrays.asList(arr));
		// fill TreeMap
		TreeSet<String> treeSet = new TreeSet<String>(Arrays.asList(arr));
		
		println("Arrays : " + arr);
		println("ArrayList : "+arrList);
		println("LinkedList : "+linkedList);
		println("HashSet : "+hashSet);
		println("LinkedHashSet : "+linkedHashSet);
		println("TreeSet : "+treeSet);
		
		// add iterator
		display(arrList.iterator());
		display(linkedList.iterator());
		display(hashSet.iterator());
		display(linkedHashSet.iterator());
		display(treeSet.iterator());
	}
	
	public static void display(Iterator<String> it){
		print(it.toString() + "  ");
		while(it.hasNext())
			print(it.next());
		print("\r\n");
	}
}
