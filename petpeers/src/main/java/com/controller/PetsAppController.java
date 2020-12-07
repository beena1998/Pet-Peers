package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.PetService;
import com.service.SecurityService;
import com.service.UserService;

@Controller
@RequestMapping(value = "/")
public class PetsAppController {

	private UserService userService;
	private PetService petService;
	private SecurityService securityService;
	
@RequestMapping(value="/user/add")
	public String UserRegistration(@Valid @ModelAttribute("uiobj") User user,BindingResult bindingResult, Model model) {
	String view=" ";
	if(bindingResult.hasErrors()) {
		view="userregn.jsp";
	}else {
userService.addUser(user);
		view="registered.jsp";
		
	}
	return view;
	
}

}
