package com.Tabiby.service;

import com.Tabiby.Dao.ReviewDao;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Review;
import com.Tabiby.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Service("reviewService")
public class ReviewServiceImp implements ReviewService {

    @Autowired
    private ReviewDao reviewDao;

    public ReviewDao getReviewDao() {
        return reviewDao;
    }

    public void setReviewDao(ReviewDao reviewDao) {
        this.reviewDao = reviewDao;
    }

    @Override
    @Transactional
    public void addReview(Review review) {
        this.reviewDao.addReview(review);
    }

    @Override
    @Transactional
    public boolean deleteReview(Users user, Clinics clinic) {
        return this.reviewDao.deleteReview(user,clinic);
    }

    @Override
    @Transactional
    public boolean updateReview(Review review, Users user, Clinics clinic) {
        return this.reviewDao.updateReview(review,user,clinic);
    }

    @Override
    @Transactional
    public Integer getReviewCount(Clinics clinic) {
        return this.reviewDao.getReviewCount(clinic);
    }

    @Override
    @Transactional
    public Integer getReviewCount() {
        return this.reviewDao.getReviewCount();
    }

    @Override
    @Transactional
    public List<Review> getClinicReviews(Clinics clinic) {
        return getClinicReviews(clinic);
    }

    @Override
    @Transactional
    public List<Review> getAllReviews() {
        return getAllReviews();
    }

    @Override
    @Transactional
    public List<Review> getUserReview(Users user, Clinics clinic) {
        return getUserReview(user,clinic);
    }
}
