package com.Tabiby.service;

import com.Tabiby.Dao.PatientHistoryDao;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.PatientHistory;
import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zamalek on 9/30/2016.
 */
@Service("patientHistoryService")
public class PatientHistoryServiveImp implements PatientHistoryService  {
    @Autowired
    PatientHistoryDao patientHistoryDao;

    public PatientHistoryDao getPatientHistoryDao() {
        return patientHistoryDao;
    }

    public void setPatientHistoryDao(PatientHistoryDao patientHistoryDao) {
        this.patientHistoryDao = patientHistoryDao;
    }

    @Override
    @Transactional
    public void addVisit(PatientHistory patientHistory) {
        this.patientHistoryDao.addVisit(patientHistory);
    }

    @Override
    @Transactional
    public List<PatientHistory> getVisits(Users users, Clinics clinics) {
        return this.patientHistoryDao.getVisits(users, clinics);
    }
    @Override
    @Transactional
    public List<PatientHistory> getVisits(long id){
        return  this.patientHistoryDao.getVisits(id);
    }
    @Override
    @Transactional
    public PatientHistory getVisit(long id){
        return  this.patientHistoryDao.getVisit(id);
    }
    @Override
    @Transactional
    public void deleteVisit(PatientHistory patientHistory){
        this.patientHistoryDao.deleteVisit(patientHistory);
    }
}
