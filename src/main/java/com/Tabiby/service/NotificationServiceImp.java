package com.Tabiby.service;

import com.Tabiby.Dao.NotificationDao;
import com.Tabiby.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 11/24/2016.
 */
@Service("notificationService")
public class NotificationServiceImp implements NotificationService {

   @Autowired
   private NotificationDao notificationDao;

    public NotificationDao getNotificationDao() {
        return notificationDao;
    }

    public void setNotificationDao(NotificationDao notificationDao) {
        this.notificationDao = notificationDao;
    }

    @Override
    @Transactional
    public void addNotification(Notification notification) {
        this.notificationDao.addNotification(notification);
    }

    @Override
    @Transactional
    public void updateNotification(Notification notification){
        this.notificationDao.updateNotification(notification);
    }

    @Override
    @Transactional
    public List<Notification> getNotification(String userName) {

        return this.notificationDao.getNotification(userName);
    }
}
