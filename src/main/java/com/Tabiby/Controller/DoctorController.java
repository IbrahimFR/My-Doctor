package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Doctors;
import com.Tabiby.service.ClinicService;
import com.Tabiby.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	@Autowired
	ClinicService clinicService;
	@Autowired
	DoctorService doctorService;

	@RequestMapping("")
	public String gotoDoctors(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> C_U =  clinicService.searchClinicName(userName);
		List<Doctors>doctors=doctorService.getClinicDoctor(C_U.get(0).getId());
		model.addAttribute("doctors",doctors);
		return "doctors";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addDoctor(@Valid @ModelAttribute("doctors")Doctors doctors,BindingResult result) {
		ModelAndView modelAndView;

		if(result.hasErrors()){

			return "redirect:/doctor";
		}
		else {
			modelAndView = new ModelAndView("doctors");
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String userName = auth.getName();

			if (userName != null) {

				Clinics C_U = (Clinics) clinicService
						.getClinicByEmail(userName);
				doctors.setClinicId(C_U.getId());
				doctors.setEmail(doctors.getEmail());
				doctors.setMobile(doctors.getMobile());
				doctors.setName(doctors.getName());
				doctors.setSpecialization(doctors.getSpecialization());
				doctors.setDescreprion(doctors.getDescreprion());
				doctorService.addDoctor(doctors);
				modelAndView.addObject("doctors", doctors);
				modelAndView
						.addObject("wellDoctorMessage",
								"Well Done! ");
				modelAndView
						.addObject("addDoctorMessage",
								"You successfully added Doctor ");

			}
		}
		return "redirect:/doctor";
	}
	@RequestMapping("/delete")
	public String deleteMedecine(@Valid @ModelAttribute("doctors")Doctors doctors,ModelMap model){
		long id = doctors.getId();
		Doctors doctor = doctorService.getDoctor(id);
		doctorService.deleteDoctor(doctor);
		return "redirect:/doctor";
	}
}