package com.Tabiby.service;

import com.Tabiby.Dao.RatingDao;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/16/2016.
 */

@Service("ratingService")
public class RatingServiceImp implements  RatingService{

    @Autowired
    private RatingDao ratingDao;

    public RatingDao getRatingDao() {
        return ratingDao;
    }

    public void setRatingDao(RatingDao ratingDao) {
        this.ratingDao = ratingDao;
    }

    @Override
    @Transactional
    public void addRate(Rating rate) {
          this.ratingDao.addRate(rate);
    }

    @Override
    @Transactional
    public boolean deleteRate(Users user, Clinics clinic) {
        return this.ratingDao.deleteRate(user,clinic);

    }

    @Override
    public boolean updateRate(Rating rate) {
        return this.ratingDao.updateRate(rate);

    }

    @Override
    public Integer getRatingCount(Clinics clinic) {

        return this.ratingDao.getRatingCount(clinic);
    }

    @Override
    public Integer getRatingCount() {
        return this.ratingDao.getRatingCount();
    }

    @Override
    public List<Rating> getClinicRatings(Clinics clinic) {
        return this.ratingDao.getClinicRatings(clinic);
    }

    @Override
    public List<Rating> getAllRatings() {
        return this.ratingDao.getAllRatings();
    }

    @Override
    public List<Rating> getUserRate(Users user, Clinics clinic) {
        return this.ratingDao.getUserRate(user,clinic);
    }
}
