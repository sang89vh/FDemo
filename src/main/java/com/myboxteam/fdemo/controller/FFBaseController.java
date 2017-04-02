package com.myboxteam.fdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.myboxteam.fdemo.config.FFConfig;

public class FFBaseController {
	@Autowired
	protected MessageSource messageSource;
	
	@ModelAttribute(value="COMPANY_PROFILE_URL") 
	public String getCompanyProfileUrl(){
		return FFConfig.COMPANY_PROFILE_URL;
	}
}
