package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.ServicesUsers;
import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Dao.ServiceClDao;

import java.util.List;

@Service("serviceClService")
public class ServiceClServiceImp implements ServiceClService {
	
	@Autowired
	private ServiceClDao serviceClDao;
	
	

	public ServiceClDao getServiceClDao() {
		return serviceClDao;
	}



	public void setServiceClDao(ServiceClDao serviceClDao) {
		this.serviceClDao = serviceClDao;
	}



	@Override
	@Transactional
	public void addService(com.Tabiby.Model.Service service) {
	this.serviceClDao.addService(service);
		
	}

	@Override
	@Transactional
	public void subscribeService(ServicesUsers servicesUsers) {
		this.serviceClDao.subscribeService(servicesUsers);
	}

	@Override
	@Transactional
	public boolean deleteService(com.Tabiby.Model.Service service) {
		return this.serviceClDao.deleteService(service);
	}

	@Override
	@Transactional
	public boolean updateService(com.Tabiby.Model.Service service) {
		return this.serviceClDao.updateService(service);
	}

	@Override
	@Transactional
	public int getClinicServiceCount(long clinics) {
		return this.serviceClDao.getClinicServiceCount(clinics);
	}

	@Override
	@Transactional
	public int getServiceCount() {
		return this.serviceClDao.getServiceCount();
	}

	@Override
	@Transactional
	public List<com.Tabiby.Model.Service> getClinicService(long clinics) {
		return this.serviceClDao.getClinicService(clinics);
	}

	@Override
	@Transactional
	public List<com.Tabiby.Model.Service> getAllService() {
		return this.serviceClDao.getAllService();
	}

	@Override
	@Transactional
	public List<ServicesUsers> getUserServices(Users users) {
		return this.serviceClDao.getUserServices(users);
	}

	@Override
	@Transactional
	public List<ServicesUsers> getUserServices(Users users, long clinics) {
		return this.serviceClDao.getUserServices(users,clinics);
	}

	@Override
	@Transactional
	public List<com.Tabiby.Model.Service> userServices(List<ServicesUsers> servicesUserses) {
		return this.serviceClDao.userServices(servicesUserses);
	}
	@Override
	@Transactional
	public List<com.Tabiby.Model.Service> getService(long id){
		return  this.serviceClDao.getService(id);
	}
}
