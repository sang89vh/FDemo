package com.ff.fdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("ff0001")
@RequestMapping("/ff0001")
public class FF0001Controller extends FFBaseController {

	private static final Logger logger = LogManager.getLogger(FF0001Controller.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			ModelAndView mav,
			@RequestParam(value = "error", 
			required = false) String error,
			@RequestParam(value = "logout", required = false) String logout
			
			) {

		if (error != null) {
			mav.addObject("error", "Invalid username and password!");
		}

		if (logout != null||error != null) {
			mav.setViewName("ff0001/ff000101");
		}else{
			mav.setViewName("redirect:/ff0000/index");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			model.addObject("role", userDetail.getAuthorities());
			
		}
		
		model.setViewName("ff0001/403");
		return model;

	}
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/ff0001/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
}
