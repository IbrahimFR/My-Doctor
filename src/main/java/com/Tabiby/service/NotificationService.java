package com.Tabiby.service;

import com.Tabiby.Model.Notification;

import java.util.List;

/**
 * Created by ibrahimfouad on 11/24/2016.
 */
public interface NotificationService {

    public void addNotification(Notification notification);
    public void updateNotification(Notification notification);
    public List<Notification> getNotification(String userName);
}
