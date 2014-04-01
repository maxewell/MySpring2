package com.home.maxwell.validator;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.maxwell.domain.OweCal;

public class OweCalValidator implements Validator{

	public boolean supports(Class clazz) {
		return ClassUtils.isAssignable(clazz,OweCal.class);
	}

	public void validate(Object target, Errors errors) {
		OweCal owecal = (OweCal)target;
		if (!StringUtils.isEmpty(owecal.getBrdate())) {
			ValidationUtils.rejectIfEmpty(errors, "idn", "idn.empty");
		}	
		
	}
}
