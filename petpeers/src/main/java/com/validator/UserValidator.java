package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hcl.pp.model.User;

/**
 * @author Beena Kandpal
 * 
 * 
 * User Validator : Where the Password and Confirm Password is compared
 *
 */
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class arg0) {
		return User.class.equals(arg0);
	}

	@Override
	public void validate(Object obj, Errors e) {
		ValidationUtils.rejectIfEmpty(e, "username", "userName.empty");
		ValidationUtils.rejectIfEmpty(e, "userPassword", "userPassword.empty");
		ValidationUtils.rejectIfEmpty(e, "confirmPassword", "confirmPassword.empty");

		User user = (User) obj;
		if (!user.getUserPassword().equals(user.getConfirmPassword())) {
			e.rejectValue("confirmPassword", "confirmPassword.notequal");
		}
	}

}
