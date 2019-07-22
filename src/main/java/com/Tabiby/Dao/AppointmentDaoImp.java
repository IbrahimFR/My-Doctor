package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Appointment;

import java.util.List;

@Repository("appointmentDao")
public class AppointmentDaoImp implements AppointmentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}

	@Override
	@Transactional
	public void addAppointment(Appointment appointment) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
        session.save(appointment);
        session.getTransaction().commit();
        session.close();

	}



	@Override
	@Transactional
	public boolean deleteAppointment(Appointment appointment) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(appointment);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public boolean updateAppointment(Appointment appointment) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(appointment);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public Integer getAppointmentCount(Clinics clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("clinicName", clinics.getName()))
		        .add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public Integer getAppointmentCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public List<Appointment> getClinicAppointment(Clinics clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("clinicName", clinics.getName()))
	         	.add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;

	}

	@Override
	@Transactional
	public List<Appointment> getAllAppointments() {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();

		return list;
	}
	@Override
	@Transactional
	public  Appointment getAppointment(long id ){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("id", id));
		Appointment list = (Appointment) criteria.list().get(0);
		session.getTransaction().commit();
		session.close();

		return list;
	}
	@Override
	@Transactional
	public List<Appointment> getUserAppointments(Clinics clinics, Users users) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
			Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("clinicName", clinics.getName()))
				.add(Restrictions.eq("userName", users.getUsername()))
				.add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Appointment> getUserAppointments(String userName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("userName", userName))
		        .add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public  List<Appointment>getCurrentAppointment(String userName, String clinicName, String time){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Appointment.class);
		criteria.add(Restrictions.eq("clinicName", clinicName))
				.add(Restrictions.eq("userName", userName))
				.add(Restrictions.eq("Time", time))
				.add(Restrictions.eq("canceled", "false"));
		List<Appointment> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
}
