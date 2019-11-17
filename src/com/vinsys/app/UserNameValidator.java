package com.vinsys.app;

import org.apache.wicket.validation.CompoundValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.PatternValidator;

public class UserNameValidator extends CompoundValidator<String> {

	public UserNameValidator(){
		add(PatternValidator.exactLength(8));
	}

}
