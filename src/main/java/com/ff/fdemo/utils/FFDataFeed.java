package com.ff.fdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FileUtils;

public class FFDataFeed {
	private static String pathDownload = "F:\\1_IDE\\A2M IDE\\workspace\\eGovFrameDev-3.5.1-64bit\\workspace\\TestSpringMVC\\src\\main\\resources\\eod";

	/**
	 * 
	 * @param strDate
	 *            ex:2016-12-02
	 * @throws IOException
	 */
	public static void downloadEOD(String strDate) throws IOException {
		String urlEOD = "http://www.bvsc.com.vn/Handlers/DownloadMetaStockDataEx.ashx?format=Excel&data=All&period=EOD&symbol=&fromDate="
				+ strDate + "&toDate=" + strDate;
		URL url = new URL(urlEOD);
		String zipFilePath = pathDownload + "\\" + strDate + ".zip";
		File file = new File(zipFilePath);

		FileUtils.copyURLToFile(url, file);
		unzip(zipFilePath, pathDownload + "\\" + strDate);

	}

	private static void unzip(String zipFilePath, String destDir) {
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

	}

	public static void main(String[] args) {
		try {
			FFDataFeed.downloadEOD("2016-12-02");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
