package com.avizva.service;

import java.nio.file.Path;

import org.springframework.web.multipart.MultipartFile;

public interface FileTransferService {

	public boolean saveFile(Path path, byte[] file);

	public String uploadInvoiceImage(MultipartFile file);
}
