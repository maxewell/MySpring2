package com.home.maxwell.validator;

import org.apache.commons.lang.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.maxwell.domain.OweApp;

public class OweAppValidator implements Validator{

	public boolean supports(Class clazz) {
		//return OweApp.class.equals(clazz);
		return ClassUtils.isAssignable(clazz, OweApp.class);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "oweYm", "oweYm.empty");
		
	}
}
