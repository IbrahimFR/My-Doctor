package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Doctors;

import java.util.List;

@Repository("doctorDao")
public class DoctorDaoImp implements DoctorDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}




	@Override
	@Transactional
	public void addDoctor(Doctors doctor) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
		session.close();
		
	}

	@Override
	@Transactional
	public boolean updateDoctor(Doctors doctors) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.update(doctors);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public boolean deleteDoctor(Doctors doctors) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(doctors);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public int getClinicDoctorCount(long clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Doctors.class);
		criteria.add(Restrictions.eq("clinicId", clinics));
		List<Doctors> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public int getDoctorCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Doctors.class);
		List<Doctors> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public List<Doctors> getClinicDoctor(long clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Doctors.class);
		criteria.add(Restrictions.eq("clinicId", clinics));
		List<Doctors> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public List<Doctors> getAllDoctors() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Doctors.class);
		List<Doctors> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public Doctors getDoctor(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Doctors.class);
		criteria.add(Restrictions.eq("id", id));
		Doctors doctor = (Doctors) criteria.list().get(0);
		session.getTransaction().commit();
		session.close();
		return doctor;
	}

}
