package com.Tabiby.service;

import com.Tabiby.Dao.ClinicPicDao;
import com.Tabiby.Model.ClinicPic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 12/3/2016.
 */
@Service("clinicPicService")
public class ClinicPicServiceImp implements ClinicPicService{

    @Autowired
    private ClinicPicDao clinicPicDao;
    public ClinicPicDao getClinicPicDao() {
        return clinicPicDao;
    }

    public void setClinicPicDao(ClinicPicDao clinicPicDao) {
        this.clinicPicDao = clinicPicDao;
    }


    @Override
    @Transactional
    public List<ClinicPic> getclinicData(long id) {
     return   this.clinicPicDao.getclinicData(id);
    }
    @Override
    @Transactional
    public void updatePic(ClinicPic clinicPic){
        this.clinicPicDao.updatePic(clinicPic);
    }
    @Override
    @Transactional
    public  void addPic(ClinicPic clinicPic){
        this.clinicPicDao.addPic(clinicPic);
    }
}
