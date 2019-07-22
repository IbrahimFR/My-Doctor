package com.Tabiby.Controller;

import com.Tabiby.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

//import com.algoritmiCloud.service.ApplicationMailer;

@Controller
@Scope("session")
public class DashboardController {

    BCryptPasswordEncoder passwordEncoder;

    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    HttpServletRequest request = null;

    @Autowired
    private ClinicService userService;

    // @Autowired
    // ApplicationMailer mailService ;

    @Autowired(required = true)
    @Qualifier(value = "clinicService")
     public void setUserService(ClinicService userService) {
        this.userService = userService;
    }

    @InitBinder
    public void intitbinder(WebDataBinder binder) {
        binder.setDisallowedFields(new String[]{"emailVerification",
                "createdAt", "role", "active", "inActive", "deleted", "locked"});
    }





}
