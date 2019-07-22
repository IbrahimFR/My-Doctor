package com.Tabiby.service;

import com.Tabiby.Dao.MedecineDao;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.MedecineList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Service("medecineService")
public class MedecineServiceImp implements MedecineService {
    @Autowired
    private MedecineDao medecineDao;

    public MedecineDao getMedecineDao() {
        return medecineDao;
    }

    public void setMedecineDao(MedecineDao medecineDao) {
        this.medecineDao = medecineDao;
    }

    @Override
    @Transactional
    public void addMedecine(MedecineList medecineList) {
     this.medecineDao.addMedecine(medecineList);
    }

    @Override
    @Transactional
    public boolean updateMedecine(MedecineList medecineList) {
      return this.medecineDao.updateMedecine(medecineList);
    }

    @Override
    @Transactional
    public boolean deleteMedecine(MedecineList medecineList) {
        return this.medecineDao.deleteMedecine(medecineList);
    }

    @Override
    @Transactional
    public int getMedecineCount(long clinics) {
        return this.medecineDao.getMedecineCount(clinics);
    }

    @Override
    @Transactional
    public int getMedecineCount() {
        return this.medecineDao.getMedecineCount();
    }
    @Override
    @Transactional
    public List<MedecineList> getAllMedecine(){
        return this.medecineDao.getAllMedecine();
    }
    @Override
    @Transactional
    public List<MedecineList> getMedecineClinic(long clinics){
        return this.medecineDao.getMedecineClinic(clinics);
    }
    @Override
    @Transactional
    public MedecineList getMedicine(long id){
        return  this.medecineDao.getMedicine(id);
    }
}
