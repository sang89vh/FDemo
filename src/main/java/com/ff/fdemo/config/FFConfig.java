package com.ff.fdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FFConfig implements FFCommCode{

	public static String DOWNLOAD_EOD_URL;
	
	@Value("${download.eod.url}")
	public void setDownloadEODUrl(String url) {
		DOWNLOAD_EOD_URL = url;
	}
	
	public static String DOWNLOAD_EOD_PATH;

	@Value("${download.eod.path}")
	public void setDownloadEODPath(String path) {
		DOWNLOAD_EOD_PATH = path;
	}
	
	public static String DOWNLOAD_RIGHTEVENT_URL;

	@Value("${download.rightevent.url}")
	public void setDownloadRightEventUrl(String url) {
		DOWNLOAD_RIGHTEVENT_URL = url;
	}

}
