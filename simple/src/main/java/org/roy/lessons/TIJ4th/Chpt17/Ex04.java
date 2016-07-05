package org.roy.lessons.TIJ4th.Chpt17;

import java.util.*;

import org.roy.lessons.TIJ4th.common.util.TextFile;
import static org.roy.lessons.TIJ4th.common.util.Print.*;

public class Ex04 {
	private static final String path = "src/main/java/"+Ex04.class.getPackage().getName().replace('.', '\\');
	private static final String fileName = path + "\\" + "Ex04.java";
	static Collection<String> CollectionInit1(String fileName){
		return new TextFile(fileName,"\\W+");
	}
	
	public static void main(String[] args) {
		print(path);
		print(CollectionInit1(fileName));
	}
}
