package com.myboxteam.fdemo.config;

import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class FFDBConfig {

	@Bean(name = "ffSystemParameter")
	public Map getSystemParameter() {
		return null;
	}

	@Bean(name = "ffMenu")
	public Map getMenu() {
		return null;
	}
}
