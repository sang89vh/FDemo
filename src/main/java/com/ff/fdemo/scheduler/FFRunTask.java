package com.ff.fdemo.scheduler;

import java.io.IOException;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ff.fdemo.service.IFF0002Service;
import com.ff.fdemo.utils.FFDataFeed;
import com.ff.fdemo.utils.FFUtils;

public class FFRunTask {
	private static final Logger logger = LoggerFactory
			.getLogger(FFRunTask.class);
	@Autowired
	private IFF0002Service ff0002Service;

	public void doTask() {
		logger.debug("Start task");
		String currentDate = FFUtils.getCurrentDateStr();
		try {
			String destDir = FFDataFeed.downloadEOD(currentDate);
			ff0002Service.insertHistoricalPrice(destDir + "\\HOSE.xls");
			ff0002Service.insertHistoricalPrice(destDir + "\\HNX.xls");
			ff0002Service.insertHistoricalPrice(destDir + "\\UPCOM.xls");

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		logger.debug("End task");
	}
}
