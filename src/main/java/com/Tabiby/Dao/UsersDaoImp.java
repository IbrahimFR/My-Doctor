package com.Tabiby.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Users;
/**
 * Created by zamalek on 8/12/2016.
 */

@Repository("userDao")
public class UsersDaoImp implements UsersDao {
    public static final Logger logger = LoggerFactory
            .getLogger(UsersDaoImp.class);

    @Autowired
	private SessionFactory sessionFactory;

    public UsersDaoImp(){
        // TODO Auto-generated constructor stub
    }

    public void setSessionFactory(SessionFactory sf) {
		sessionFactory = sf;
	}

    @Override
    @Transactional
    public void addUsers(Users user) {
        Session session = this.sessionFactory.openSession();

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

	 @Override
     @Transactional
     public List<Users> searchUserName(String userName) {
        Session session = sessionFactory.openSession();
        session.getTransaction().begin();;
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("username", userName));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
         session.close();

        return list;
    }
    @Override
    @Transactional
    public List<Users> searchUserVerified(String userName) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("username", userName),
                Restrictions.eq("emailVerification", true)));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

	@Override
     @Transactional
     public List<Users> searchUserEmail(String email) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("email", email));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();


        return list;
    }

	@Override
	@Transactional
	public List<Users> searchUserMobile(String mobile) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("mobile", mobile));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        
        return list;
	}

    @Override
    @Transactional
    public List<Users> searchUserToken(String token , String mobile) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("mobile", mobile),
                Restrictions.eq("emailVerificationToken", token)));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();


        return list;
    }
    @Override
    @Transactional
    public List<Users>searchForgetToken(String mobile , String token){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("mobile", mobile),
                Restrictions.eq("forgetPasswordToken", token)));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public List<Users> searchUserAccount(String pass, String mobile) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.and(
                Restrictions.eq("mobile", mobile),
                Restrictions.eq("password", pass)));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();

        return list;
    }

    @Override
    @Transactional
    public boolean updateUser(Users users) {
        Session session = this.sessionFactory.openSession();
        session.getTransaction().begin();
        session.update(users);
        session.getTransaction().commit();
        session.close();
        return true;
    }
    @Override
    @Transactional
    public List<Users>getUsers(List<String>userName){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.in("username", userName));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();

        return list;
    }
    public List<Users> getUser(long id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        criteria.add(Restrictions.eq("id", id));
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public List<Users> getUsers(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Users.class);
        List<Users> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

}
