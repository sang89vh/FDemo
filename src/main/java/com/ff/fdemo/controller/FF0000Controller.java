package com.ff.fdemo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ff.fdemo.model.FF000001Model;
import com.ff.fdemo.model.FF0000Model;
import com.ff.fdemo.model.FF0002Model;
import com.ff.fdemo.model.FF000402Model;
import com.ff.fdemo.scheduler.FFRunTask;
import com.ff.fdemo.service.IFF0000Service;
import com.ff.fdemo.service.IFF0002Service;
import com.ff.fdemo.service.IFF0004Service;
import com.ff.fdemo.utils.FFDataFeed;

@Controller
@SessionAttributes("ff0000")
@RequestMapping("/ff0000")
public class FF0000Controller extends FFBaseController {

	private static final Logger logger = LogManager.getLogger(FF0000Controller.class);
	
	@Autowired
	public IFF0002Service ff0002Service;
	
	@Autowired
	public IFF0000Service ff0000Service;
	
	@Autowired
	public IFF0004Service ff0004Service;
	
	@Autowired
	public FFRunTask ffRunTask;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView rightEvent(ModelAndView mav, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute FF0002Model prm
			) throws SQLException {
		
		List<FF000402Model> companies = ff0004Service.getAllCompanies();
		for (FF000402Model ff000402Model : companies) {
			String symbol = ff000402Model.getSymbol();
			for(int i=1;i<10;i++){
				ff0000Service.insertRightEvent(i,symbol);
				
				
			}
			
			try {
				String destDir = FFDataFeed.downloadEODBVS(symbol);
				ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + symbol +".xls","UNKNOW");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//ff0004Service.insertCompanies();
		
		/*
		for(int i=1;i<1104;i++){
			ff0000Service.insertRightEvent(i);
		}*/
		/*
		String destDir = FFConfig.DOWNLOAD_EOD_PATH + File.separator;
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/HNX.xls","HNX");
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/HOSE.xls","HSX");
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/UPCOM.xls","UPCOM");
		
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2016/HNX.xls","HNX");
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2016/HOSE.xls","HSX");
		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2016/UPCOM.xls","UPCOM");
		*/
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2015/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2012/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2012/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2012/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20052009/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20052009/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20052009/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20092010/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20092010/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20092010/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2013/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2013/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2013/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2011/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2011/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/2011/UPCOM.xls","UPCOM");
//		
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20002005/HNX.xls","HNX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20002005/HOSE.xls","HSX");
//		ff0002Service.insertHistoricalPriceBVS(destDir + File.separator + "/20002005/UPCOM.xls","UPCOM");
		
		
		mav.setViewName("ff0000/ff000001");
		return mav;

	}
	@RequestMapping(value = "/data01", method = RequestMethod.POST)
	public @ResponseBody List<FF000001Model> searchRightEventBySymbol(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute FF0000Model prm
			) throws SQLException {
		
		return ff0000Service.searchRightEventBySymbol(prm);
		
	}
	
	@RequestMapping(value = "/view02", method = RequestMethod.GET)
	public ModelAndView view01(ModelAndView mav, HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute FF0002Model prm
			) throws SQLException {
		
		//ffRunTask.doTask();
		mav.setViewName("ff0000/ff000002");
		return mav;

	}
	
}
