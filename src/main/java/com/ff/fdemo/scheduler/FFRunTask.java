package com.ff.fdemo.scheduler;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ff.fdemo.model.FF0000Model;
import com.ff.fdemo.service.IFF0000Service;
import com.ff.fdemo.service.IFF0002Service;
import com.ff.fdemo.utils.FFDataFeed;
import com.ff.fdemo.utils.FFUtils;

public class FFRunTask {
	private static final Logger logger = LoggerFactory
			.getLogger(FFRunTask.class);
	@Autowired
	private IFF0002Service ff0002Service;
	
	@Autowired
	private IFF0000Service ff0000Service;
	
	public void doTask() {
		logger.debug("Start task");
		String currentDate = FFUtils.getCurrentDateStr();
		try {
			String destDir = FFDataFeed.downloadEOD(currentDate);
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "HOSE.xls","HOSE");
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "HNX.xls","HNX");
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "UPCOM.xls","UPCOM");
			
			ff0000Service.insertRightEvent();
			

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
		}

		logger.debug("End task");
	}
}
