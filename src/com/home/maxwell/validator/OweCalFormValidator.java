package com.home.maxwell.validator;

import java.util.List;

import org.apache.commons.lang.ClassUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.home.maxwell.domain.OweCal;
import com.home.maxwell.form.OweCalForm;

public class OweCalFormValidator implements Validator{
	protected OweCalValidator oweCalValidator;

	public boolean supports(Class clazz) {
		return ClassUtils.isAssignable(clazz,OweCalForm.class);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "oweYm", "oweYm.empty");
		OweCalForm form = (OweCalForm)target;
		List<OweCal> callist = form.getOweCalList();
		
		for (int i=0; i<callist.size(); i++){
			OweCal owecal = callist.get(i);
			//Note this path must be the same as the jsp file
			errors.pushNestedPath("oweCalList[" + i + "]");
			ValidationUtils.invokeValidator(oweCalValidator, owecal, errors);
			errors.popNestedPath();
		}
		
	}
	
	public OweCalValidator getOweCalValidator() {
		return oweCalValidator;
	}

	public void setOweCalValidator(OweCalValidator oweCalValidator) {
		this.oweCalValidator = oweCalValidator;
	}

}
