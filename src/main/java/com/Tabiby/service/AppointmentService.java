package com.Tabiby.service;

import com.Tabiby.Model.Appointment;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Users;

import java.util.List;

public interface AppointmentService {

	public void addAppiontment(Appointment appiontment);
	public  boolean deleteAppointment( Appointment appointment);
	public boolean updateAppointment(Appointment appointment);
    public Integer getAppointmentCount(Clinics clinics);
	public  Integer getAppointmentCount();
	public  List<Appointment>getClinicAppointment(Clinics clinics);
	public  List<Appointment>getAllAppointments();
	public  Appointment getAppointment(long id );
	public  List <Appointment>getUserAppointments(Clinics clinics, Users users);
	public List<Appointment> getUserAppointments(String userName);
	public  List<Appointment>getCurrentAppointment(String userName, String clinicName, String time);

}
