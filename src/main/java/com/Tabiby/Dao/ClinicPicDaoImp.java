package com.Tabiby.Dao;

import com.Tabiby.Model.ClinicPic;
import com.Tabiby.Model.Clinics;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

/**
 * Created by ibrahimfouad on 12/3/2016.
 */
@Repository("clinicPicDao")
public class ClinicPicDaoImp implements ClinicPicDao {
    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
   public List<ClinicPic> getclinicData(long id){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Criteria criteria = session.createCriteria(ClinicPic.class);
        criteria.add(Restrictions.eq("clinicId", id));
        List<ClinicPic>list = criteria.list();
        session.close();
        return list;

    }
    @Override
    @Transactional
    public void updatePic(ClinicPic clinicPic){
        Session session = this.sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(clinicPic);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    @Transactional
    public  void addPic(ClinicPic clinicPic){
        Session session = this.sessionFactory.openSession();
        session.getTransaction().begin();
        session.save(clinicPic);
        session.getTransaction().commit();
        session.close();
    }
}
