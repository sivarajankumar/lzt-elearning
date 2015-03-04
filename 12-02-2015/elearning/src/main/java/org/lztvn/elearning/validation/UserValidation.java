package org.lztvn.elearning.validation;

import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {
	private IUserService service;
	public UserValidation(IUserService service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	  // TODO Auto-generated method stub
	  User user = (User) target;
	  User findUser = service.getUserByUsername(user.getUsername());
	  if(findUser!=null){
		  errors.rejectValue("username", "unique","Username has been exit");
	  }
      //if(user.getName() == null) {
      //    errors.rejectValue("name", "your_error_code");
      //}
	}
}
