package com.myboxteam.fdemo.controller;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * Just only index, view, 
 * @author jack
 *
 */
@Controller
@SessionAttributes("ff0003")
@RequestMapping("/ff0003")
public class FF0003Controller extends FFBaseController {

	private static final Logger logger = LogManager
			.getLogger(FF0003Controller.class);
	
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav)
			throws SQLException {
		mav.setViewName("ff0003/ff000301");

		return mav;
	}

	
}
