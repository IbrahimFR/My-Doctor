package com.Tabiby.service;

import com.Tabiby.Dao.ClinicAppDao;
import com.Tabiby.Model.ClinicAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zamalek on 10/21/2016.
 */
@Service("clinicAppService")
public class ClinicAppServiceImp implements  ClinicAppService  {

    @Autowired
    private ClinicAppDao clinicAppDao;

    public ClinicAppDao getClinicAppDao() {
        return clinicAppDao;
    }

    public void setClinicAppDao(ClinicAppDao clinicAppDao) {
        this.clinicAppDao = clinicAppDao;
    }

    @Override
    @Transactional
    public void addClinicApp(ClinicAppointment clinicAppointment) {
   this.clinicAppDao.addClinicApp(clinicAppointment);
    }

    @Override
    @Transactional
    public void updateClinicApp(ClinicAppointment clinicAppointment) {
   this.clinicAppDao.updateClinicApp(clinicAppointment);
    }

    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long clinicName, String appCategory) {
        return this.clinicAppDao.getClinicAppointment(clinicName, appCategory);
    }
    @Override
    @Transactional
    public void deleteClinicApp(ClinicAppointment clinicAppointment){
        this.clinicAppDao.deleteClinicApp(clinicAppointment);
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(){
      return  this.clinicAppDao.getClinicAppointment();
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long clinicName , String appCategory, String time){
      return this.clinicAppDao.getClinicAppointment(clinicName, appCategory, time) ;
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long id){
        return  this.clinicAppDao.getClinicAppointment(id);
    }
}
