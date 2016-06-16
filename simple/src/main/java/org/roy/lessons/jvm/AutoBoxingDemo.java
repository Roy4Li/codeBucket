package org.roy.lessons.jvm;

public class AutoBoxingDemo {

	public static void main(String[] args) {
		Integer a = 2;
		Integer b = 1;
		Integer c = 3;
		Integer d = 3;
		Integer e = 321;
		Integer f = 321;
		Long g = 3L;
		System.out.println(c == d); // 整型值在-128<=i<=127时，返回的是IntegerCache()，即同一个对象;true
		System.out.println(e == f); // 整型值大于上述区级，才生成新的对象，是两个不同的对象 ;false
		System.out.println(c == (a+b)); // == 运算符只有在遇到算数运算符才回拆箱;true
		System.out.println(c.equals(a+b)); // 都是整型且数值相同; true
		System.out.println(e.equals(f)); // 都是整型且数值相同;true
		System.out.println(g == (a+b)); // == 遇到算术运算符自动拆箱;true
		System.out.println(g.equals(a+b)); // Long型的equals方法要判断类型是否为Long，a+b的结果为Integer类型;false
	}
}
