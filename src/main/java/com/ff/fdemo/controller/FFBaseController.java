package com.ff.fdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

public class FFBaseController {
	@Autowired
	protected MessageSource messageSource;
}
