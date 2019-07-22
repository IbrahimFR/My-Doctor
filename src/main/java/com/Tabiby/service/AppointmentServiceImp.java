package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.AppointmentDao;
import com.Tabiby.Model.Appointment;

import java.util.List;

@Service("appointmentService")
public class AppointmentServiceImp implements AppointmentService {
	
	@Autowired
	private AppointmentDao appointmentDao;

	
	public AppointmentDao getAppointmentDao() {
		return appointmentDao;
	}


	public void setAppointmentDao(AppointmentDao appointmentDao) {
		this.appointmentDao = appointmentDao;
	}


	@Override
	@Transactional
	public void addAppiontment(Appointment appointment) {
		this.appointmentDao.addAppointment(appointment);
		
	}

	@Override
	@Transactional
	public boolean deleteAppointment(Appointment appointment) {
		return this.appointmentDao.deleteAppointment(appointment);
	}

	@Override
	@Transactional
	public boolean updateAppointment(Appointment appointment) {
		return this.appointmentDao.updateAppointment(appointment);
	}

	@Override
	@Transactional
	public Integer getAppointmentCount(Clinics clinics) {
		return this.appointmentDao.getAppointmentCount(clinics);
	}

	@Override
	@Transactional
	public Integer getAppointmentCount() {
		return this.appointmentDao.getAppointmentCount();
	}

	@Override
	@Transactional
	public List<Appointment> getClinicAppointment(Clinics clinics) {
		return this.appointmentDao.getClinicAppointment(clinics);
	}

	@Override
	@Transactional
	public List<Appointment> getAllAppointments() {
		return this.appointmentDao.getAllAppointments();
	}

	@Override
	@Transactional
	public List<Appointment> getUserAppointments(Clinics clinics, Users users) {
		return this.appointmentDao.getUserAppointments(clinics, users);
	}

	@Override
	@Transactional
	public List<Appointment> getUserAppointments(String userName) {
		return this.appointmentDao.getUserAppointments(userName);
	}
	@Override
	@Transactional
	public  List<Appointment>getCurrentAppointment(String userName, String clinicName, String time){
		return this.appointmentDao.getCurrentAppointment(userName, clinicName, time);
	}
	@Override
	@Transactional
	public  Appointment getAppointment(long id ){
		return this.appointmentDao.getAppointment(id);
	}


}
