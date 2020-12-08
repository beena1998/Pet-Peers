package com.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.User;
import com.service.PetService;
import com.service.SecurityService;
import com.service.UserService;

@Controller
public class PetsAppController {
	@Autowired
	private UserService userService;

	@Autowired
	private PetService petService;

	@Autowired
	private SecurityService securityService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public PetService getPetService() {
		return petService;
	}

	public void setPetService(PetService petService) {
		this.petService = petService;
	}

	public SecurityService getSecurityService() {
		return securityService;
	}

	public void setSecurityService(SecurityService securityService) {
		this.securityService = securityService;
	}

	@GetMapping(value = { "/", "/home" })
	public String view1() {
		return "home";
	}

	@GetMapping(value = "/userregn")
	public String UserRegistration(Model model) {
		model.addAttribute("user", new User());
		return "userregn";
	}

	@PostMapping(value = "/register")
	public String Success(User user, Model model) {
		getUserService().addUser(user);
		model.addAttribute("user", user);
		return "registered";
	}

	/*
	 * @PostMapping(value = "/register") public ModelAndView
	 * registerSuccess(@Valid @ModelAttribute("user") User user, BindingResult
	 * bindingResult) { if (bindingResult.hasErrors()) { return new
	 * ModelAndView("userregn"); } getUserService().addUser(user); ModelAndView
	 * modelAndView = new ModelAndView("registered"); modelAndView.addObject("user",
	 * user); return modelAndView; }
	 */

	@GetMapping(value = "/login")
	public String Login(User user, Model model) {
		model.addAttribute("user", user);

		return "login";
	}

	@PostMapping(value = "/loginSuccess")
	public ModelAndView loginSuccess(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView("errorPage");
		}

		ModelAndView modelAndView =new ModelAndView();;
		String result = getSecurityService().authenticateUser(user);
		System.out.println(result);
		if (result.equals("success")) {
			modelAndView = new ModelAndView("pet_home");
		}
		/*
		 * if(user!= null){ modelAndView.addObject("user", user); return modelAndView;
		 * }else{ modelAndView = new ModelAndView("login"); }
		 */
		return modelAndView;
	}

}
