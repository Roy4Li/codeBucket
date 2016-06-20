package org.roy.lessons.jvm;

public class DynamicDispatchDemo {
	static abstract class Human{
		protected abstract void sayHello();
		public void sayGoodbye(){
			System.out.println("human says goodbye");
		}
	}
	
	static class Man extends Human{
		@Override
		protected void sayHello(){
			System.out.println("man says hello");
		}
		
		public void sayGoodbye(){
			System.out.println("man says goodbye");
		}
	}
	
	static class Woman extends Human{
		@Override
		protected void sayHello(){
			System.out.println("woman says hello");
		}
	}
	
	
	public static void main(String[] args) {
		Human h1 = new Man();
		Human h2 = new Woman();
		h1.sayHello();
		h1.sayGoodbye();
		h2.sayHello();
		h2.sayGoodbye();
		h1 = new Woman();
		h1.sayHello();
		h1.sayGoodbye();
	}
}
