package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.DoctorDao;
import com.Tabiby.Model.Doctors;

import java.util.List;

@Service("doctorService")
public class DoctorServiceImp  implements DoctorService{
	@Autowired
	private DoctorDao doctorDao;
     
	 
	
	public DoctorDao getDoctorDao() {
		return doctorDao;
	}



	public void setDoctorDao(DoctorDao doctorDao) {
		this.doctorDao = doctorDao;
	}



	@Override
	@Transactional
	public void addDoctor(Doctors doctor) {
		this.doctorDao.addDoctor(doctor);
		
	}

	@Override
	@Transactional
	public boolean updateDoctor(Doctors doctors) {
		return this.doctorDao.updateDoctor(doctors);
	}

	@Override
	@Transactional
	public boolean deleteDoctor(Doctors doctors) {
		return this.doctorDao.deleteDoctor(doctors);
	}

	@Override
	@Transactional
	public int getClinicDoctorCount(long clinics) {
		return this.doctorDao.getClinicDoctorCount(clinics);
	}

	@Override
	@Transactional
	public int getDoctorCount() {
		return this.doctorDao.getDoctorCount();
	}

	@Override
	@Transactional
	public List<Doctors> getClinicDoctor(long clinics) {
		return this.doctorDao.getClinicDoctor(clinics);
	}

	@Override
	@Transactional
	public List<Doctors> getAllDoctors() {
		return this.doctorDao.getAllDoctors();
	}
	@Override
	@Transactional
	public Doctors getDoctor(long id){
		return  this.doctorDao.getDoctor(id);
	}
}
