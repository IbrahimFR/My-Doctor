package com.Tabiby.Dao;

/**
 * Created by ibrahimfouad on 9/30/2016.
 */

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.PatientHistory;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("patientHistoryDao")
public class PatientHistoryDaoImp implements  PatientHistoryDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;

    }

    @Override
    @Transactional
    public void addVisit(PatientHistory patientHistory) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(patientHistory);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    @Transactional
    public List<PatientHistory> getVisits(Users users, Clinics clinics) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PatientHistory.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("userName", users.getUsername()),
                Restrictions.eq("clinicName", clinics.getName())
        ));
        List<PatientHistory> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    @Transactional
    public List<PatientHistory> getVisits(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PatientHistory.class);
        criteria.add(
                Restrictions.eq("id", id)
        );
        List<PatientHistory> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    @Transactional
    public PatientHistory getVisit(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(PatientHistory.class);
        criteria.add(
                Restrictions.eq("id", id)
        );
        PatientHistory patientHistory = (PatientHistory) criteria.list().get(0);
        session.getTransaction().commit();
        session.close();
        return patientHistory;
    }
    @Override
    @Transactional
    public void deleteVisit(PatientHistory patientHistory){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(patientHistory);
        session.getTransaction().commit();
        session.close();
    }
}
