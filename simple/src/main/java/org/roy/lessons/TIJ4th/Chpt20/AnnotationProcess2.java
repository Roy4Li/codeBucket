package org.roy.lessons.TIJ4th.Chpt20;

import java.lang.annotation.*;
import java.lang.reflect.*;

public class AnnotationProcess2 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("no input class");
			System.exit(0);
		}
		StringBuilder str = new StringBuilder();
		str.append("AnnotationProcessor test:\r\n");
		for (String className : args) {
			try {
				Class<?> cl = Class.forName(className);
				str.append("processing class is: " + cl.getName()
						+ "\r\n");
				for (Annotation anno :cl.getDeclaredAnnotations()) {
					str.append("class has annotation: " + anno
							+ "\r\n");
					if (anno instanceof ExtractInterface) {
						ExtractInterface anno1 = (ExtractInterface) anno;
						str.append("This class has ExtractInterface,value is"
								+ anno1.value()+"\r\n");
					}
				}
				for (Field field : cl.getDeclaredFields()) {
					str.append("class :" + cl.getName() + " has field: "
							+ field.getName() + "\r\n");
					for (Annotation anno : field.getAnnotations()) {
						str.append("\t" + "annotation: "
								+ anno.getClass().getName() + "\r\n");
					}
				}

				for (Method method : cl.getDeclaredMethods()) {
					str.append("class: " + cl.getName() + " has method "
							+ method.getName()+"\r\n");
					for (Annotation anno : method.getAnnotations()) {
						str.append("\t" + "annotation: "
								+ anno+"\r\n");
					}
				}
				System.out.print(str);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
}
