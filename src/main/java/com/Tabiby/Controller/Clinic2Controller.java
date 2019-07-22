package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by zamalek on 9/17/2016.
 */
@Controller
@RequestMapping("/clinic")
public class Clinic2Controller {

	@Autowired
	ClinicService clinicService;

    @RequestMapping("")
	public String gotoClinic(ModelMap model){
       	List<Clinics> clinics=  clinicService.getAllClinics();
		model.addAttribute("clinics", clinics);
		return "clinics";
	}
	@RequestMapping(value = "/active", method = RequestMethod.POST)
	public String activeClinic(@Valid @ModelAttribute("clinics")Clinics clinics,BindingResult result,HttpServletRequest request,
								 HttpServletResponse response) throws IOException, ParseException {
		Long id =clinics.getId();
		List<Clinics>clinicses= clinicService.getClinic(id);
		if(clinicses.size()!=0) {
			clinicses.get(0).setActive(true);
			clinicService.updateClinic(clinicses.get(0));

		}
		else{

		}
		return "redirect:/admin/clinic";


	}
	@RequestMapping(value = "/deactive", method = RequestMethod.POST)
	public String deactiveClinic(@Valid @ModelAttribute("clinics")Clinics clinics,BindingResult result,HttpServletRequest request,
								 HttpServletResponse response) throws IOException, ParseException {
		Long id =clinics.getId();
		List<Clinics>clinicses= clinicService.getClinic(id);
		if(clinicses.size()!=0) {
			clinicses.get(0).setActive(false);
			clinicService.updateClinic(clinicses.get(0));

		}else{

		}
		return "redirect:/admin/clinic";
	}


	}
