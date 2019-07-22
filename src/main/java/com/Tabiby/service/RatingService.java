package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Users;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/16/2016.
 */
public interface RatingService {

    public void addRate(Rating rate);
    public boolean deleteRate(Users user, Clinics clinic);
    public boolean updateRate(Rating rate);
    public  Integer getRatingCount(Clinics clinic);
    public  Integer getRatingCount(); // admin
    public List<Rating> getClinicRatings(Clinics clinic);
    public List<Rating> getAllRatings();// admin
    public List<Rating> getUserRate(Users user, Clinics clinic);
}
