package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.ServicesUsers;
import com.Tabiby.Model.Users;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Service;

import java.util.ArrayList;
import java.util.List;

@Repository("ServiceClDao")
public class ServiceClDaoImp implements ServiceClDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	@Transactional
	public void addService(Service service) {
		 Session session = this.sessionFactory.openSession();
	        session.beginTransaction();
	        session.save(service);
	        session.getTransaction().commit();
            session.close();
		
	}

	@Override
	@Transactional
	public void subscribeService(ServicesUsers servicesUsers) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(servicesUsers);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	@Transactional
	public boolean deleteService(Service service) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.delete(service);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public boolean updateService(Service service) {
		Session session = this.sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.update(service);
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	@Transactional
	public int getClinicServiceCount(long clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Service.class);
		criteria.add(Restrictions.eq("clinicId", clinics));
		List<Service> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public int getServiceCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Service.class);
		List<Service> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list.size();
	}

	@Override
	@Transactional
	public List<Service> getClinicService(long clinics) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Service.class);
		criteria.add(Restrictions.eq("clinicId", clinics));
		List<Service> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	public List<Service> getAllService() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Service.class);
		criteria.add(Restrictions.eq("status", "true"));
		List<Service> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public List<ServicesUsers> getUserServices(Users users) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ServicesUsers.class);
		criteria.add(Restrictions.eq("userId", users));
		List<ServicesUsers> list = criteria.list();
		session.getTransaction().commit();
		return list;
	}
	@Override
	@Transactional
	public List<Service> getService(long id){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Service.class);
		criteria.add(Restrictions.eq("serviceId", id));
		List<Service> list = criteria.list();
		session.getTransaction().commit();
		session.close();
		return list;
	}

	@Override
	@Transactional
	public List<ServicesUsers> getUserServices(Users users, long clinics) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(ServicesUsers.class);
		criteria.add(Restrictions.eq("clinicId", clinics))
				.add(Restrictions.eq("userId", users));
		List<ServicesUsers> list = criteria.list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	@Transactional
	public List<Service> userServices(List<ServicesUsers> servicesUserses) {
		if(!servicesUserses.isEmpty()){
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Criteria criteria =null;
		List<Service> list2= new ArrayList<Service>();
		for(int i=0;i<servicesUserses.size();i++) {
			criteria = session.createCriteria(Service.class);
			criteria.add(Restrictions.eq("serviceId", servicesUserses.get(i).getServiceId()));
			List<Service> list = criteria.list();
			list2.addAll(list);
		}
			session.getTransaction().commit();
	  return list2;
	 }
		else{
			return null;
		}


	}


}
