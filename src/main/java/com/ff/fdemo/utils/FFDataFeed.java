package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ff.fdemo.config.FFConfig;
import com.ff.fdemo.model.FF0000Model;
import com.ff.fdemo.scheduler.FFRunTask;

public class FFDataFeed {
	private static final Logger logger = LoggerFactory.getLogger(FFRunTask.class);

	/**
	 * 
	 * @param strDate
	 *            ex:2016-12-02
	 * @throws IOException
	 */
	public static String downloadEODBVS(String symbol) throws IOException {
		logger.debug("Start downloadEOD");

		String urlEOD = FFConfig.DOWNLOAD_EOD_BVS_URL.replace("{0}", symbol);
		URL url = new URL(urlEOD);
		StringBuffer zipFilePath = new StringBuffer(FFConfig.DOWNLOAD_EOD_PATH); 
		zipFilePath.append(File.separator);
		zipFilePath.append(symbol);
		zipFilePath.append(".zip");
		//System.out.println(">>"+symbol+".zip"+"<<");
		String destDir = FFConfig.DOWNLOAD_EOD_PATH + File.separator + symbol;
		File file = new File(zipFilePath.toString());
		FileUtils.copyURLToFile(url, file);
		unzip(zipFilePath.toString(), destDir);
		logger.debug("End downloadEOD");
		return destDir;

	}
	
	public static String downloadEODCafeF(String strDate1,String strDate2) throws IOException {
		logger.debug("Start downloadEOD");

		String urlEOD = FFConfig.DOWNLOAD_EOD_CAFEF_URL.replace("{0}", strDate1).replace("{1}", strDate2);
		URL url = new URL(urlEOD);
		String zipFilePath = FFConfig.DOWNLOAD_EOD_PATH + File.separator + strDate1 + ".zip";
		String destDir = FFConfig.DOWNLOAD_EOD_PATH + File.separator + strDate1;
		File file = new File(zipFilePath);

		FileUtils.copyURLToFile(url, file);
		unzip(zipFilePath, destDir);
		logger.debug("End downloadEOD");
		return destDir;

	}

	private static void unzip(String zipFilePath, String destDir) {
		logger.debug("Start unzip:" + destDir);
		File dir = new File(destDir);
		// create output directory if it doesn't exist
		if (!dir.exists())
			dir.mkdirs();
		FileInputStream fis;
		// buffer for read and write data to file
		byte[] buffer = new byte[1024];
		try {
			fis = new FileInputStream(zipFilePath);
			ZipInputStream zis = new ZipInputStream(fis);
			ZipEntry ze = zis.getNextEntry();
			while (ze != null) {
				String fileName = ze.getName();
				File newFile = new File(destDir + File.separator + fileName);
				logger.debug("Unzipping to " + newFile.getAbsolutePath());
				// create directories for sub directories in zip
				new File(newFile.getParent()).mkdirs();
				FileOutputStream fos = new FileOutputStream(newFile);
				int len;
				while ((len = zis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fos.close();
				// close this ZipEntry
				zis.closeEntry();
				ze = zis.getNextEntry();
			}
			// close last ZipEntry
			zis.closeEntry();
			zis.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.debug("End unzip");
	}
	
	

	public static List<FF0000Model> readRightEvent(Integer page,String symbol) throws IOException {
		String url = FFConfig.DOWNLOAD_RIGHTEVENT_URL.replace("{0}", page.toString()).replace("{1}", symbol);
		Document doc = Jsoup.connect(url).get();
		Elements rightEvents = doc.body().select(".box_lichsukien");
		List<FF0000Model> data = new ArrayList<FF0000Model>();
		if (rightEvents != null && rightEvents.size() > 0) {

			Element rightEvent = rightEvents.get(0);
			Elements trs = rightEvent.getElementsByTag("tr");
			trs.remove(0);
			String stock = new String("Cổ tức bằng cổ phiếu ");
			String stock2 = new String("Cổ phiếu thưởng ");
			String cash = new String("Cổ tức bằng tiền ");
			String meeting = new String("Họp cổ đông ");
			for (Element tr : trs) {
				Elements tds = tr.getElementsByTag("td");
				FF0000Model re = new FF0000Model();
				String symbolEvent = tds.get(0).text();
				re.setSYMBOL(symbolEvent);

				String eventType = tds.get(1).text();
				eventType = eventType.trim();
				if(cash.equals(eventType)){
					eventType = "CASH";
				}else if(stock.equalsIgnoreCase(eventType) ||stock2.equalsIgnoreCase(eventType)){
					eventType = "STOCK";
				}else if(stock.equalsIgnoreCase(meeting)){
					eventType = "MEETING";
				}
				re.setEVENT_TYPE(eventType);

				// ngay giao dich khong huong quyen
				String rightEventDate = tds.get(2).text().replaceAll("\\D+", "");
				re.setRIGHT_DATE(rightEventDate);

				// ngay dang ky cuoi cung
				String registerDate = tds.get(3).text().replaceAll("\\D+", "");
				re.setREGISTER_DATE(registerDate);

				// ngay thuc hien quyen
				String actionDate = tds.get(4).text().replaceAll("\\D+", "");
				re.setACTION_DATE(actionDate);

				String content = tds.get(5).text();
				re.setCONTENT(content);
				
				data.add(re);
			}
			
			
		}
		
		return data;

	}

	public static void main(String[] args) {
		try {
			FFDataFeed.downloadEODCafeF("20161215","15122016");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
