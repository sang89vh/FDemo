package com.ff.fdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FFConfig implements FFCommCode{

	public static String BOX_USERNAME;

	@Value("${box_username}")
	public void setBoxUsername(String boxUsername) {
		BOX_USERNAME = boxUsername;
	}

}
