package com.Tabiby.service;

import java.sql.Blob;
import java.util.List;

import com.Tabiby.Model.Clinics;
import org.springframework.web.multipart.MultipartFile;


public interface ClinicService {

	public void addCinic(Clinics clinic);
	public Blob addCinicPic(MultipartFile file);
	public Clinics getClinicByEmail(String email);
	public List<Clinics>searchClinicName(String clinicName);
	public List<Clinics> getClinic(Long id);
	public void updateClinic(Clinics clinics);
	public List<Clinics>getClinics(String address,String specialization , String name);
	public List<Clinics>getAllClinics();
	public List<Clinics>getAllActiveClinics();
	public List<Clinics> getAdmin();
	
}
