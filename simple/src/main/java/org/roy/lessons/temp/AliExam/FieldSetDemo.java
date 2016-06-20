package org.roy.lessons.temp.AliExam;

import java.lang.reflect.Field;

public class FieldSetDemo {
	
	private String name;
	private String location;
	private String bank;
	
	@Override
	public String toString(){
		return "Name: "+this.name+",Location: "+this.location+";Bank: "+this.bank; 
	}
	public static void main(String[] args) {
		FieldSetDemo t = new FieldSetDemo();
		Field[] fields = t.getClass().getDeclaredFields();
		for(Field f:fields){
			f.setAccessible(true);
			try {
				if(f.getName().equals("name")){
					f.set(t, "Roy");
				}
				if(f.getName().equals("location"))
					f.set(t,"BJ");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(t);
	}
}
