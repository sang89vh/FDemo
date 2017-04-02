package com.myboxteam.fdemo.scheduler;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.myboxteam.fdemo.service.IFF0000Service;
import com.myboxteam.fdemo.service.IFF0002Service;
import com.myboxteam.fdemo.utils.FFDataFeed;
import com.myboxteam.fdemo.utils.FFUtils;

public class FFRunTask {
	private static final Logger logger = LoggerFactory
			.getLogger(FFRunTask.class);
	@Autowired
	private IFF0002Service ff0002Service;
	
	@Autowired
	private IFF0000Service ff0000Service;
	
	public void doTask() {
		logger.debug("Start task");
		try {
			
			/*
			String destDir = FFDataFeed.downloadEODBVS(currentDate);
			
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "HOSE.xls","HOSE");
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "HNX.xls","HNX");
			ff0002Service.insertHistoricalPrice(destDir + File.separator + "UPCOM.xls","UPCOM");
			*/
			String strDate1 = FFUtils.getCurrentDateYYYYMMDD();//"20161215";
			String strDate2 = FFUtils.getCurrentDateDDMMYYYY();//"15122016";
			
			String destDir = FFDataFeed.downloadEODCafeF(strDate1,strDate2);
			
			String strDateFile = FFUtils.getCurrentDateDDDotMMDotYYYY();//"15.12.2016";
			
			ff0002Service.insertHistoricalPriceCafeF(destDir + File.separator + "CafeF.HSX."+strDateFile+".csv","HSX");
			ff0002Service.insertHistoricalPriceCafeF(destDir + File.separator + "CafeF.HNX."+strDateFile+".csv","HNX");
			ff0002Service.insertHistoricalPriceCafeF(destDir + File.separator + "CafeF.UPCOM."+strDateFile+".csv","UPCOM");
			
			ff0000Service.insertRightEvent(1,"");
			

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}

		logger.debug("End task");
	}
}
