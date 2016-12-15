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

import com.ff.fdemo.model.FF000001Model;
import com.ff.fdemo.model.FF0000Model;
import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.service.IFF0000Service;
import com.ff.fdemo.service.IFF0002Service;

@Controller
@SessionAttributes("ff0000")
@RequestMapping("/ff0000")
public class FF0000Controller extends FFBaseController {

	private static final Logger logger = LogManager.getLogger(FF0000Controller.class);
	
	@Autowired
	public IFF0002Service ff0002Service;
	
	@Autowired
	public IFF0000Service ff0000Service;
	

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView rightEvent(ModelAndView mav, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute FF0002Model prm
			) throws SQLException {
		mav.setViewName("ff0000/ff000001");
		return mav;

	}
	@RequestMapping(value = "/data01", method = RequestMethod.POST)
	public @ResponseBody List<FF000001Model> searchRightEventBySymbol(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute FF0000Model prm
			) throws SQLException {
		
		return ff0000Service.searchRightEventBySymbol(prm);
		
	}
	
}
