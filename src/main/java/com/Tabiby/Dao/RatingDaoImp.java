package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Users;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zamalek on 9/16/2016.
 */

@Repository("ratingDao")
public class RatingDaoImp implements  RatingDao {

    @Autowired
    private SessionFactory sessionFactory;


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addRate(Rating rate) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(rate);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public boolean deleteRate(Users user, Clinics clinic) {
        Session session = this.sessionFactory.openSession();
              Rating rate = new Rating();
        rate.setUserId(user);
        rate.setClinicId(clinic);
        session.delete(rate);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    @Transactional
    public boolean updateRate(Rating rate) {

        Session session = this.sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(rate);
        session.getTransaction().commit();
        session.close();
        return true;

    }

    @Override
    @Transactional
    public Integer getRatingCount(Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
       Criteria criteria = session.createCriteria(Rating.class);
        criteria.add(Restrictions.eq("clinicId", clinic));
        List<Rating> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }

    @Override
    @Transactional
    public Integer getRatingCount() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rating.class);
        List<Rating> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }

    @Override
    @Transactional
    public List<Rating> getClinicRatings(Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rating.class);

        criteria.add(Restrictions.eq("clinicId", clinic));
        List<Rating> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public List<Rating> getAllRatings() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rating.class);
        List<Rating> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    public List<Rating> getUserRate(Users user, Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Rating.class);
        criteria.add(Restrictions.eq("clinicId", clinic))
                .add(Restrictions.eq("userId", user));
        List<Rating> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
