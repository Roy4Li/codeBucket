package org.roy.lessons.jvm;

import java.io.*;

public class ClassLoadTest {

	public static void main(String[] args) throws Exception{
		ClassLoader myLoader = new ClassLoader(){
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException{
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null){
						return super.loadClass(name);
					}
					byte[] buf = new byte[is.available()];
					is.read(buf);
					return defineClass(name,buf,0,buf.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("ClassLoadTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof ClassLoadTest);
	}
}
