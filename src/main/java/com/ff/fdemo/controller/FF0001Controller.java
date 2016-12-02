package com.ff.fdemo.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ff.fdemo.model.Student;
import com.ff.fdemo.model.StudentLogin;
import com.ff.fdemo.service.StudentService;

@Controller
@SessionAttributes("ff0001")
@RequestMapping("/ff0001")
public class FF0001Controller extends FBaseController {

	private static final Logger logger = LogManager.getLogger(FF0001Controller.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(Model model) {
		StudentLogin studentLogin = new StudentLogin();
		model.addAttribute("studentLogin", studentLogin);
		return "ff0001/ff0001";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(
			@ModelAttribute("studentLogin") StudentLogin studentLogin) {
		boolean found = studentService.getStudentByLogin(
				studentLogin.getUserName(), studentLogin.getPassword());
		if (found) {
			return "ff0000/success";
		} else {
			return "ff0000/failure";
		}
	}
}
