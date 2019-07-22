package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Review;
import com.Tabiby.Model.Users;

import java.util.List;

/**
 * Created by zamalek on 9/17/2016.
 */
public interface ReviewService  {
    public void addReview(Review review);
    public boolean deleteReview(Users user, Clinics clinic);
    public boolean updateReview(Review review ,Users user, Clinics clinic );
    public Integer getReviewCount(Clinics clinic);
    public Integer getReviewCount();
    public List<Review> getClinicReviews(Clinics clinic);
    public List<Review> getAllReviews();
    public List<Review> getUserReview(Users user, Clinics clinic);
}
