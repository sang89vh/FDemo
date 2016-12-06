package com.ff.fdemo.scheduler;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FFRunTask {
	private static final Logger logger = LoggerFactory
			.getLogger(FFRunTask.class);
	public void doTask() {
		Long d = Calendar.getInstance().getTimeInMillis();
		logger.info("Spring 3 + Quartz 1.8.6:{%d}",d);
	}
}
