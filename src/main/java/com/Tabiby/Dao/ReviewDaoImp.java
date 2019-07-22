package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Review;
import com.Tabiby.Model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by ibrahimfouad on 9/16/2016.
 */
@Repository("reviewDao")
public class ReviewDaoImp implements ReviewDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addReview(Review review) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(review);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    @Transactional
    public boolean deleteReview(Users user, Clinics clinic) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Review review = new Review();//error
        review.setUserId(user);
        review.setClinicId(clinic);
        session.delete(review);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    @Transactional
    public boolean updateReview(Review review, Users user, Clinics clinic) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        review.setClinicId(clinic);
        review.setUserId(user);
        session.update(review);
        session.close();
        return true;
    }

    @Override
    @Transactional
    public Integer getReviewCount(Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Review.class);
        criteria.add(Restrictions.eq("clinicId", clinic));
        List<Review> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }

    @Override
    @Transactional
    public Integer getReviewCount() {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Review.class);
        List<Review> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list.size();
    }

    @Override
    @Transactional
    public List<Review> getClinicReviews(Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Review.class);
        criteria.add(Restrictions.eq("clinicId", clinic));
        List<Review> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public List<Review> getAllReviews() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Review.class);
        List<Review> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public List<Review> getUserReview(Users user, Clinics clinic) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Review.class);
        criteria.add(Restrictions.eq("clinicId", clinic))
                .add(Restrictions.eq("userId", user));
        List<Review> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
