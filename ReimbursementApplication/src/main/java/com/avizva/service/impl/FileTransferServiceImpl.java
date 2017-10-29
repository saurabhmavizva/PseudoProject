package com.avizva.service.impl;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.avizva.service.FileTransferService;

@Service
public class FileTransferServiceImpl implements FileTransferService {

	private static final Logger LOGGER = LogManager.getLogger();

	@Value("${fileTransferService.fileDirectory}")
	private String fileDir;

	public boolean saveFile(Path path, byte[] file) {
		try {
			Files.write(path, file);
		} catch (IOException e) {
			LOGGER.error(e);
			return false;
		}
		return true;
	}

	public String uploadInvoiceImage(MultipartFile file) {
		if (file.isEmpty()) {
			LOGGER.info("Empty image file");
			return "";
		}
		String fileName = (int) (Math.random() * 100000) + file.getOriginalFilename();
		Path path = FileSystems.getDefault().getPath(fileDir + fileName);
		try {
			if (saveFile(path, file.getBytes())) {
				LOGGER.info("File saved successfully");
				return fileName;
			}
		} catch (IOException e) {
			LOGGER.error(e);
		}
		return "";
	}
}
