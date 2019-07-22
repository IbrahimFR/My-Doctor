package com.Tabiby.Controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.Tabiby.Model.*;
import com.Tabiby.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private ClinicService clinicService ;
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private UsersService usersService;
	@Autowired
	private ClinicAppService clinicAppService;
	@Autowired
	private NotificationService notificationService;
	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@RequestMapping("")
	public String gotoAppointment(ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> C_U =  clinicService.searchClinicName(userName);
		List<Appointment> appointments =appointmentService.getClinicAppointment(C_U.get(0));

		model.addAttribute("appointments", appointments);

		return "appointments";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAppointment(@Valid @ModelAttribute("reservations")Reservation reservation,BindingResult result,HttpServletRequest request,
									   HttpServletResponse response) throws IOException, ParseException {

		Long id = reservation.getId();
        List<Reservation>reservations = reservationService.getReservation(id);

		        ModelMap model=null;
		   String clinicName = reservations.get(0).getClinicName();
			Appointment appointment = new Appointment();
			    appointment.setClinicName(reservations.get(0).getClinicName());
		appointment.setUserName(reservations.get(0).getUserName());
		appointment.setTime(reservations.get(0).getTime());
		appointment.setUserStatus(reservations.get(0).getUserStatus());
		appointment.setReserveType(reservations.get(0).getReserveType());
		appointment.setCanceled("false");
		appointment.setService(reservations.get(0).getService());
		appointment.setClinicAppID(reservations.get(0).getClinicAppID());
		appointmentService.addAppiontment(appointment);// add appointment
		reservations.get(0).setStatus(false);
				reservation.setStatus(false);
				reservationService.updateReservation(reservations.get(0));
		List<ClinicAppointment> app = clinicAppService.getClinicAppointment(reservations.get(0).getClinicAppID());
		if(app.size()!=0) {
			app.get(0).setTimeFlag(null);
			clinicAppService.updateClinicApp(app.get(0));
		}
		Notification i = new Notification();
		i.setClinic(reservations.get(0).getClinicName());
		i.setUser(reservations.get(0).getUserName());
		i.setDate(new Date());
		i.setFlag("true");
		i.setType("Accepted Reservation ");
		i.setText("Your Appointment on time : " + reservations.get(0).getTime());
		notificationService.addNotification(i);
		return "redirect:/reservation";



	}
	@RequestMapping(value = "/cancel", method = RequestMethod.POST)
	public String rejectReservation(@Valid @ModelAttribute("reservations")Reservation reservation,BindingResult result,HttpServletRequest request,
								 HttpServletResponse response) throws IOException, ParseException {

		Long id = reservation.getId();
		List<Reservation>reservations = reservationService.getReservation(id);
		List<ClinicAppointment> app = clinicAppService.getClinicAppointment(reservations.get(0).getClinicAppID());
		if(app.size()!=0) {
			app.get(0).setTimeFlag(null);
			clinicAppService.updateClinicApp(app.get(0));
		}
		reservationService.deleteResercation(reservations.get(0));
		Notification i = new Notification();
		i.setClinic(reservations.get(0).getClinicName());
		i.setUser(reservations.get(0).getUserName());
		i.setDate(new Date());
		i.setFlag("true");
		i.setType("Rejected Reservation ");
		i.setText("Reservation  on time : " + reservations.get(0).getTime());
		notificationService.addNotification(i);
		return "redirect:/reservation";



	}
	@RequestMapping(value = "app/cancel", method = RequestMethod.POST)
	public String cancelApp(@Valid @ModelAttribute("appointments")Appointment appointment,BindingResult result,HttpServletRequest request,
									HttpServletResponse response) throws IOException, ParseException {

		long id = appointment.getId();
		Appointment appointments = appointmentService.getAppointment(id);
		appointments.setCanceled("true");
		appointmentService.updateAppointment(appointments);
		Notification i = new Notification();
		i.setClinic(appointments.getClinicName());
		i.setUser(appointments.getUserName());
		i.setDate(new Date());
		i.setFlag("true");
		i.setType("Canceled Appointment");
		i.setText("Appointment on time : " + appointments.getTime() );
		notificationService.addNotification(i);
		return "redirect:/appointment";
	}
	public ModelAndView gotoReservations(){
		return new ModelAndView("redirect:" + "http://www.yahoo.com");
	}
	

}
