package com.Tabiby.Dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

import com.Tabiby.Model.Clinics;
import org.springframework.web.multipart.MultipartFile;

public interface ClinicDao {
 
	public void addClinic(Clinics clinic);

	public Clinics getClinicByEmail(String email);
	public List<Clinics> searchClinicName(String clinicName);
	public List<Clinics> getClinic(Long id);
	public List<Clinics> getAdmin();
	public void updateClinic(Clinics clinics);
	public List<Clinics>getClinics(String address,String specialization , String name);
	public List<Clinics>getAllClinics();
	public List<Clinics>getAllActiveClinics();
}
