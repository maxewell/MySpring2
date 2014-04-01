package com.home.maxwell.validator;

import org.apache.commons.lang.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.maxwell.domain.Person;

public class UnoValidator implements Validator{

	public boolean supports(Class clazz) {
		return ClassUtils.isAssignable(clazz,Person.class);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "uno", "uno.empty");
		/*
		Person p = (Person) target;
		
		if (p.getAge() < 0) {
			errors.rejectValue("age", "negativevalue");
		} else if (p.getAge() > 110) {
			errors.rejectValue("age", "too.darn.old");
		}
		*/
	}

}
