package com.hcl.pp.controller;

import javax.validation.Valid;

//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hcl.pp.model.User;
import com.hcl.pp.service.PetService;
import com.hcl.pp.service.SecurityService;
import com.hcl.pp.service.UserService;
import com.validator.PetValidator;
import com.validator.UserValidator;

/**
 * @author Beena Kandpal
 * 
 *         PetsAppController: Controller
 *
 */
@Controller
public class PetsAppController {

//	private static final Logger logger = LogManager.getLogger(PetsAppController.class);

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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new UserValidator());
		// binder.setValidator(new PetValidator());

	}

	// First view page
	@GetMapping(value = { "/", "/home" })
	public String view1() {
		return "home";
	}

	// Getting url from Registration Page
	@GetMapping(value = "/userregn")
	public String UserRegistration(Model model) {
		model.addAttribute("user", new User());
		return "userregn";
	}

	// After successfull Registration
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submitForm(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "errorPage";
		}
		getUserService().addUser(user);
		model.addAttribute("user", user);
		return "registered";

	}
	// Moving towards login page

	@GetMapping(value = "/login")
	public String Login(User user, Model model) {
		model.addAttribute("user", user);
//		logger.info("Lets move to login!!");

		return "login";
	}

	/*
	 * @RequestMapping(value = "/loginSuccess",method = RequestMethod.POST) public
	 * String afterloginForm(@Valid User user, BindingResult result,Model model) {
	 * 
	 * if (result.hasErrors()) { System.out.println("Inside hasError!"); return
	 * "errorPage"; }
	 * 
	 * String result1 = getSecurityService().authenticateUser(user);
	 * model.addAttribute("user", user); System.out.println(result); return
	 * "registered";
	 * 
	 * }
	 */

	/*
	 * @PostMapping(value = "/loginSuccess") public ModelAndView
	 * loginSuccess(@Valid @ModelAttribute("user") User user, BindingResult
	 * bindingResult) { if (bindingResult.hasErrors()) {
	 * System.out.println("Error!!"); return new ModelAndView("errorPage"); }
	 * 
	 * 
	 * String result = getSecurityService().authenticateUser(user); ModelAndView
	 * modelAndView =new ModelAndView(result); System.out.println(result);
	 * 
	 * 
	 * 
	 * if(user!= null){ modelAndView.addObject("user", user); return modelAndView;
	 * }else{ modelAndView = new ModelAndView("login"); }
	 * 
	 * return modelAndView; }
	 */

	// Checking whether user is present or not
	// If present then successful login
	@PostMapping(value = "/loginSuccess")
	public String loginSuccess(@RequestParam("username") String username,
			@RequestParam("userPassword") String userPassword, User user, Model model) {

//		logger.info("Inside login!!");

		/*
		 * boolean userExists =
		 * getSecurityService().authenticateUser(user.getUsername(),user.getUserPassword
		 * ()); if(userExists){ model.addAttribute("user", user); return "pet_home";
		 * }else{
		 * 
		 * return "errorPage"; }
		 */
		/*
		 * System.out.println(username+ " "+user.getUsername());
		 * if(user.getUsername().equals(username)) { System.out.println(username+
		 * " "+user.getUsername()); model.addAttribute("user", user); return "pet_home";
		 * } else { return "errorPage"; }
		 */
//		logger.info("User Id" + user.getId());
//		logger.info("User Name" + user.getUsername());

		user = getSecurityService().authenticateUser1(user.getId());
		if (user != null) {
			model.addAttribute("user", user);
			return "pet_home";
		} else {
			return "errorPage";
		}

	}

	/*
	 * @GetMapping(value="/pet") public String Add(Model model) {
	 * model.addAttribute("object", new Pet()); return "pet_form"; }
	 * 
	 * 
	 * 
	 * @GetMapping(value="/save") public String
	 * createPet(@ModelAttribute("pet") @Valid Pet pet, BindingResult
	 * bindingResult,Model model) {
	 * 
	 * if (bindingResult.hasErrors()) { return "errorPage"; } else {
	 * model.addAttribute("Key1", getPetService().savePet(pet));
	 * System.out.println(pet.getName());
	 * 
	 * } return "aftersave";
	 * 
	 * 
	 * }
	 */

}
