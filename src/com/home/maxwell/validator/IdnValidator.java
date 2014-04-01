package com.home.maxwell.validator;

import org.apache.commons.lang.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.maxwell.domain.Person;

public class IdnValidator implements Validator{

	public boolean supports(Class clazz) {
		return ClassUtils.isAssignable(clazz,Person.class);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "idn", "idn.empty");
		
	}

}
