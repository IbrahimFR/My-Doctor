package com.Tabiby.Dao;

import java.util.List;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Reservation;
import com.Tabiby.Model.Users;

public interface ReservationDao {
 
	public void addReservation(Reservation reservation);
	public boolean updateReservation(Reservation reservation);
	public boolean deleteResercation(Reservation reservation);
	public List<Reservation>getReservationForClinic(Clinics clinic);
	public List<Reservation>getReservationForClinic(String clinic);
	public List<Reservation> getAllReservations();
	public int ClinicReservationCount(Clinics clinics);
	public int ReservationCount();
	public  List<Reservation>getUserReservations(Users users); //all clinics
	public  List<Reservation>getUserReservations(Users users,Clinics clinics);
	public List<Reservation>getReservation(long id);
}
