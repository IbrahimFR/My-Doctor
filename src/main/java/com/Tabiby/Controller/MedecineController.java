package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.MedecineList;
import com.Tabiby.service.ClinicService;
import com.Tabiby.service.MedecineService;
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
import java.util.Date;
import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Controller
@RequestMapping("/medecine")
public class MedecineController {
	@Autowired
	ClinicService clinicService;

	@Autowired
	MedecineService medecineService;


    @RequestMapping("")
	public String gotoMedecine(ModelMap model){
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String userName = auth.getName();
		List<Clinics> C_U =  clinicService.searchClinicName(userName);
		List<MedecineList>medecine= medecineService.getMedecineClinic(C_U.get(0).getId());
		model.addAttribute("medecine",medecine);
		return "medecine";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addMedecine(@Valid @ModelAttribute("medecine")MedecineList medecineList,BindingResult result) {
		ModelAndView modelAndView;

		if(result.hasErrors()){
			modelAndView = new ModelAndView("medecine");
			return "redirect:/medecine";
		}
		else {
			modelAndView = new ModelAndView("medecine");
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String userName = auth.getName();

			if (userName != null) {

				Clinics C_U = (Clinics) clinicService
						.getClinicByEmail(userName);

				medecineList.setClinicId(C_U.getId());
				medecineList.setDescreption(medecineList.getDescreption());
				medecineList.setCreateddAt(new Date());
				medecineList.setUpdatedAt(new Date());
				medecineList.setMedecineName(medecineList.getMedecineName());
				medecineService.addMedecine(medecineList);

				modelAndView.addObject("medecine", medecineList);
				modelAndView
						.addObject("wellMessage",
								"Well Done! ");
				modelAndView
						.addObject("addMedecineMessage",
								"You successfully added Medecine");

			}
		}
		return "redirect:/medecine";
	}
	@RequestMapping("/delete")
	public String deleteMedecine(@Valid @ModelAttribute("medecine")MedecineList medecineList,ModelMap model){
		long id = medecineList.getId();
		MedecineList medecineList1 =medecineService.getMedicine(id);
		medecineService.deleteMedecine(medecineList1);
		return "redirect:/medecine";
	}

}

