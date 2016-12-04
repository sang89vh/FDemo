package com.ff.fdemo.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.service.IFF0002Service;

@Controller
@SessionAttributes("ff0002")
@RequestMapping("/ff0002")
public class FF0002Controller extends FFBaseController {

	private static final Logger logger = LogManager.getLogger(FF0002Controller.class);
	@Autowired
	private IFF0002Service ff0002Service;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login(
			ModelAndView mav,
			@ModelAttribute FF0002Model prm
			) throws SQLException {
		mav.setViewName("ff0002/ff000201");
		
		return mav;
	}
	
	@RequestMapping(value = "/data01", method = RequestMethod.POST)
	public @ResponseBody List<FF0002Model>  data01(
			@ModelAttribute FF0002Model prm
			) throws SQLException {
		List<FF0002Model> data = ff0002Service.getHistoricalPriceBySymbol(prm);
		return data;
	}

}
