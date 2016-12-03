package com.ff.fdemo.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ff.fdemo.service.impl.StudentService;

@Controller
@SessionAttributes("ff0002")
@RequestMapping("/ff0002")
public class FF0002Controller extends FBaseController {

	private static final Logger logger = LogManager.getLogger(FF0002Controller.class);
	@Autowired
	private StudentService studentService;


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

		if (logout != null) {
			mav.setViewName("ff0002/ff000201");
		}else{
			mav.setViewName("redirect:/ff0000/index");
		}
		
		return mav;
	}

}
