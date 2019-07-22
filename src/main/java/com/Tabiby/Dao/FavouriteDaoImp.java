package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Favourites;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 10/3/2016.
 */
@Repository("favouriteDao")
public class FavouriteDaoImp implements  FavouriteDao{
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addFavourite(Favourites favourites) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.save(favourites);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    @Transactional
    public void deleteFavourte(Favourites foFavourites) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.delete(foFavourites);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    @Transactional
    public List<Favourites> getFavourtes(String userName) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Criteria criteria = session.createCriteria(Favourites.class);
        criteria.add(Restrictions.eq("userName", userName));
        List<Favourites> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    @Override
    @Transactional
    public List<Favourites> getFavourites(String userName ,long clinicName ){
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        Criteria criteria = session.createCriteria(Favourites.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("userName", userName),
                Restrictions.eq("clinicId", clinicName)));
        List<Favourites> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
