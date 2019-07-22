package com.Tabiby.Dao;

import com.Tabiby.Model.UploadedFile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Tabiby.Model.Files;

import java.util.List;


@Repository("fileUploadDao")
public class FileUploadDaoImp implements FileUploadDao{
   @Autowired
   private SessionFactory sessionFactory;

   public void setSessionFactory(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   @Transactional
   public void save(UploadedFile uploadFile) {
      Session session = this.sessionFactory.openSession();
      session.beginTransaction();
      session.save(uploadFile);
      session.getTransaction().commit();
      session.close();
   }
   @Override
   @Transactional
   public List<UploadedFile> getFiles(long clinic , long user){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(UploadedFile.class);
      criteria.add(Restrictions.and(
              Restrictions.eq("clinicId", clinic),
              Restrictions.eq("userId", user)
      ));
      List<UploadedFile> list = criteria.list();
      session.getTransaction().commit();
      session.close();
      return list;
   }
   @Override
   @Transactional
   public UploadedFile getFile(long id){
      Session session = sessionFactory.openSession();
      session.beginTransaction();
      Criteria criteria = session.createCriteria(UploadedFile.class);
      criteria.add(
           Restrictions.eq("id", id)
      );
      UploadedFile file = (UploadedFile) criteria.list().get(0);
      session.getTransaction().commit();
      session.close();
      return file;
   }
   @Override
   @Transactional
   public void delete (UploadedFile uploadedFile){
      Session session = this.sessionFactory.openSession();
      session.beginTransaction();
      session.delete(uploadedFile);
      session.getTransaction().commit();
      session.close();

   }
}