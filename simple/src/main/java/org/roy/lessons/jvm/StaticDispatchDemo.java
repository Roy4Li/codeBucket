package org.roy.lessons.jvm;

import java.io.Serializable;

public class StaticDispatchDemo {
	
	public static void sayHello(char c){
		System.out.println("hello char");
	}
	
	public static void sayHello(int c){
		System.out.println("hello int");
	}
	
	public static void sayHello(long c){
		System.out.println("hello long");
	}
	
	public static void sayHello(Character c){
		System.out.println("hello Character");
	}
	
	public static void sayHello(Serializable c){
		System.out.println("hello Serializable");
	}
	
	public static void sayHello(Object c){
		System.out.println("hello object");
	}
	
	public static void sayHello(char... c){
		System.out.println("hello char...");
	}
	
	public static void main(String[] args) {
		StaticDispatchDemo.sayHello('c');
	}
}
