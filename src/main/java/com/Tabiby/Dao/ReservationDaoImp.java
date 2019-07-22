package com.Tabiby.Dao;

import java.util.List;

import com.Tabiby.Model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Reservation;

@Repository("reservationDao")
public class ReservationDaoImp implements ReservationDao {
	
	@Autowired
	private SessionFactory  sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public void addReservation(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(reservation);
        session.getTransaction().commit();
		session.close();

		
	}

	@Override
	@Transactional
	public boolean updateReservation(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(reservation);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public boolean deleteResercation(Reservation reservation) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(reservation);
		session.getTransaction().commit();
		session.close();
		return true;
	}


	@Override
	@Transactional
	public List<Reservation> getReservationForClinic(Clinics clinic) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("clinicName", clinic.getName()))
		.add(Restrictions.eq("status", true));// false = new
        List<Reservation> list = criteria.list();
        session.getTransaction().commit();
		session.close();
        return list;
	}
	@Override
	@Transactional
	public List<Reservation> getReservationForClinic(String clinic) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("clinicName", clinic))
		.add(Restrictions.eq("status",true));// true = new
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public List<Reservation> getAllReservations() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("status", true));
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public int ClinicReservationCount(Clinics clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("clinicName", clinics.getName()))
				.add(Restrictions.eq("status", true));
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public int ReservationCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		List<Reservation> list = criteria.list();
		criteria.add(Restrictions.eq("status", true));
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public List<Reservation> getUserReservations(Users users) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("userName", users.getUsername()))
				.add(Restrictions.eq("status", true));
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public List<Reservation> getUserReservations(Users users, Clinics clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("clinicName", clinics.getName()))
				.add(Restrictions.eq("userName", users.getUsername()))
				.add(Restrictions.eq("status", true));;
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public List<Reservation>getReservation(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Reservation.class);
		criteria.add(Restrictions.eq("id", id))
				.add(Restrictions.eq("status", true));
		List<Reservation> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
