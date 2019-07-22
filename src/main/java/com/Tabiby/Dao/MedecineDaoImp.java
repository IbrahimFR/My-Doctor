package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.MedecineList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Repository("medecineDao")
public class MedecineDaoImp implements MedecineDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addMedecine(MedecineList medecineList) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(medecineList);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public boolean updateMedecine(MedecineList medecineList) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(medecineList);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    @Transactional
    public boolean deleteMedecine(MedecineList medecineList) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(medecineList);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    @Transactional
    public int getMedecineCount(long clinics) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MedecineList.class);
        criteria.add(Restrictions.eq("clinicId", clinics));
        List<MedecineList> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }

    @Override
    @Transactional
    public int getMedecineCount() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MedecineList.class);
        List<MedecineList> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }
    @Override
    @Transactional
    public List<MedecineList> getMedecineClinic(long clinics){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MedecineList.class);
        criteria.add(Restrictions.eq("clinicId", clinics));
        List<MedecineList> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;

    }
    @Override
    @Transactional
    public MedecineList getMedicine(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MedecineList.class);
        criteria.add(Restrictions.eq("id", id));
        MedecineList list = (MedecineList) criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return list;

    }
    @Override
    @Transactional
    public List<MedecineList> getAllMedecine(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(MedecineList.class);
        List<MedecineList> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
