package org.roy.lessons.jvm;

import static java.lang.invoke.MethodHandles.*;

import java.lang.invoke.*;

public class GrandfatherDemo {
	class Grandfather {
		void say() {
			System.out.println("i am grandfather");
		}
	}

	class Father extends Grandfather {
		void say() {
			System.out.println("i am father");
		}
	}

	class Son1 extends Father {
		void say() {
			new Grandfather().say();
		}
	}

	class Son2 extends Father {
		void say() {
			try {
				MethodType mt = MethodType.methodType(void.class);
				MethodHandle mh = lookup().findSpecial(Grandfather.class,
						"say", mt,getClass());
				mh.invoke(this);
			} catch (Throwable e) {
				
			}
		}
	}

	public static void main(String[] args) {
		// (new GrandfatherDemo().new Son1()).say();
		new GrandfatherDemo().new Son2().say();
	}
}
