package com.Tabiby.Controller;

import com.Tabiby.Model.Appointment;
import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Reservation;
import com.Tabiby.Model.Users;
import com.Tabiby.service.AppointmentService;
import com.Tabiby.service.ClinicService;
import com.Tabiby.service.ReservationService;
import com.Tabiby.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrahimfouad on 11/4/2016.
 */
@Controller
public class UsersController {
    @Autowired
    UsersService usersService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    AppointmentService appointmentService;
    @Autowired
    ClinicService clinicService;

    @RequestMapping("/admin/user")
    public String gotoAdminClinic(ModelMap model)

    {   Authentication auth = SecurityContextHolder.getContext()
            .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {
                List<Users> users = usersService.getUsers();
                model.addAttribute("users", users);
                return "admin_user";
            }
        return "redirect:/index";
    }
    @RequestMapping(value = "/admin/user/reservation", method = RequestMethod.POST)
    public String userReservation(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                                    BindingResult result,ModelMap model)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {

                long id = users.getId();
                List<Users> useres = usersService.getUser(id);
                List<Reservation> reservations = reservationService.getUserReservations(useres.get(0));
                if (reservations.size() != 0)
                    model.addAttribute("reservations", reservations);
                return "admin_reservations";
            }
        return "redirect:/index";

    }
    @RequestMapping(value = "/admin/user/appointment", method = RequestMethod.POST)
    public String userAppointment(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                                    BindingResult result,ModelMap model)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {

                long id = users.getId();
                List<Users> useres = usersService.getUser(id);
                List<Appointment> appointments = appointmentService.getUserAppointments(useres.get(0).getUsername());
                if (appointments.size() != 0)
                    model.addAttribute("appointments", appointments);
                return "admin_appointments";
            }
        return "redirect:/index";

    }
    @RequestMapping(value = "/admin/user/clinic", method = RequestMethod.POST)
    public String userClinic(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                                  BindingResult result,ModelMap model)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {

                long id = users.getId();
                List<Users> useres = usersService.getUser(id);
                List<Appointment> appointments = appointmentService.getUserAppointments(useres.get(0).getUsername());
                if (appointments.size() != 0) {
                    List<Clinics> clinics = clinicService.searchClinicName(appointments.get(0).getClinicName());
                    if (clinics.size() != 0)
                        model.addAttribute("clinics", clinics);
                }
                return "admin_clinic";
            }
        return "redirect:/index";

    }

    @RequestMapping(value = "/admin/user/update", method = RequestMethod.POST)
    public String userUpdate(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                             BindingResult result)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {
                ModelMap model = null;
                long id = users.getId();
                String ssid = users.getSsid();
                List<Users> useres = usersService.getUser(id);
                useres.get(0).setSsid(ssid);
                usersService.updateUser(useres.get(0));
                return "redirect:/admin/user";
            }
        return "redirect:/index";

    }
    @RequestMapping(value = "/admin/user/active", method = RequestMethod.POST)
    public String userActive(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                             BindingResult result,ModelMap model)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {

                long id = users.getId();
                String ssid = users.getSsid();
                List<Users> useres = usersService.getUser(id);
                useres.get(0).setActive(true);
                usersService.updateUser(useres.get(0));
                return "redirect:/admin/user";
            }
        return "redirect:/index";

    }
    @RequestMapping(value = "/admin/user/deactive", method = RequestMethod.POST)
    public String userDeactive(@Valid @ModelAttribute("admin_user") com.Tabiby.Model.Users users,
                             BindingResult result)

    {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> list = clinicService.searchClinicName(userName);
        if(list.size()!=0)
            if(list.get(0).getRole().equals("ADMIN")) {
                ModelMap model = null;
                long id = users.getId();
                String ssid = users.getSsid();
                List<Users> useres = usersService.getUser(id);
                useres.get(0).setActive(false);
                usersService.updateUser(useres.get(0));
                return "redirect:/admin/user";
            }
        return "redirect:/index";

    }
}
