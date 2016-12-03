package com.ff.fdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ff.fdemo.service.StudentService;

@Controller
@SessionAttributes("ff0000")
@RequestMapping("/ff0000")
public class FF0000Controller extends FBaseController {

	private static final Logger logger = LogManager.getLogger(FF0000Controller.class);
	@Autowired
	private StudentService studentService;


	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {

		mav.setViewName("ff0000/ff000001");

		return mav;

	}
	
}
