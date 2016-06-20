package org.roy.lessons.TIJ4th.Chpt20;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtractInterface {
	public String value();
}
