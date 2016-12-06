package com.ff.fdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "hello")
	public String showForm(Model model) {
		
		logger.info("showForm");
		if (schedulerFactory.isRunning()) {
			model.addAttribute("msg", " job started");
		} else {
			model.addAttribute("msg", "job stopped");
		}
		return "home";
	}

	@Autowired
	private SchedulerFactoryBean schedulerFactory;

	@RequestMapping(value = "hello", method = RequestMethod.POST)
	public String runJob(Model model) {
		logger.info("runJob");
		if (schedulerFactory.isRunning()) {
			schedulerFactory.stop();
			model.addAttribute("msg", "job stopped");
		} else {
			schedulerFactory.start();
			model.addAttribute("msg", "job started");
		}
		return "home";
	}

}
