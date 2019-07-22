package com.Tabiby.Controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Tabiby.Model.Users;
import com.Tabiby.service.UsersService;

@Controller
public class User {

	@Autowired
	private UsersService userService;
	
	BCryptPasswordEncoder passwordEncoder;
	
//	@Autowired
//	private ClinicService clinicService;

	
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public void setUserService(UsersService userService) {
		this.userService = userService;
	} 
	
	
	
	
//    @Autowired(required = true)
//    @Qualifier(value ="clinicService")
//	public void setClinicService(ClinicService clinicService) {
//		this.clinicService = clinicService;
//	}


	

	@RequestMapping("/DB")
	public ModelAndView testDB() {
		ModelAndView modelAndView = new ModelAndView("clinics");
		modelAndView.addObject("message", "Clinic Added Successfully");
		// u = new com.Tabiby.Model.Users();
	    Users u = new Users();
		u.setCreatedAt(new Date());
		u.setEmail("email2");
		u.setEmailVerification(true);
		u.setPassword("passwrod");
		u.setAddress("fgg");
		u.setEmailVerification(true);
		u.setEmailVerificationToken("fff");
        u.setForgetPassword(true);
        u.setForgetPasswordToken("ggg");
        
        System.out.print(u.getAddress());
		userService.addUsers(u);
		return modelAndView;
	}

	public ModelAndView addClinic(@Valid @ModelAttribute("clinics") com.Tabiby.Model.Clinics clinics,
		  BindingResult result){
		ModelAndView modelAndView = new ModelAndView("clinics");
		if(result.hasErrors()){
			  modelAndView = new ModelAndView("clinics");
			  return modelAndView;
		  }
		  else{
			  modelAndView = new ModelAndView("clinics");
	          modelAndView
	                  .addObject("message",
	                          "Clinic is Added Sucessfully ");
			  passwordEncoder = new BCryptPasswordEncoder();
			  clinics.setName(clinics.getName());
			  clinics.setEmail(clinics.getEmail());
			  clinics.setAddress(clinics.getAddress());
			  clinics.setSpecialization(clinics.getSpecialization());
			  clinics.setFbPage(clinics.getFbPage());
			  clinics.setTwPage(clinics.getTwPage());
			  clinics.setEmailVerification(false);
			  clinics.setForgetPassword(false);
			  clinics.setPassword(passwordEncoder.encode(clinics.getPassword()));
			  clinics.setActive(true);
			  clinics.setInActive(false);
			  clinics.setDeleted(false);
			  clinics.setLocked(false);
			  clinics.setCreatedAt(new Date());
	     	  clinics.setMobile("");
	     	  clinics.setPhone("");
	     	  clinics.setRole("Clinic");
	     	///  clinicService.addClinic(clinics);
	     	  
	  }
		
		return modelAndView;
				
	
	
	}
}
