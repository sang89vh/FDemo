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
import com.ff.fdemo.service.impl.StudentService;

@Controller
@SessionAttributes("student")
@RequestMapping("/ff0000")
public class StudentController extends FBaseController {

	private static final Logger logger = LogManager.getLogger(StudentController.class);
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "ff0000/signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(@ModelAttribute("student") Student student, Model model) {
		if (studentService.getStudentByUserName(student.getUserName())) {
			model.addAttribute("message",
					"User Name exists. Try another user name");
			return "ff0000/signup";
		} else {
			studentService.insertStudent(student);
			model.addAttribute("message", "Saved student details");
			return "redirect:ff0000/login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		StudentLogin studentLogin = new StudentLogin();
		model.addAttribute("studentLogin", studentLogin);
		return "ff0000/login";
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
