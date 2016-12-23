package com.ff.fdemo.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ff.fdemo.config.FFConfig;
import com.ff.fdemo.model.FF000502Model;
import com.ff.fdemo.service.IFF0005Service;

/**
 * Just only index, view,
 * 
 * @author jack
 *
 */
@Controller
@SessionAttributes("ff0005")
@RequestMapping("/ff0005")
public class FF0005Controller extends FFBaseController {

	private static final Logger logger = LogManager
			.getLogger(FF0005Controller.class);

	@Autowired
	public IFF0005Service ff0005Service;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView login(ModelAndView mav) throws SQLException {

		mav.setViewName("ff0005/ff000501");

		return mav;
	}
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) throws IOException {
		String pathFile = FFConfig.DOWNLOAD_REPORT_PATH.replace("{0}",
				"LichSuKhopLenh_058C054323.xls");
		File input = new File(pathFile);
		File convFile = new File(file.getOriginalFilename());
		file.transferTo(convFile);
		FileUtils.copyFile(convFile, input);
		ff0005Service.insertTradeLog(pathFile);
		redirectAttributes
				.addFlashAttribute("message", "You successfully uploaded "
						+ file.getOriginalFilename() + "!");

		return "redirect:/ff0005/index";
	}
	
	@RequestMapping(value = "/data01", method = RequestMethod.POST)
	public @ResponseBody List<Map> data01() throws SQLException {
		List<Map> data = ff0005Service.reportBySymbol();
		return data;
	}
	
	@RequestMapping(value = "/data02", method = RequestMethod.POST)
	public @ResponseBody Map data02() throws SQLException {
		Map data = ff0005Service.reportByAll();
		return data;
	}
	
	@RequestMapping(value = "/data03", method = RequestMethod.POST)
	public @ResponseBody Map data03() throws SQLException {
		Map data = ff0005Service.reportByGrid();
		return data;
	}

}
