package com.Tabiby.Controller;

import java.io.IOException;
import java.sql.Blob;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.Valid;
import org.hibernate.Hibernate;

import com.Tabiby.Model.*;
import com.Tabiby.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClinicController {

	@Autowired
	private ClinicService clinicService;

	@Autowired
    private RatingService ratingService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	AppointmentService appointmentService;

	@Autowired
	ReservationService reservationService;
	@Autowired
	ClinicAppService clinicAppService;
	@Autowired
	UsersService  usersService;
	@Autowired
	ServiceClService serviceClService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	MedecineService medecineService;
	@Autowired
	ClinicPicService clinicPicService;
	
//	@Autowired
//	private DoctorService doctorService;
//	
	BCryptPasswordEncoder passwordEncoder;

	@Autowired(required=true)
	@Qualifier(value="clinicService")
	public void setClinicService(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
	

@RequestMapping("/admin")
public ModelAndView gotoAdmin(ModelMap model)

	{
		ModelAndView modelAndView;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		modelAndView = new ModelAndView("admin_index");
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				modelAndView.addObject("userCount",usersService.getUsers().size());
				modelAndView.addObject("clinicCount",clinicService.getAllClinics().size());
				modelAndView.addObject("appointmentCount", appointmentService.getAppointmentCount());
				modelAndView.addObject("reservationCount", reservationService.getAllReservations().size());
				modelAndView.addObject("clinicName",userName);
				return modelAndView;
			}

		return null;
}
	@RequestMapping("/admin/clinic")
	public String gotoAdminClinic(ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
		if(list.get(0).getRole().equals("ADMIN")) {
			List<Clinics> clinics = clinicService.getAllClinics();
			model.addAttribute("clinics", clinics);

			return "admin_clinic";
		}

		return "redirect:/index";
	}

	@RequestMapping("/admin/all")
	public String gotoAdminAll(ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				List<Clinics> clinics = clinicService.getAdmin();
				model.addAttribute("clinics", clinics);
				return "admin_all";
			}
		return "redirect:/index";
	}


	@RequestMapping("/admin/clinic/add")
	 public String gotoAdminaddClinic(ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				return "admin_addclinic";
			}
		return "redirect:/index";
	}
	@RequestMapping("/admin/add")
	public String gotoAdminadd(ModelMap model)

	{ Authentication auth = SecurityContextHolder.getContext()
			.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				return "admin_add";
			}
		return "redirect:/index";
	}
	@RequestMapping(value = "/admin/clinic/info", method = RequestMethod.POST)
	public String clinicInfo(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
									BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				long id = clinics.getId();
				List<Clinics> clinicses = clinicService.getClinic(id);
				if (clinicses.size() != 0) {
					model.addAttribute("clinicinfos", clinicses.get(0));
					return "admin_updateclinic";
				}
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/admin/clinic/reservation", method = RequestMethod.POST)
	public String clinicReservation(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
									  BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				long id = clinics.getId();
				List<Clinics> clinicses = clinicService.getClinic(id);
				List<Reservation> reservations = reservationService.getReservationForClinic(clinicses.get(0).getName());
				if (reservations.size() != 0) {
					model.addAttribute("reservations", reservations);

				}
				return "admin_reservations";
			}
		return "redirect:/index";

}

	@RequestMapping(value = "/admin/clinic/appointment", method = RequestMethod.POST)
	 public String clinicAppointment(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
									 BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				long id = clinics.getId();
				List<Clinics> clinicses = clinicService.getClinic(id);
				List<Appointment> appointments = appointmentService.getClinicAppointment(clinicses.get(0));
				if (appointments.size() != 0)
					model.addAttribute("appointments", appointments);
				return "admin_appointments";
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/admin/clinic/patient", method = RequestMethod.POST)
	public String clinicPatient(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
									BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				long id = clinics.getId();
				List<Clinics> C_U = clinicService.getClinic(id);
				List<Appointment> appointments = appointmentService.getClinicAppointment(C_U.get(0));
				List<String> listUsers = new ArrayList<String>();
				for (int ii = 0; ii < appointments.size(); ii++) {
					listUsers.add(ii, appointments.get(ii).getUserName());
				}
				if (listUsers.size() != 0) {
					List<Users> patient = usersService.getUsers(listUsers);
					model.addAttribute("patient", patient);
				}
				return "admin_patient";
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/admin/clinic/service", method = RequestMethod.POST)
	public String clinicService(@Valid @ModelAttribute("admin_service") com.Tabiby.Model.Clinics clinics,
									BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				long id = clinics.getId();
				List<Clinics> C_U = clinicService.getClinic(id);
				List<Service> service = serviceClService.getClinicService(C_U.get(0).getId());
				if (service.size() != 0)
					model.addAttribute("service", service);
				return "admin_service";
			}
		return "redirect:/index";
	}
	@RequestMapping(value = "/admin/clinic/service/delete", method = RequestMethod.POST)
	public String deleteService(@Valid @ModelAttribute("admin_clinic")Service service,BindingResult result) {
		ModelAndView modelAndView = null;
		long id = service.getServiceId();
		List<Service>services= serviceClService.getService(id);
		if(services.size()!=0)
			serviceClService.deleteService(services.get(0));
		return "admin_service";
	}
	@RequestMapping(value = "/admin/clinic/doctor", method = RequestMethod.POST)
	public String clinicDoctor(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
								BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				long id = clinics.getId();
				List<Clinics> C_U = clinicService.getClinic(id);
				List<Doctors> doctors = doctorService.getClinicDoctor(C_U.get(0).getId());
				if (doctors.size() != 0)
					model.addAttribute("doctors", doctors);
				return "admin_doctors";
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/admin/clinic/medicine", method = RequestMethod.POST)
	 public String clinicMedicine(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
								  BindingResult result,ModelMap model)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {

				long id = clinics.getId();
				List<Clinics> C_U = clinicService.getClinic(id);
				List<MedecineList> medecine = medecineService.getMedecineClinic(C_U.get(0).getId());
				if (medecine.size() != 0)
					model.addAttribute("medecine", medecine);
				return "admin_medecine";
			}
		return "redirect:/index";

	}
	@RequestMapping("/admin/clinic/medicine/delete")
	public String deleteMedecine(@Valid @ModelAttribute("admin_medecine")MedecineList medecineList,ModelMap model){
		long id = medecineList.getId();
		MedecineList medecineList1 =medecineService.getMedicine(id);
		medecineService.deleteMedecine(medecineList1);
		return "redirect:/admin/clinic/medicine";
	}
	@RequestMapping(value = "/admin/clinic/feedback", method = RequestMethod.POST)
	public String clinicFeedback(@Valid @ModelAttribute("admin_clinic") com.Tabiby.Model.Clinics clinics,
								 BindingResult result,ModelMap model)
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				long id = clinics.getId();
				List<Clinics> C_U = clinicService.getClinic(id);
				List<Rating> rates = ratingService.getClinicRatings(C_U.get(0));
				if (rates.size() != 0)
					model.addAttribute("rates", rates);

				return "admin_reviews";
			}
		return "redirect:/index";
	}
	@RequestMapping(value = "/admin/new", method = RequestMethod.POST)
	public ModelAndView adminRegisteration(@Valid @ModelAttribute("admin_add") com.Tabiby.Model.Clinics clinics,
									  BindingResult result)
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		ModelAndView modelAnd = new ModelAndView("index");
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				ModelAndView modelAndView = new ModelAndView("admin_add");
				if (result.hasErrors()) {

					return modelAndView;
				} else {
					List<Clinics> isExisted = clinicService.searchClinicName(clinics.getName());
					if (isExisted.size() != 0) {
						modelAndView
								.addObject("wellMessage",
										"Error! ");
						modelAndView
								.addObject("addAdminMessage",
										"UserName is already Existed !");
						return modelAndView;

					} else {
						modelAndView = new ModelAndView("admin_add");
						User user = new User();

						passwordEncoder = new BCryptPasswordEncoder();
						clinics.setName(clinics.getName());
						clinics.setEmail(clinics.getEmail());
						clinics.setAddress(clinics.getAddress());
						clinics.setSpecialization("                ");
						clinics.setFbPage("     ");
						clinics.setTwPage("     ");
						clinics.setType(clinics.getType() + "");
						clinics.setEmailVerification(true);
						clinics.setForgetPassword(false);
						clinics.setPassword(passwordEncoder.encode(clinics.getPassword()));
						clinics.setActive(true);
						clinics.setInActive(true);
						clinics.setDeleted(false);
						clinics.setLocked(false);
						clinics.setCreatedAt(new Date());
						clinics.setMobile(clinics.getMobile());
						clinics.setPhone("0");
						clinics.setRole("ADMIN");
						clinics.setRate(0);
						clinicService.addCinic(clinics);

						modelAndView
								.addObject("wellMessage",
										"Well Done! ");
						modelAndView
								.addObject("addAdminMessage",
										"You successfully added new Admin! ");

					}
				}
				return modelAndView;
			}

		return modelAnd;

	}
	@RequestMapping(value = "/admin/active", method = RequestMethod.POST)
	public String activeAdmin(@Valid @ModelAttribute("admin_all")Clinics clinics,BindingResult result,HttpServletRequest request,
							  HttpServletResponse response) throws IOException, ParseException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				Long id = clinics.getId();
				List<Clinics> clinicses = clinicService.getClinic(id);
				if (clinicses.size() != 0) {
					clinicses.get(0).setActive(true);
					clinicService.updateClinic(clinicses.get(0));

				} else {

				}
				return "redirect:/admin/all";
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/admin/deactive", method = RequestMethod.POST)
	public String deactiveAdmin(@Valid @ModelAttribute("admin_all")Clinics clinics,BindingResult result,HttpServletRequest request,
								HttpServletResponse response) throws IOException, ParseException {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				Long id = clinics.getId();
				List<Clinics> clinicses = clinicService.getClinic(id);
				if (clinicses.size() != 0) {
					clinicses.get(0).setActive(false);
					clinicService.updateClinic(clinicses.get(0));

				} else {

				}
				return "redirect:/admin/all";
			}
		return "redirect:/index";

	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	  public ModelAndView clinicRegisteration(@Valid @ModelAttribute("admin_addclinic") com.Tabiby.Model.Clinics clinics,
			  BindingResult result)
			  		  {
						  Authentication auth = SecurityContextHolder.getContext()
								  .getAuthentication();
						  String userName = auth.getName();

						  List<Clinics> list = clinicService.searchClinicName(userName);
						  if(list.size()!=0)
							 if(list.get(0).getRole().equals("ADMIN")) {
								  ModelAndView modelAndView;
								  modelAndView = new ModelAndView("admin_addclinic");
								  if (result.hasErrors()) {
									  return modelAndView;
								  } else {
									  modelAndView = new ModelAndView("admin_addclinic");
									  List<Clinics> isExisted = clinicService.searchClinicName(clinics.getName());
									  if (isExisted.size() != 0) {
										  modelAndView
												  .addObject("wellMessage",
														  "Error! ");
										  modelAndView
												  .addObject("addClinicMessage",
														  "Clinic UserName is already Existed !");
										  return modelAndView;

									  } else {
										  passwordEncoder = new BCryptPasswordEncoder();
										  clinics.setName(clinics.getName());
										  clinics.setTitle(clinics.getTitle() + "");
										  clinics.setEmail(clinics.getEmail());
										  clinics.setAddress(clinics.getAddress());
										  clinics.setLat(clinics.getLat());
										  clinics.setLang(clinics.getLang());
										  clinics.setSpecialization(clinics.getSpecialization());
										  clinics.setFbPage(clinics.getFbPage() + "");
										  clinics.setTwPage(clinics.getTwPage() + "");
										  clinics.setType(clinics.getType() + "");
										  clinics.setEmailVerification(false);
										  clinics.setForgetPassword(false);
										  clinics.setPassword(passwordEncoder.encode(clinics.getPassword()));
										  clinics.setActive(false);
										  clinics.setInActive(false);
										  clinics.setDeleted(false);
										  clinics.setLocked(false);
										  clinics.setCreatedAt(new Date());
										  clinics.setMobile(clinics.getMobile());
										  clinics.setPrice("");
										  clinics.setPhone("0");
										  clinics.setRole("USER");
										  clinics.setRate(0);
										  clinics.setDescreption("");
										  clinics.setFrfrom("");
										  clinics.setFrto("");
										  clinics.setTufrom("");
										  clinics.setTuto("");
										  clinics.setWefrom("");
										  clinics.setWeto("");
										  clinics.setThfrom("");
										  clinics.setThto("");
										  clinics.setMonfrom("");
										  clinics.setMonto("");
										  clinics.setSunfrom("");
										  clinics.setSunto("");
										  clinics.setSatfrom("");
										  clinics.setSatto("");
										  clinicService.addCinic(clinics);
										  List<Clinics> get = clinicService.searchClinicName(clinics.getName());
										  if (get.size() != 0) {
											  ClinicPic cl = new ClinicPic();
											  cl.setClinicId(get.get(0).getId());
											  cl.setPhoto(null);
											  clinicPicService.addPic(cl);
										  }
										  modelAndView.addObject("clinics", clinics);
										  modelAndView
												  .addObject("wellMessage",
														  "Well Done! ");
										  modelAndView
												  .addObject("addClinicMessage",
														  "You successfully added clinic ");
										  return modelAndView;
									  }

								  }
							  }
						 return null;
	  }
	@RequestMapping(value = "/admin/updateclinic", method = RequestMethod.POST)
	public ModelAndView clinicUpdateClinic(@Valid @ModelAttribute("admin_updateclinic") com.Tabiby.Model.Clinics clinics,
									  BindingResult result,ModelMap model)
	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		if(list.size()!=0)
			if(list.get(0).getRole().equals("ADMIN")) {
				ModelAndView modelAndView;
				modelAndView = new ModelAndView("admin_updateclinic");
				if (result.hasErrors()) {
					model.addAttribute("wellMessage","Error!");
					model.addAttribute("updateClinicMessage","Something went Wrong");
					return modelAndView;
				} else {
					List<Clinics> updatedclinic = clinicService.getClinic(clinics.getId());
					passwordEncoder = new BCryptPasswordEncoder();
					clinics.getTitle();
				//	updatedclinic.get(0).setName(updatedclinic.get(0).getName());
  				    updatedclinic.get(0).setTitle(clinics.getTitle() + "");
					updatedclinic.get(0).setEmail(clinics.getEmail());
					updatedclinic.get(0).setAddress(clinics.getAddress());
					updatedclinic.get(0).setLat(clinics.getLat());
					updatedclinic.get(0).setLang(clinics.getLang());
					updatedclinic.get(0).setSpecialization(clinics.getSpecialization());
					updatedclinic.get(0).setFbPage(clinics.getFbPage() + "");
					updatedclinic.get(0).setTwPage(clinics.getTwPage() + "");
					updatedclinic.get(0).setType(clinics.getType() + "");
					updatedclinic.get(0).setPassword(passwordEncoder.encode(clinics.getPassword()));
					updatedclinic.get(0).setMobile(clinics.getMobile());
					updatedclinic.get(0).setRole("USER");
					clinicService.updateClinic(updatedclinic.get(0));
//					List<Clinics> get = clinicService.searchClinicName(clinics.getName());
//					if(get.size()!=0) {
//						ClinicPic cl = new ClinicPic();
//						cl.setClinicId(get.get(0).getId());
//						cl.setPhoto(null);
//						clinicPicService.addPic(cl);
//					}
					model.addAttribute("wellMessage","Well Done!");
					model.addAttribute("updateClinicMessage","You successfully updated clinic ");
					return modelAndView;
				}

			}
		return null;
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView userDashBoard() {
		ModelAndView modelAndView;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();

		if (userName != null) {

			Clinics C_U = (Clinics) clinicService
					.getClinicByEmail(userName);
			if(C_U.getRole().equals("USER")){
			if (!C_U.isLocked()) {

				modelAndView = new ModelAndView("index");
				modelAndView.addObject("clinicName", C_U.getName());
				modelAndView.addObject("reviewCount",reviewService.getReviewCount(C_U).toString());
				modelAndView.addObject("rateCount",ratingService.getRatingCount(C_U).toString());
				modelAndView.addObject("appointmentCount", appointmentService.getAppointmentCount(C_U).toString());
				modelAndView.addObject("reservationCount", reservationService.ClinicReservationCount(C_U)+"");
				if(!C_U.getDescreption().equals("null"))
				modelAndView.addObject("descreption",C_U.getDescreption()+"");
				modelAndView.addObject("price", C_U.getPrice() + "");
				modelAndView.addObject("mobile",C_U.getMobile()+"");
				modelAndView.addObject("satfrom",C_U.getSatfrom()+"");
				modelAndView.addObject("satto",C_U.getSatto()+"");
				modelAndView.addObject("sunfrom",C_U.getSunfrom()+"");
				modelAndView.addObject("sunto",C_U.getSunto()+"");
				modelAndView.addObject("monfrom",C_U.getMonfrom()+"");
				modelAndView.addObject("monto",C_U.getMonto()+"");
				modelAndView.addObject("tufrom",C_U.getTufrom()+"");
				modelAndView.addObject("tuto", C_U.getTuto()+"");
				modelAndView.addObject("wefrom",C_U.getWefrom()+"");
				modelAndView.addObject("weto", C_U.getWeto()+"");
				modelAndView.addObject("thfrom",C_U.getThfrom()+"");
				modelAndView.addObject("thto", C_U.getThto()+"");
				modelAndView.addObject("frfrom",C_U.getFrfrom()+"");
				modelAndView.addObject("frto", C_U.getFrto()+"");
				return modelAndView;
			} else {
				modelAndView = new ModelAndView("verfiy");
				modelAndView.addObject("message",
						"Pleas Cerfy The Email First  ");
				return modelAndView;
			}}
			else{
				if(C_U.getType().equals("Sales")){
					modelAndView = new ModelAndView("admin_sales");
					modelAndView.addObject("clinicName", C_U.getName());
					return modelAndView;
				}
				else {
					modelAndView = new ModelAndView("admin_index");
					modelAndView.addObject("userCount",usersService.getUsers().size());
					modelAndView.addObject("clinicCount",clinicService.getAllClinics().size());
					modelAndView.addObject("appointmentCount", appointmentService.getAppointmentCount());
					modelAndView.addObject("reservationCount", reservationService.getAllReservations().size());
					modelAndView.addObject("clinicName", C_U.getName());
					return modelAndView;
				}
			}
		} else {
			// session.invalidate();
			modelAndView = new ModelAndView("verfiy");
			Clinics C_U = (Clinics) clinicService
					.getClinicByEmail(userName);

			modelAndView.addObject("clinicName", "Hello " + C_U.getName());
			modelAndView.addObject("message", "Verfy The Email First  ");
			return modelAndView;
		}
	}
