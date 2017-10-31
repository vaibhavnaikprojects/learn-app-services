package com.zensar.learnappservices.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileDownloader {
	@Autowired
	ServletContext context;
	
	private static final int BUFFER_SIZE = 4096;
	
	public void downloadFile(File outputFile,HttpServletResponse response,String fileName) throws IOException{
		FileInputStream inputStream = new FileInputStream(outputFile);
		String mimeType = context.getMimeType(outputFile.getAbsolutePath());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		response.setContentLength((int) outputFile.length());
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",fileName);
		response.setHeader(headerKey, headerValue);
		OutputStream outStream = response.getOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}

}
