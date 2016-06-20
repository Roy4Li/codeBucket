package org.roy.lessons.TIJ4th.Chpt20;

import java.util.*;

import javax.annotation.processing.*;
import javax.lang.model.*;
import javax.lang.model.element.TypeElement;

public class AnnotationProcess extends AbstractProcessor{
	
	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		return false;
	}
}