//	@RequestMapping(value="/addDoctor")
//	public ModelAndView addDoctor(@Valid @ModelAttribute("doctor") Doctors doctor, BindingResult result){
//    ModelAndView modelAndView ;	
//    Clinics clinic = new Clinics();
//    
//    if(result.hasErrors()){
//		  modelAndView = new ModelAndView("doctors");
//		  return modelAndView;
//	  }
//	  else{
//	  modelAndView = new ModelAndView("doctors");
//	  clinic.getId();
//      doctor.setName(doctor.getName());
//      doctor.setEmail(doctor.getEmail());	
//      doctor.setMobile(doctor.getMobile());
//      doctor.setSpecialization(doctor.getSpecialization());
//      doctor.setDescreprion(doctor.getDescreprion());
//      doctor.setClinicId(clinic);
//      doctorService.addDoctor(doctor);
//      modelAndView.addObject("doctors", doctor);
//  	 modelAndView
//     .addObject("wellDoctorMessage",
//             "Well Done! ");
// 	  modelAndView
//      .addObject("addDoctorMessage",
//              "You successfully added doctor");
//   	  
//   	  
//	  }
//    
//    return modelAndView;
//		
//	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String upateClinic(@Valid @ModelAttribute("index")Clinics clinics,BindingResult result,HttpServletRequest request,
	HttpServletResponse response) {
		ClinicAppointment clinicAppointment = new ClinicAppointment();
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
	   List<Clinics> C_U =  clinicService.searchClinicName(userName);
		System.out.print(clinics.getDescreption());
		C_U.get(0).setDescreption(clinics.getDescreption() + "");
		C_U.get(0).setPrice(clinics.getPrice() + "");
		C_U.get(0).setMobile(clinics.getMobile() + "");


		List<ClinicAppointment> clinicAppointments = clinicAppService.getClinicAppointment(C_U.get(0).getId(),"SatAM:"+C_U.get(0).getSatfrom());
		if(clinicAppointments.isEmpty()) {
			String[] tokens = clinics.getSatfrom().split(",");
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SatAM:" + clinics.getSatfrom());
					clinicAppointment.setCategory("Sat");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
         for (int i=0;i<clinicAppointments.size();i++)
		 clinicAppService.deleteClinicApp(clinicAppointments.get(i));

			String[] tokens_= clinics.getSatfrom().split(",");
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SatAM:" + clinics.getSatfrom());
					clinicAppointment.setCategory("Sat");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}


		}
		C_U.get(0).setSatfrom(clinics.getSatfrom() + "");
		List<ClinicAppointment> SatPM = clinicAppService.getClinicAppointment(C_U.get(0).getId(), "SatPM:" +C_U.get(0).getSatto());
		if(SatPM.isEmpty()) {
			String[] tokens = clinics.getSatto().split(",");
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SatPM:" + clinics.getSatto());
					clinicAppointment.setCategory("Sat");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<SatPM.size();i++)
				clinicAppService.deleteClinicApp(SatPM.get(i));

			String[] tokens_= clinics.getSatto().split(",");
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SatPM:" + clinics.getSatto());
					clinicAppointment.setCategory("Sat");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}

			}


		}
		C_U.get(0).setSatto(clinics.getSatto() + "");
		List<ClinicAppointment> SunAM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"SunAM:" +C_U.get(0).getSunfrom());
		if(SunAM.isEmpty()) {
			String[] tokens = clinics.getSunfrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SunAM:" + clinics.getSunfrom());//
					clinicAppointment.setCategory("Sun");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<SunAM.size();i++)
				clinicAppService.deleteClinicApp(SunAM.get(i));//

			String[] tokens_= clinics.getSunfrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SunAM:" + clinics.getSunfrom());
					clinicAppointment.setCategory("Sun");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}


		}
		C_U.get(0).setSunfrom(clinics.getSunfrom() + "");
		List<ClinicAppointment> SunPM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"SunPM:"+C_U.get(0).getSunto());
		if(SunPM.isEmpty()) { //
			String[] tokens = clinics.getSunto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SunPM:" + clinics.getSunto());//
					clinicAppointment.setCategory("Sun");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<SunPM.size();i++)//
				clinicAppService.deleteClinicApp(SunPM.get(i)); //

			String[] tokens_= clinics.getSunfrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("SunPM:" + clinics.getSunto()); //
					clinicAppointment.setCategory("Sun");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}

			}


		}
		C_U.get(0).setSunto(clinics.getSunto() + "");
		List<ClinicAppointment> MonAM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"MonAM:"+C_U.get(0).getMonfrom());//
		if(MonAM.isEmpty()) { //
			String[] tokens = clinics.getMonfrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("MonAM:" + clinics.getMonfrom());//
					clinicAppointment.setCategory("Mon");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<MonAM.size();i++)//
				clinicAppService.deleteClinicApp(MonAM.get(i)); //

			String[] tokens_= clinics.getMonfrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("MonAM:" + clinics.getMonfrom()); //
					clinicAppointment.setCategory("Mon");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}

			}


		}
		C_U.get(0).setMonfrom(clinics.getMonfrom() + "");
		List<ClinicAppointment> MonPM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"MonPM:"+C_U.get(0).getMonto());//
		if(MonPM.isEmpty()) { //
			String[] tokens = clinics.getMonto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("MonPM:" + clinics.getMonto());
					clinicAppointment.setCategory("Mon");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<MonPM.size();i++)//
				clinicAppService.deleteClinicApp(MonPM.get(i)); //

			String[] tokens_= clinics.getMonto().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("MonPM:" + clinics.getMonto()); //
					clinicAppointment.setCategory("Mon");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}


		}
		C_U.get(0).setMonto(clinics.getMonto() + "");
		List<ClinicAppointment> TuAM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"TuAM:"+C_U.get(0).getTufrom());//
		if(TuAM.isEmpty()) { //
			String[] tokens = clinics.getTufrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("TuAM:" + clinics.getTufrom());//
					clinicAppointment.setCategory("Tu");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<TuAM.size();i++)//
				clinicAppService.deleteClinicApp(TuAM.get(i)); //

			String[] tokens_= clinics.getTufrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("TuAM:" + clinics.getTufrom()); //
					clinicAppointment.setCategory("Tu");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}


		}
		C_U.get(0).setTufrom(clinics.getTufrom() + "");
		List<ClinicAppointment> TuPM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"TuPM:"+C_U.get(0).getTuto());//
		if(TuPM.isEmpty()) { //
			String[] tokens = clinics.getTuto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("TuPM:" + clinics.getTuto());//
					clinicAppointment.setCategory("Tu");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<TuPM.size();i++)//
				clinicAppService.deleteClinicApp(TuPM.get(i)); //

			String[] tokens_= clinics.getTuto().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("TuPM:" + clinics.getTuto()); //
					clinicAppointment.setCategory("Tu");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}

			}


		}
		C_U.get(0).setTuto(clinics.getTuto() + "");
		List<ClinicAppointment> WeAM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"WeAM:"+C_U.get(0).getWefrom());//
		if(WeAM.isEmpty()) { //
			String[] tokens = clinics.getWefrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("WeAM:" + clinics.getWefrom());//
					clinicAppointment.setCategory("We");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<WeAM.size();i++)//
				clinicAppService.deleteClinicApp(WeAM.get(i)); //

			String[] tokens_= clinics.getWefrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("WeAM:" + clinics.getWefrom()); //
					clinicAppointment.setCategory("We");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}


		}
		C_U.get(0).setWefrom(clinics.getWefrom() + "");
		List<ClinicAppointment> WePM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"WePM:"+C_U.get(0).getWeto());//
		if(WePM.isEmpty()) { //
			String[] tokens = clinics.getWeto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("WePM:" + clinics.getWeto());//
					clinicAppointment.setCategory("We");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<WePM.size();i++)//
				clinicAppService.deleteClinicApp(WePM.get(i)); //

			String[] tokens_= clinics.getWeto().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("WePM:" + clinics.getWeto()); //
					clinicAppointment.setCategory("We");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}			}
		}
		C_U.get(0).setWeto(clinics.getWeto() + "");
		List<ClinicAppointment> ThAm= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"ThAM:"+C_U.get(0).getThfrom());//
		if(ThAm.isEmpty()) { //
			String[] tokens = clinics.getThfrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("ThAM:" + clinics.getThfrom());//
					clinicAppointment.setCategory("Th");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<ThAm.size();i++)//
				clinicAppService.deleteClinicApp(ThAm.get(i)); //

			String[] tokens_= clinics.getThfrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("ThAM:" + clinics.getThfrom()); //
					clinicAppointment.setCategory("Th");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}

		C_U.get(0).setThfrom(clinics.getThfrom() + "");
		List<ClinicAppointment> ThPM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"ThPM:"+C_U.get(0).getThto());//
		if(ThPM.isEmpty()) { //
			String[] tokens = clinics.getThto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("ThPM:" + clinics.getThto());//
					clinicAppointment.setCategory("Th");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<ThPM.size();i++)//
				clinicAppService.deleteClinicApp(ThPM.get(i)); //

			String[] tokens_= clinics.getThto().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("ThPM:" + clinics.getThto()); //
					clinicAppointment.setCategory("Th");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		C_U.get(0).setThto(clinics.getThto() + "");
		List<ClinicAppointment> FrAM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"FrAM:"+C_U.get(0).getFrfrom());//
		if(FrAM.isEmpty()) { //
			String[] tokens = clinics.getFrfrom().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("FrAM:" + clinics.getFrfrom());
					clinicAppointment.setCategory("Fr");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<FrAM.size();i++)//
				clinicAppService.deleteClinicApp(FrAM.get(i)); //

			String[] tokens_= clinics.getFrfrom().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("FrAM:" + clinics.getFrfrom()); //
					clinicAppointment.setCategory("Fr");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		C_U.get(0).setFrfrom(clinics.getFrfrom() + "");
		List<ClinicAppointment> FrPM= clinicAppService.getClinicAppointment(C_U.get(0).getId(),"FrPM:"+C_U.get(0).getFrto());//
		if(FrPM.isEmpty()) { //
			String[] tokens = clinics.getFrto().split(",");//
			int tokenCount = tokens.length;
			for (int j = 0; j < tokenCount; j++) {
				if(!tokens[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("FrPM:" + clinics.getFrto());//
					clinicAppointment.setCategory("Fr");
					clinicAppointment.setTime(tokens[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		else{
			for (int i=0;i<FrPM.size();i++)//
				clinicAppService.deleteClinicApp(FrPM.get(i)); //

			String[] tokens_= clinics.getFrto().split(",");//
			int tokenCount_= tokens_.length;
			for (int j = 0; j < tokenCount_; j++) {
				if(!tokens_[j].equals("")) {
					clinicAppointment.setClinicName(C_U.get(0).getId());
					clinicAppointment.setAppCategory("FrPM:" + clinics.getFrto()); //
					clinicAppointment.setCategory("Fr");
					clinicAppointment.setTime(tokens_[j]);
					clinicAppService.addClinicApp(clinicAppointment);
				}
			}
		}
		C_U.get(0).setFrto(clinics.getFrto() + "");
		clinicService.updateClinic(C_U.get(0));
		return "redirect:/index";
	}
	@RequestMapping(value = "/addlogo", method = RequestMethod.POST)
	public String addLogo(@Valid @ModelAttribute("index") com.Tabiby.Model.Clinics clinics,
						  @RequestParam("file") MultipartFile file)

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		List<ClinicPic>list1=clinicPicService.getclinicData(list.get(0).getId());
		Blob blob=null;
		try{
			byte[] contents = file.getBytes();
			blob = new SerialBlob(contents);
			list1.get(0).setPhoto(blob);
			clinicPicService.updatePic(list1.get(0));

		}
		catch(Exception e){e.printStackTrace();}
			return "redirect:/index";

	}
	@RequestMapping(value = "/admin/addlogo", method = RequestMethod.POST)
	public ModelAndView updateLogo(@Valid @ModelAttribute("admin_updateclinic") com.Tabiby.Model.Clinics clinics,
						  @RequestParam("file") MultipartFile file,ModelMap model)

	{
		ModelAndView modelAndView;
		modelAndView = new ModelAndView("admin_updateclinic");
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> list = clinicService.searchClinicName(userName);
		List<Clinics> updatedclinic = clinicService.getClinic(clinics.getId());
		List<ClinicPic>list1=clinicPicService.getclinicData(updatedclinic.get(0).getId());
		Blob blob=null;
		try{
			byte[] contents = file.getBytes();
			blob = new SerialBlob(contents);
			list1.get(0).setPhoto(blob);
			clinicPicService.updatePic(list1.get(0));

		}
		catch(Exception e){e.printStackTrace();}
		model.addAttribute("wellMessage","Well Done!");
		model.addAttribute("updateClinicMessage","You successfully updated clinic Logo");
		return modelAndView;

	}
	
}
