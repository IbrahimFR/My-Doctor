package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Service;
import com.Tabiby.Model.ServicesUsers;
import com.Tabiby.Model.Users;

import java.util.List;

public interface ServiceClService {

	public void addService(Service service);
	public void subscribeService(ServicesUsers servicesUsers);
	public boolean deleteService(Service service);
	public boolean updateService(Service service);
	public int getClinicServiceCount(long clinics);
	public int getServiceCount();
	public List<Service> getService(long id);
	public List<Service> getClinicService(long clinics);
	public List<Service> getAllService();
	public  List<ServicesUsers>getUserServices(Users users);
	public  List<ServicesUsers>getUserServices(Users users,long clinics);
	public List<Service>userServices(List<ServicesUsers> servicesUserses);
}
