package com.Tabiby.service;

import java.util.List;

import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.ReservationDao;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Reservation;

@Service("reservationService")
public class ReservationServiceImp implements ReservationService {
	@Autowired
	private ReservationDao reservationDao;
	
	
	public ReservationDao getReservationDao() {
		return reservationDao;
	}


	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}


	@Override
	@Transactional
	public void addReservation(Reservation reservation) {
	
		this.reservationDao.addReservation(reservation);
		
	}

	@Override
	@Transactional
	public boolean updateReservation(Reservation reservation) {
		return this.reservationDao.updateReservation(reservation);
	}

	@Override
	@Transactional
	public boolean deleteResercation(Reservation reservation) {
		return this.reservationDao.deleteResercation(reservation);
	}


	@Override
	@Transactional
	public List<Reservation> getReservationForClinic(Clinics clinic) {
		return this.reservationDao.getReservationForClinic(clinic);
	}
	@Override
	@Transactional
	public List<Reservation> getReservationForClinic(String clinic) {
		return this.reservationDao.getReservationForClinic(clinic);
	}

	@Override
	@Transactional
	public List<Reservation> getAllReservations() {
		return this.reservationDao.getAllReservations();
	}

	@Override
	@Transactional
	public int ClinicReservationCount(Clinics clinics) {
		return this.reservationDao.ClinicReservationCount(clinics);
	}

	@Override
	@Transactional
	public int ReservationCount() {
		return this.reservationDao.ReservationCount();
	}

	@Override
	@Transactional
	public List<Reservation> getUserReservations(Users users) {
		return this.reservationDao.getUserReservations(users);
	}

	@Override
	@Transactional
	public List<Reservation> getUserReservations(Users users, Clinics clinics) {
		return this.reservationDao.getUserReservations(users,clinics);
	}
	@Override
	@Transactional
	public List<Reservation>getReservation(long id){
		return this.reservationDao.getReservation(id);
	}


}
