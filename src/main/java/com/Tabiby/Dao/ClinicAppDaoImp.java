package com.Tabiby.Dao;

import com.Tabiby.Model.Appointment;
import com.Tabiby.Model.ClinicAppointment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zamalek on 10/21/2016.
 */
@Repository("clinicAppDao")
public class ClinicAppDaoImp implements  ClinicAppDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        sessionFactory = sf;
    }

    @Override
    @Transactional
    public void addClinicApp(ClinicAppointment clinicAppointment) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(clinicAppointment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public void updateClinicApp(ClinicAppointment clinicAppointment) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(clinicAppointment);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long clinicName, String appCategory) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClinicAppointment.class);
        criteria.add(Restrictions.and(
                (Restrictions.eq("clinicName", clinicName)),
                (Restrictions.eq("appCategory", appCategory))));
        List<ClinicAppointment> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;



    }
    @Override
    @Transactional
    public void deleteClinicApp(ClinicAppointment clinicAppointment){
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(clinicAppointment);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClinicAppointment.class);
        criteria.addOrder(Order.asc("id"));
        List<ClinicAppointment> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long clinicName , String appCategory, String time){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClinicAppointment.class);
        criteria.add(Restrictions.and(
                (Restrictions.eq("clinicName", clinicName)),
                (Restrictions.eq("appCategory", appCategory)),
                (Restrictions.eq("time", time))
        ));
        List<ClinicAppointment> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    @Transactional
    public List<ClinicAppointment> getClinicAppointment(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ClinicAppointment.class);
        criteria.add(Restrictions.eq("id", id));
        List<ClinicAppointment> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
