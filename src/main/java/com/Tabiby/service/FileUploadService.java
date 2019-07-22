package com.Tabiby.service;

import com.Tabiby.Model.Files;
import com.Tabiby.Model.UploadedFile;

import java.util.List;

public interface FileUploadService {

	public void save(UploadedFile uploadFile);
	public void delete (UploadedFile uploadedFile);
	public List<UploadedFile> getFiles(long clinic , long user);
	public UploadedFile getFile(long id);
}
