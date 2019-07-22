package com.Tabiby.Controller;

import java.util.List;

import com.Tabiby.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Reservation;
import com.Tabiby.Model.Users;
import com.Tabiby.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	 @Autowired
	 ReservationService reservationService;
    @Autowired
    ClinicService clinicService;
    @RequestMapping("")
	public String gotoReservations(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
//        List<Clinics> C_U =  clinicService
//                .searchClinicName(userName);
        List<Reservation> reservations =reservationService.getReservationForClinic(userName);
        model.addAttribute("reservations", reservations);
        return "reservations";
}
	@RequestMapping(value = "/getReservations", method = RequestMethod.GET)
    public String getReservations(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        Clinics C_U = (Clinics) clinicService
                .getClinicByEmail(userName);
		List<Reservation> reservations =reservationService.getReservationForClinic(C_U);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getall(Model model)
    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Reservation> reservations =reservationService.getReservationForClinic(userName);
        model.addAttribute("reservations", reservations);
        return "reservations";
    }
}
