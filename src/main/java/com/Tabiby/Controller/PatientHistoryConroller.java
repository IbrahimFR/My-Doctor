package com.Tabiby.Controller;

import com.Tabiby.Model.*;
import com.Tabiby.service.*;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by zamalek on 9/28/2016.
 */
@Controller
@RequestMapping("/patient")
public class PatientHistoryConroller {
    public long userID;
    @Autowired
    private ClinicService clinicService;
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientHistoryService patientHistoryService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private FileUploadService fileUploadService;
    @Autowired
    private  MedecineService medecineService;
    @Autowired
    private NotificationService notificationService;
    
    private JRDataSource jrDatasource;



    @RequestMapping("")
    public String gotoMedecine(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> C_U =  clinicService.searchClinicName(userName);
       List<Appointment>appointments = appointmentService.getClinicAppointment(C_U.get(0));
        List<String> listUsers = new ArrayList<String>();
        for (int ii = 0; ii < appointments .size(); ii++) {
            listUsers.add(ii, appointments .get(ii).getUserName());
        }
        if(listUsers.size()!=0) {
            List<Users> patient = usersService.getUsers(listUsers);
            model.addAttribute("patient", patient);
        }
        return "patient";
    }
    @RequestMapping(value = "/getdata", method = RequestMethod.GET)
    public String getdata(@Valid @ModelAttribute("patient")Users users,@Valid @ModelAttribute("history")Users ndUser,BindingResult result,HttpServletRequest request,
                                 HttpServletResponse response,ModelMap model) throws IOException, ParseException {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> C_U =  clinicService.searchClinicName(userName);
        List<MedecineList>mList = medecineService.getMedecineClinic(C_U.get(0).getId());
        Long id = users.getId();
        if(id==0){
            id=userID;
        }
        List<Users>userses=usersService.getUser(id);
        if(userses!=null) {
            List<PatientHistory> history = patientHistoryService.getVisits(userses.get(0), C_U.get(0));
            List<UploadedFile> files = fileUploadService.getFiles(C_U.get(0).getId(),userses.get(0).getId());

            if(history!=null) {
                model.addAttribute("history", history);
                model.addAttribute("message", id);
                model.addAttribute("userss",userses.get(0));

            }
            if(files!=null){
                model.addAttribute("files",files);
            }
            if(mList!=null){
                model.addAttribute("MedecineList",mList);
            }
        }
        return "history";

    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String sendFollow( @ModelAttribute("patient")Users users,BindingResult result,HttpServletRequest request,
                                 HttpServletResponse response,ModelMap model) throws IOException, ParseException {

        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        String userName = auth.getName();
        List<Clinics> C_U =  clinicService.searchClinicName(userName);
        String user = request.getParameter("user");
        String text = request.getParameter("Text");
        Notification i = new Notification();
        List<Users>userses=usersService.searchUserName(user);
        if(userses.size()!=0 ){
           i.setClinic(C_U.get(0).getName());
           i.setUser(userses.get(0).getUsername());
            i.setDate(new Date());
            i.setFlag("true");
            i.setType("new  Follow");
            i.setText("Your Follow at " + request.getParameter("type"));
            i.setDate(new Date());
           notificationService.addNotification(i);
            Appointment appointment = new Appointment();
            appointment.setClinicName(C_U.get(0).getName());
            appointment.setUserName(userses.get(0).getUsername());
            appointment.setTime(request.getParameter("type"));
            appointment.setUserStatus("");
            appointment.setReserveType("follow");
            appointment.setCanceled("false");
            appointment.setService("");
            appointmentService.addAppiontment(appointment);// add appointment
        }
        return "redirect:/patient";

    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public  String addVisit(HttpServletRequest req,
                            HttpServletResponse res ,@Valid @ModelAttribute("history")PatientHistory patient, @ModelAttribute("MedecineList")MedecineList medecineList,BindingResult result){
        ModelAndView modelAndView =null;
        if(result.hasErrors()){
            modelAndView = new ModelAndView("history");
            return "redirect:/patient/getdata";
        }
        else{
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            String userName = auth.getName();
            String list[] =req.getParameterValues("activitiesdrop");
            String medicines="";
            for (int i=0;i<list.length;i++){
                medicines=medicines+list[i]+",";
            }

            List<Clinics> C_U =  clinicService.searchClinicName(userName);
            PatientHistory patientHistory = new PatientHistory();
            patientHistory.setClinicName(C_U.get(0).getName());
            patientHistory.setComment(patient.getComment());
            patientHistory.setSymtops(patient.getSymtops());
            patientHistory.setVisitNum(patient.getVisitNum());
            patientHistory.setVisitDate(patient.getVisitDate());
            patientHistory.setAssignedMedecine(medicines);
            patientHistory.setUserName(patient.getUserName());
            patientHistoryService.addVisit(patientHistory);
            String usr =patient.getUserName();
            List<Users> user = usersService.searchUserName(usr);
            userID = user.get(0).getId();
            return "redirect:/patient/getdata";
        }
    }
    @RequestMapping(value = { "/visit/delete" }, method = RequestMethod.POST)
    public String deleteVisit(@Valid @ModelAttribute("history")PatientHistory patient ,HttpServletResponse response) throws IOException {
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        long id = patient.getId();
        PatientHistory patientHistory =   patientHistoryService.getVisit(id);
        patientHistoryService.deleteVisit(patientHistory);
        String usr =patient.getUserName();
        List<Users> user = usersService.searchUserName(usr);
        userID = user.get(0).getId();
        return "redirect:/patient/getdata";
    }
    @RequestMapping(value = "/doUpload",headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,@Valid @ModelAttribute("history")Users users,
                                   @RequestParam("fileUpload") CommonsMultipartFile[] fileUpload,ModelMap model) throws Exception {


        long nn = fileUpload[0].getSize();
        if (fileUpload[0].getSize() != 0 && fileUpload.length > 0) {
            Authentication auth = SecurityContextHolder.getContext()
                    .getAuthentication();
            String userName = auth.getName();
            List<Clinics> C_U =  clinicService.searchClinicName(userName);
            long id = users.getId();
            for (CommonsMultipartFile aFile : fileUpload){
                UploadedFile uploadFile = new UploadedFile();
                uploadFile.setFileName(aFile.getOriginalFilename());
                uploadFile.setData(aFile.getBytes());
                uploadFile.setClinicId(C_U.get(0).getId());
                uploadFile.setUserId(id);
                fileUploadService.save(uploadFile);
            }
        }
        userID = users.getId();
        return "redirect:/patient/getdata";
    }
    @RequestMapping(value = { "/download" }, method = RequestMethod.POST)
    public String downloadDocument(@Valid @ModelAttribute("history")UploadedFile file ,HttpServletResponse response) throws IOException {
        long fileId = file.getId();
        UploadedFile document = fileUploadService.getFile(fileId);
       // response.setContentType(document.get);
        response.setContentLength(document.getData().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getFileName() + "\"");

        FileCopyUtils.copy(document.getData(), response.getOutputStream());
        userID = file.getUserId();
        return "redirect:/patient/getdata";
    }
    @RequestMapping(value = { "/delete" }, method = RequestMethod.POST)
        public String deleteDocument(@Valid @ModelAttribute("history")UploadedFile file ,HttpServletResponse response) throws IOException {
        long fileId = file.getId();
        UploadedFile document = fileUploadService.getFile(fileId);
        fileUploadService.delete(document);
        userID = file.getUserId();
        return "redirect:/patient/getdata";
    }

    @RequestMapping(value = "/print", method = RequestMethod.POST)
	public String printWelcome(@Valid @ModelAttribute("history")PatientHistory patient ,ModelMap model) throws JRException {
        long id = patient.getId();
       List<PatientHistory>list = patientHistoryService.getVisits(id);
        setData(list);
		model.addAttribute("datasource", jrDatasource);
		model.addAttribute("format", "pdf");
		return "multiViewReport";
	}
    public void setData (List<PatientHistory>patientHistories)throws JRException {
        StudentDataSource dsStudent =  new StudentDataSource(patientHistories);
        jrDatasource = dsStudent.create(null);
    }


}
