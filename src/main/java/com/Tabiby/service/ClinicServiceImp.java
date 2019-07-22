package com.Tabiby.service;

import java.sql.Blob;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.ClinicDao;
import com.Tabiby.Model.Clinics;
import org.springframework.web.multipart.MultipartFile;

@Service("clinicService")
public class ClinicServiceImp implements ClinicService{
	@Autowired
	private ClinicDao clinicDao;
	

	public ClinicDao getClinicDao() {
		return clinicDao;
	}


	public void setClinicDao(ClinicDao clinicDao) {
		this.clinicDao = clinicDao;
	}


	@Override
	@Transactional
	public void addCinic(Clinics clinic) {
		this.clinicDao.addClinic(clinic);
		
	}
	@Override
	public List<Clinics> getClinic(Long id){
	return	this.clinicDao.getClinic(id);
	}


	@Override
	@Transactional
	public Clinics getClinicByEmail(String email) {
		return this.clinicDao.getClinicByEmail(email);
	}


	@Override
	@Transactional
	public List<Clinics> searchClinicName(String clinicName) {
		return this.clinicDao.searchClinicName(clinicName);
	
	}

	@Override
	@Transactional
	public void updateClinic(Clinics clinics) {
		 this.clinicDao.updateClinic(clinics);
	}

	@Override
	@Transactional
	public List<Clinics>getClinics(String address,String specialization , String name){
		return this.clinicDao.getClinics(address, specialization, name);
	}
	@Override
	@Transactional
	public List<Clinics>getAllClinics(){
		return this.clinicDao.getAllClinics();
	}
	@Override
	@Transactional
	public List<Clinics>getAllActiveClinics(){
		return this.clinicDao.getAllActiveClinics();
	}
	@Override
	@Transactional
	public List<Clinics> getAdmin(){
		return this.clinicDao.getAdmin();
	}
	@Override
	@Transactional
	public Blob addCinicPic(MultipartFile file){
return null;
	}

}
