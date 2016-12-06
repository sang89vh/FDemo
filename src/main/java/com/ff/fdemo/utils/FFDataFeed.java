package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ff.fdemo.scheduler.FFRunTask;

public class FFDataFeed {
	private static final Logger logger = LoggerFactory.getLogger(FFRunTask.class);
	private static String pathDownload = "F:\\1_IDE\\A2M IDE\\workspace\\eGovFrameDev-3.5.1-64bit\\workspace\\TestSpringMVC\\src\\main\\resources\\eod";

	/**
	 * 
	 * @param strDate
	 *            ex:2016-12-02
	 * @throws IOException
	 */
	public static String downloadEOD(String strDate) throws IOException {
		logger.debug("Start downloadEOD");
		
		String urlEOD = "http://www.bvsc.com.vn/Handlers/DownloadMetaStockDataEx.ashx?format=Excel&data=All&period=EOD&symbol=&fromDate="
				+ strDate + "&toDate=" + strDate;
		URL url = new URL(urlEOD);
		String zipFilePath = pathDownload + "\\" + strDate + ".zip";
		String destDir = pathDownload + "\\" + strDate;
		File file = new File(zipFilePath);

		FileUtils.copyURLToFile(url, file);
		unzip(zipFilePath, destDir);
		logger.debug("End downloadEOD");
		return destDir;
		
	}

	private static void unzip(String zipFilePath, String destDir) {
		logger.debug("Start unzip:"+destDir);
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
				System.out.println("Unzipping to " + newFile.getAbsolutePath());
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

	public static void readRightEvent() throws IOException {
		Document doc = Jsoup.connect(
				"https://www.vndirect.com.vn/portal/lich-su-kien.shtml").get();
		Elements rightEvents = doc.body().select(".box_lichsukien");
		System.out.println(rightEvents.html());
		if (rightEvents != null && rightEvents.size() > 0) {

			Element rightEvent = rightEvents.get(0);
			Elements trs = rightEvent.getElementsByTag("tr");
			for (Element tr : trs) {
				System.out.println("==============================");
				Elements tds = tr.getElementsByTag("td");

				// -Mã CK
				String symbol = tds.get(0).text();
				System.out.println(symbol);
				// -Loại sự kiện
				String eventType = tds.get(1).text();
				System.out.println(eventType);
				// -Ngày GDKHQ
				String rightEventDate = tds.get(2).text().replaceAll("\\D+","");
				System.out.println(rightEventDate);
				// -Ngày chốt
				String eventDate = tds.get(3).text().replaceAll("\\D+","");
				System.out.println(eventDate);
				// -Ngày thực hiện
				String executeDate = tds.get(4).text().replaceAll("\\D+","");
				System.out.println(executeDate);
				// -Chi tiết
				String detail = tds.get(5).text().replaceAll("\\D+","");
				System.out.println(detail);
			}
		}

	}

	public static void main(String[] args) {
		try {
			FFDataFeed.readRightEvent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
