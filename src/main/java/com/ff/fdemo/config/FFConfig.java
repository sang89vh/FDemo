package com.ff.fdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FFConfig implements FFCommCode{

	public static String BOX_USERNAME;

	@Value("${baasbox.user}")
	public void setBoxUsername(String boxUsername) {
		BOX_USERNAME = boxUsername;
	}

}
