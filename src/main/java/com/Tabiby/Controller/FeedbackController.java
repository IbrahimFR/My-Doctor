package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Rating;
import com.Tabiby.Model.Review;
import com.Tabiby.service.ClinicService;
import com.Tabiby.service.RatingService;
import com.Tabiby.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/16/2016.
 */
@Controller
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    private RatingService ratingService;
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ClinicService clinicService;

    @RequestMapping("")
    public String gotoFeedback(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> C_U =  clinicService.searchClinicName(userName);
        List<Rating>reviews=ratingService.getClinicRatings(C_U.get(0));
        if(reviews.size()!=0)
        model.addAttribute("reviews",reviews);
//        List<Review>reviews=reviewService.getClinicReviews(C_U.get(0));
//        model.addAttribute("reviews",reviews);
        return "reviews";

}

    @RequestMapping(value = "/{clinicname}/rate")
      public void getClinicRate(@PathVariable("clinicname")String clinicName){
        List<Clinics> clinic=clinicService.searchClinicName(clinicName);
        ratingService.getClinicRatings(clinic.get(0));
    }
    @RequestMapping(value = "/{clinicname}/rateCount")
    public void getClinicRateCount(@PathVariable("clinicname")String clinicName){
        List<Clinics> clinic=clinicService.searchClinicName(clinicName);
        ratingService.getRatingCount(clinic.get(0));
    }
    @RequestMapping(value = "/admin/rate")
    public void getRate(){
        ratingService.getAllRatings();
    }
    @RequestMapping(value = "/admin/rateCount")
    public void getCountRate(){
        ratingService.getRatingCount();
    }

/***
 * reviews
 */
@RequestMapping(value = "/{clinicname}/review")
public void getClinicReview(@PathVariable("clinicname")String clinicName){
    List<Clinics> clinic=clinicService.searchClinicName(clinicName);
    reviewService.getClinicReviews(clinic.get(0));
}
    @RequestMapping(value = "/{clinicname}/reviewCount")
    public void getClinicReviewCount(@PathVariable("clinicname")String clinicName){
        List<Clinics> clinic=clinicService.searchClinicName(clinicName);
        reviewService.getReviewCount(clinic.get(0));
    }
    @RequestMapping(value = "/admin/review")
    public void getReview(){
        reviewService.getAllReviews();
    }
    @RequestMapping(value = "/admin/reviewCount")
    public void getCountReview(){
        reviewService.getReviewCount();
    }

}
