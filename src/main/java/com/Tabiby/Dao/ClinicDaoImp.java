package com.Tabiby.Dao;

import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Clinics;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.TransactionScoped;


@Repository("clinicDao")
public class ClinicDaoImp implements ClinicDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	@Transactional
	public void addClinic(Clinics clinic) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
        session.save(clinic);
        session.getTransaction().commit();
		session.close();
		
	}


	@Override
	@Transactional
	public Clinics getClinicByEmail(String email) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();;
		Clinics user;
		Criteria criteria = session.createCriteria(Clinics.class);

		criteria.add(Restrictions.disjunction()
				.add(Restrictions.eq("email", email))
				.add(Restrictions.eq("name", email)));

		List<Clinics> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		if (list.size() == 1) {
			user = (Clinics) list.get(0);
			return user;
		} else {
			return null;
		}
}
	
	@Override
	@Transactional
	public List<Clinics> searchClinicName(String clinicName) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();;
        Criteria criteria = session.createCriteria(Clinics.class);
        criteria.add(Restrictions.eq("name", clinicName));
        List<Clinics> list = criteria.list();
        session.getTransaction().commit();
		session.close();
        return list;
	}

	@Override
	@Transactional
	public void updateClinic(Clinics clinics) {
		Session session = this.sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(clinics);
		session.getTransaction().commit();
		session.close();


}
	@Override
	@Transactional
	public List<Clinics>getClinics(String address,String specialization , String name){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();;
		Clinics user;
		Criteria criteria = session.createCriteria(Clinics.class);
		criteria.add(Restrictions.disjunction()
				.add(Restrictions.eq("address", address))
				.add(Restrictions.eq("specialization", specialization))
				.add(Restrictions.eq("name", name)));

		List<Clinics> list = criteria.list();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public List<Clinics>getAllClinics(){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Clinics.class);
		criteria.add(Restrictions.ne("role", "ADMIN"));
		List<Clinics> list = criteria.list();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public List<Clinics>getAllActiveClinics(){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Clinics.class);
		criteria.add(Restrictions.ne("role", "ADMIN"));
		criteria.add(Restrictions.ne("active", false));
		List<Clinics> list = criteria.list();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public List<Clinics> getAdmin(){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Clinics.class);
		criteria.add(Restrictions.ne("role", "USER"));
		List<Clinics> list = criteria.list();
		session.close();
		return list;
	}
	@Override
	@Transactional
	public List<Clinics> getClinic(Long id){
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Criteria criteria = session.createCriteria(Clinics.class);
		criteria.add(Restrictions.eq("id", id));
		List<Clinics>list = criteria.list();
		session.close();
		return list;
	}
//	@Override
//	@Transactional
//	public Blob addCinicPic(MultipartFile file) throws IOException {
//		Session session = sessionFactory.openSession();
//		session.getTransaction().begin();
//		//Blob blob = Hibernate.getLobCreator(session).createBlob(file.getInputStream());
//		return null;
//
//	}



}
