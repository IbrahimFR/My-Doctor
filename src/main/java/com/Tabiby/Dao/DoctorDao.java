package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Doctors;

import java.util.List;

public interface DoctorDao {

	public void addDoctor(Doctors doctor);
	public boolean updateDoctor(Doctors doctors);
	public  boolean deleteDoctor(Doctors doctors);
	public int getClinicDoctorCount(long clinics);
	public int getDoctorCount();
	public List<Doctors>getClinicDoctor(long clinics);
	public List<Doctors>getAllDoctors();
	public Doctors getDoctor(long id);


	
}
