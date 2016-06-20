package org.roy.lessons.TIJ4th.Chpt20;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
	public String value() default "";
	public int id() default -1;
	public String name() default "";
}
