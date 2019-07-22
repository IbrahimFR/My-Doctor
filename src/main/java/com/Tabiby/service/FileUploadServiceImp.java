package com.Tabiby.service;

import com.Tabiby.Model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.FileUploadDao;
import com.Tabiby.Model.Files;

import java.util.List;

@Service("fileUploadService")
public class FileUploadServiceImp implements FileUploadService{

	@Autowired
	private FileUploadDao fileUploadDao;
	
	
	public FileUploadDao getFileUploadDao() {
		return fileUploadDao;
	}


	public void setFileUploadDao(FileUploadDao fileUploadDao) {
		this.fileUploadDao = fileUploadDao;
	}


	@Override
	@Transactional
	public void save(UploadedFile uploadFile) {
		
		this.fileUploadDao.save(uploadFile);
		
		
	}
	@Override
	@Transactional
	public List<UploadedFile> getFiles(long clinic , long user){
		return this.fileUploadDao.getFiles(clinic, user);
	}
	@Override
	@Transactional
	public UploadedFile getFile(long id){
		return this.fileUploadDao.getFile(id);
	}
	@Override
	@Transactional
	public void delete (UploadedFile uploadedFile){
		this.fileUploadDao.delete(uploadedFile);
	}


}
