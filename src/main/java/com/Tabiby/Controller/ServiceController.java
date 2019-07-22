package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.Service;
import com.Tabiby.service.ClinicService;
import com.Tabiby.service.ServiceClService;
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
 * Created by zamalek on 9/17/2016.
 */
@Controller
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private ClinicService clinicService;

	@Autowired
	private ServiceClService serviceClService;


    @RequestMapping("")
	public String gotoServices(ModelMap model){
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> C_U =  clinicService.searchClinicName(userName);
		List<Service> service =serviceClService.getClinicService(C_U.get(0).getId());
		model.addAttribute("service", service);
		return "service";
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addService(@Valid @ModelAttribute("service")Service service,BindingResult result) {
		ModelAndView modelAndView =null;
		if(result.hasErrors()){
			modelAndView = new ModelAndView("service");
			return "redirect:/service";
		}
		else {
			modelAndView = new ModelAndView("service");
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String userName = auth.getName();

			if (userName != null) {

				Clinics C_U = (Clinics) clinicService
						.getClinicByEmail(userName);
				service.setClinicId(C_U.getId());
				service.setClinicName(C_U.getName());
				service.setService(service.getService());
				service.setCurrency(service.getCurrency());
				service.setFees(service.getFees());
				service.setServiceHours(service.getServiceHours());
				service.setSpecialization(service.getSpecialization());
				service.setStatus("true");
				serviceClService.addService(service);
				modelAndView.addObject("service", service);
				modelAndView
						.addObject("wellServiceMessage",
								"Well Done! ");
				modelAndView
						.addObject("addServiceMessage",
								"You successfully added Service ");
				return "redirect:/service";

			}
		}
		return "redirect:/service";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteService(@Valid @ModelAttribute("service")Service service,BindingResult result) {
		ModelAndView modelAndView = null;
        long id = service.getServiceId();
		List<Service>services= serviceClService.getService(id);
		if(services.size()!=0)
		serviceClService.deleteService(services.get(0));
		return "redirect:/service";
	}
}
