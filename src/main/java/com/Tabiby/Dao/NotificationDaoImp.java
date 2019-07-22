package com.Tabiby.Dao;

import com.Tabiby.Model.Notification;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 11/24/2016.
 */
@Repository("notificationDao")
public class NotificationDaoImp implements NotificationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addNotification(Notification notification) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(notification);
        session.getTransaction().commit();
        session.close();
    }
    @Override
    @Transactional
    public void updateNotification(Notification notification) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.update(notification);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public List<Notification> getNotification(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Notification.class);
        criteria.add(Restrictions.eq("user", userName));
        criteria.add(Restrictions.eq("flag", "true"));
        List<Notification> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
