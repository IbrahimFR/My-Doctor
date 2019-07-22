package com.Tabiby.Controller;

import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import com.Tabiby.Model.*;
import com.Tabiby.service.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api")
public class TabibyApi {

	@Autowired
	private UsersService userService;

	@Autowired
	private ClinicService clinicService;
	@Autowired
	private ReservationService  reservationService;
	@Autowired
	private RatingService ratingService;
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private  AppointmentService appointmentService;
	@Autowired
	private  ServiceClService serviceClService;
	@Autowired
	private FavouriteService favouriteService;
	@Autowired
	private ClinicAppService  clinicAppService;
	@Autowired
	private NotificationService notificationService;
	@Autowired
	private ClinicPicService clinicPicService;
	
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
	// register user
	@RequestMapping(value = "/usr/{username}/{email}/{mobile}/{pass}",method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String addUser(@PathVariable("username") String userName, @PathVariable("email") String email,@PathVariable("mobile")String mobile , @PathVariable("pass")String pass

	) {
		if(userName!=null&&email!=null&&mobile!= null&&pass!=null) {
			String output="";

			List<Users> usernames = userService.searchUserName(userName);
			List<Users> emails = userService.searchUserEmail(email);
			List<Users> mobiles = userService.searchUserMobile(mobile);
			if(!usernames.isEmpty()){
		//	list.add("UserName");
			return "UserName is already exists";
		    }
			else if(!emails.isEmpty()){
//				list.add("Email");
				return "Email is already exists";


			}
			else if(!mobiles.isEmpty()){
			//	list.add("Mobile");
				return "Mobile is already exists";
			}
			else{
				int token = (int) Math.floor(Math.random() * (90000 - 10000 + 1)) + 10000;
				sendSMS2(mobile,token+"");
				Users u = new Users(); 
				u.setCreatedAt(new Date());
				u.setActive(true);
				u.setLocked(false);
				u.setInActive(true);
				u.setRole("USER");
				u.setDeleted(false);
				u.setEmailVerification(false);
				u.setUsername(userName);
				u.setEmail(email);
				u.setMobile(mobile);
				u.setPassword(pass);
				u.setSsid("0");
				u.setEmailVerificationToken(token+"");
				userService.addUsers(u);
//				list.add("sucess");
				return "success";
			}
		
		}
		else{return null;
		}
		
	}
	// login too
//	@RequestMapping(value = "/lgn/{pass}/{mobile}",method = RequestMethod.GET, headers = "Accept=application/json")
//	public @ResponseBody String login(@PathVariable("pass")String pass , @PathVariable("mobile")String mobile){
//		if (!pass.equals(null)&&!mobile.equals(null)){
//			List<Users>userses = userService.searchUserAccount(pass,mobile);
//			if(!userses.isEmpty()){
//				return "success";
//			}
//			else{
//				return "Some thing went wrong";
//			}
//		}
//		return  null;
//	}
	@RequestMapping(value = "/lgn/{password}{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String Login2(@PathVariable("mobile") String mobile
			,  @PathVariable("password") String pass
	) {

		if (mobile != null &&pass!=null) {
			String output = "";
			List<Users> usernames = userService.searchUserAccount(pass, mobile);

			if (!usernames.isEmpty() ) {
				List<Users>verifiedUser= userService.searchUserVerified(usernames.get(0).getUsername());
				if(!verifiedUser.isEmpty())
					return "success,"+usernames.get(0).getUsername()+","+usernames.get(0).getEmail()+","+usernames.get(0).getMobile()+",true";
				else
					return "verify,"+usernames.get(0).getUsername()+","+usernames.get(0).getEmail()+","+usernames.get(0).getMobile()+",false";
			}

		} else {
			return "You entered wrong number or password!";
		}
		return"You entered wrong number or password!";
	}
	//verify
	@RequestMapping(value = "/verify/{mobile}/{token}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String editUser(@PathVariable("mobile") String mobile
			,  @PathVariable("token") String token
	) {

		if (mobile != null && token != null) {
			String output = "";
			List<Users> usernames = userService.searchUserMobile(mobile);
			List<Users> User = userService.searchUserToken(token, mobile);
			if (!usernames.isEmpty() && User.get(0).getEmailVerificationToken().equals(token)) {
				User.get(0).setEmailVerification(true);
				userService.updateUser(User.get(0));
				return "success";
			}

		} else {
			return "You entered wrong number!";
		}
		return null;
	}
// login
	@RequestMapping(value = "/login/{mobile}/{password}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String Login(@PathVariable("mobile") String mobile
			,  @PathVariable("password") String pass
	) {

		if (mobile != null &&pass!=null) {
			String output = "";
			List<Users> usernames = userService.searchUserAccount(pass, mobile);

			if (!usernames.isEmpty() ) {
				List<Users>verifiedUser= userService.searchUserVerified(usernames.get(0).getUsername());
				if(!verifiedUser.isEmpty())
					return "success,"+usernames.get(0).getUsername()+","+usernames.get(0).getEmail()+","+usernames.get(0).getMobile()+",true";
				else
				  return "verify,"+usernames.get(0).getUsername()+","+usernames.get(0).getEmail()+","+usernames.get(0).getMobile()+",false";
			}

		} else {
			return "You entered wrong number or password!";
		}
		return"You entered wrong number or password!";
	}
// add reserve
	@RequestMapping(value="/rsv/{username}/{clinicname}/{time}/{type}/{appcategory}/{time2}/{timeflag}" , method = RequestMethod.GET, headers = "Accept=application/json",produces = "text/plain")
	 private @ResponseBody String addReservation(@PathVariable("username")String userName ,@PathVariable("clinicname")String clinicName,
												 @PathVariable("time")String time, @PathVariable("type")String type ,
												 @PathVariable("appcategory") String appcategory, @PathVariable("time2")String time2,@PathVariable("timeflag") String timeFlag) throws ParseException{
		if(userName!=null&& clinicName!=null&&time!=null&&type!=null){
//			List<Users>user = userService.searchUserName(userName);
//			List<Clinics>clinic=clinicService.searchClinicName(clinicName);
			//java.util.Date dtt = df.parse(time);
			Reservation reservation = new Reservation();
			long id= Long.parseLong(clinicName);
			List<Clinics>list=clinicService.getClinic(id);
			if(list.size()!=0)
				reservation.setClinicName(list.get(0).getName());
			reservation.setUserName(userName);
			reservation.setTime(time + "," + timeFlag);
			reservation.setStatus(true);
			reservation.setUserStatus("");
			if(type.equals("0"))
				reservation.setReserveType("Normal");
			else if(type.equals("1"))
				reservation.setReserveType("Urgent");
			List <ClinicAppointment> clinicAppointmentList= clinicAppService.getClinicAppointment(list.get(0).getId(),appcategory,time2);
			String string = timeFlag;
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date date = df.parse(string);
			if(clinicAppointmentList.size()!=0) {
				clinicAppointmentList.get(0).setTimeFlag(date);
				clinicAppService.updateClinicApp(clinicAppointmentList.get(0));
				reservation.setClinicAppID(clinicAppointmentList.get(0).getId());
				reservationService.addReservation(reservation);
			}
			return "success";
		}
		else{
			return "error";
		}


	}
	//add reserve service
	// add reserve
	@RequestMapping(value="/rsv/{username}/{clinicname}/{time}/{type}/{appcategory}/{time2}/{timeflag}/{service}" , method = RequestMethod.GET, headers = "Accept=application/json",produces = "text/plain")
	private @ResponseBody String addReservationService(@PathVariable("username")String userName ,@PathVariable("clinicname")String clinicName,
												@PathVariable("time")String time, @PathVariable("type")String type ,
												@PathVariable("appcategory") String appcategory, @PathVariable("time2")String time2,
													   @PathVariable("timeflag") String timeFlag,@PathVariable String service) throws ParseException{
		if(userName!=null&& clinicName!=null&&time!=null&&type!=null){
//			List<Users>user = userService.searchUserName(userName);
//			List<Clinics>clinic=clinicService.searchClinicName(clinicName);
			//java.util.Date dtt = df.parse(time);
			Reservation reservation = new Reservation();
			long id= Long.parseLong(clinicName);
			List<Clinics>list=clinicService.getClinic(id);
			if(list.size()!=0)
				reservation.setClinicName(list.get(0).getName());
			reservation.setUserName(userName);
			reservation.setTime(time + "," + timeFlag);
			reservation.setStatus(true);
			reservation.setUserStatus("");
			reservation.setService(service);
			if(type.equals("0"))
				reservation.setReserveType("Normal");
			else if(type.equals("1"))
				reservation.setReserveType("Urgent");
			List <ClinicAppointment> clinicAppointmentList= clinicAppService.getClinicAppointment(list.get(0).getId(),appcategory,time2);
			String string = timeFlag;
			DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			Date date = df.parse(string);
			if(clinicAppointmentList.size()!=0) {
				clinicAppointmentList.get(0).setTimeFlag(date);
				clinicAppService.updateClinicApp(clinicAppointmentList.get(0));
				reservation.setClinicAppID(clinicAppointmentList.get(0).getId());
				reservationService.addReservation(reservation);
				return "success";
			}

		}
		else{
			return "error";
		}

		return null;
	}
	// add rate
	@RequestMapping(value = "/rate/add/{username}/{clinicname}/{time}/{rate}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String addRate(@PathVariable("username")String userName ,@PathVariable("clinicname")String clinicName,
						   @PathVariable("time")String time ,@PathVariable("rate")String rate) throws ParseException {
		long id= Long.parseLong(clinicName);
		List<Clinics>clinic = clinicService.getClinic(id);
		List<Users> users = userService.searchUserName(userName);
		List<Rating> ratings= ratingService.getUserRate(users.get(0), clinic.get(0));
		if(ratings.size()==0){
		//	java.util.Date dtt = df.parse(time);
			Rating rating = new Rating();
			rating.setClinicId(clinic.get(0));
			rating.setUserId(users.get(0));
			rating.setUpdatedAt(new Date());
			rating.setCreatedAt(new Date());
			rating.setRate(Integer.parseInt(rate));
			ratingService.addRate(rating);
		    float preRate =	clinic.get(0).getRate();
			int count =  ratingService.getRatingCount(clinic.get(0));
			if(count!=0) {
				float sum = preRate / count;
				clinic.get(0).setRate(sum);
				clinicService.updateClinic(clinic.get(0));
			}
			else{
				clinic.get(0).setRate(0);
				clinicService.updateClinic(clinic.get(0));
			}
			return  "success";

		}else{

			ratings.get(0).setClinicId(clinic.get(0));
			ratings.get(0).setUserId(users.get(0));
			ratings.get(0).setUpdatedAt(new Date());
			ratings.get(0).setRate(Integer.parseInt(rate));
			ratingService.updateRate(ratings.get(0));
			float preRate =	clinic.get(0).getRate();
			int count =  ratingService.getRatingCount(clinic.get(0));
			if(count!=0) {
				float sum = (preRate+Float.parseFloat(rate)) / count;
				clinic.get(0).setRate(sum);
				clinicService.updateClinic(clinic.get(0));
			}
			else{
				clinic.get(0).setRate(Integer.parseInt(rate));
				clinicService.updateClinic(clinic.get(0));
			}

			return  "success";
		}



	}
	// add review
	@RequestMapping(value = "/review/add/{username}/{clinicname}/{time}/{review}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	String addReview(@PathVariable("username")String userName ,@PathVariable("clinicname") String clinicName,
						   @PathVariable("time")String time ,@PathVariable("review")String reviewText) throws ParseException {
		List<Users> user = userService.searchUserName(userName);
		List<Clinics> clinic = clinicService.searchClinicName(clinicName);
		List<Review> reviews = reviewService.getUserReview(user.get(0), clinic.get(0));
		if(reviews .isEmpty()){
			java.util.Date dtt = df.parse(time);
		    Review review = new Review();
			review.setClinicId(clinic.get(0));
			review.setUserId(user.get(0));
			review.setCreatedAt(new Date());
			review.setUpdatedAt(new Date());
			review.setReviewText(reviewText);
			reviewService.addReview(review);
			return  "sucess_add";

		}else{
			Review review = new Review();
			review.setClinicId(clinic.get(0));
			review.setUserId(user.get(0));
			review.setUpdatedAt(new Date());
			review.setReviewText(reviewText);
			reviewService.updateReview(review, user.get(0), clinic.get(0));
			return  "sucess_update";
		}



	}
	// get appointment
	@RequestMapping(value = "/getappointment/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Appointment> getUserAppointment(@PathVariable("username")String userName){
		List<Appointment> appointments;
		if(!userName.equals(null)){
		appointments =	appointmentService.getUserAppointments(userName);
			return appointments;
		}
		return  null;
	}
	//notification
	@RequestMapping(value = "/getnotification/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Notification> getUserNotifications(@PathVariable("username")String userName){
		List<Notification> notifications;
		if(!userName.equals(null)){
			notifications=notificationService.getNotification(userName);
			if(notifications.size()!=0){
				for(int i=0 ;i<notifications.size();i++) {
					notifications.get(i).setFlag("false");
					notificationService.updateNotification(notifications.get(0));
				}
				return notifications;
			}

		}
		return  null;
	}
	// get services
	@RequestMapping(value = "/getservice", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Service> getServices(){
		List<Service> services;
			services=	serviceClService.getAllService();
			return services;

	}
	// get clinicApp
	@RequestMapping(value = "/clinicapp", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<ClinicAppointment> getClinicApp(){
		List<ClinicAppointment> clinicAppointments;

		clinicAppointments=clinicAppService.getClinicAppointment();
		return clinicAppointments;


	}
	// search clinic
	@RequestMapping(value = "/getclinics/{address}/{specialization}/{clinicname}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Clinics> getClinics(@PathVariable("address")String address,@PathVariable("specialization")String specialization, @PathVariable("clinicname")String clinciName){
		List<Clinics> clinicses;

		if(!address.equals(null)&&!specialization.equals(null)&&!clinciName.equals(null)){
			clinicses=clinicService.getClinics(address, specialization, clinciName);
			return clinicses;
		}
		return  null;

	}
	@RequestMapping(value = "/getclinics", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Clinics> getAllClinics(){
		List<Clinics> clinicses;

			clinicses=clinicService.getAllActiveClinics();
			return clinicses;


	}
	// cancel appointment
	@RequestMapping(value = "/cancelApp/{username}/{clinicname}/{time}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody String CancelApp(@PathVariable("username")String username,@PathVariable("clinicname")String clinicname, @PathVariable("time")String time) {

		if (!username.equals(null) && !clinicname.equals(null) && !time.equals(null)) {
			long id = Long.parseLong(clinicname);
			List<Clinics> list = clinicService.getClinic(id);
			if (list.size() != 0) {
				List<Appointment> appointments = appointmentService.getCurrentAppointment(username, list.get(0).getName(), time);
				if (!appointments.isEmpty()) {
					appointments.get(0).setCanceled("true");
					appointmentService.updateAppointment(appointments.get(0));
//					List<ClinicAppointment>app = clinicAppService.getClinicAppointment(appointments.get(0).getClinicAppID());
//					if(app.size()!=0){
//						app.get(0).setTimeFlag(null);
//						clinicAppService.updateClinicApp(app.get(0));
//					}
					return "success";
				} else {
					return "error";
				}
			} }
				return null;

		}





	@RequestMapping(value = "/forgerpass/{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody String forgetPass(@PathVariable("mobile")String mobile){

     List<Users> mUser = userService.searchUserMobile(mobile);
		if(mUser.size()!=0){
			int token = (int) Math.floor(Math.random() * (90000 - 10000 + 1)) + 10000;
			mUser.get(0).setForgetPasswordToken(token + "");
			userService.updateUser(mUser.get(0));
			sendSMS(mobile, token + "");
			return "success";
		}
		return "error";

	}
	@RequestMapping(value = "/confirmpass/{mobile}/{token}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody String confirmPass(@PathVariable("mobile")String mobile, @PathVariable("token")String token){

		List<Users> mUser = userService.searchForgetToken(mobile, token);
		if(mUser.size()!=0){
			if(mUser.get(0).getForgetPasswordToken()!=null)
		    mUser.get(0).setForgetPasswordToken("");
			userService.updateUser(mUser.get(0));
			return "success";
		}
		return "error";

	}
	@RequestMapping(value = "/changepass/{password}/{mobile}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody String changePass(@PathVariable("password")String newPass,@PathVariable("mobile")String mobile){
  String mob = mobile;
		List<Users> mUser = userService.searchUserMobile(mobile);
		if(mUser.size()!=0){
			mUser.get(0).setPassword(newPass);
			userService.updateUser(mUser.get(0));
			return "success";
		}
		return "error";

	}
	@RequestMapping(value = "/addfav/{username}/{clinicId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody String addFavourite(@PathVariable("username")String username,@PathVariable("clinicId")String clinicId){
		Long clinicID = Long.parseLong(clinicId);
		List<Favourites> checkFav= favouriteService.getFavourites(username, clinicID);
		if(checkFav.size()!=0){

		}else {
				Favourites favourites = new Favourites();
				favourites.setClinicId(clinicID);
				favourites.setUserName(username);
				favouriteService.addFavourite(favourites);
				return "success";
		}
		return "error";

	}
	@RequestMapping(value = "/deletefav/{username}/{clinicId}", method = RequestMethod.GET, headers = "Accept=application/json")
	 public  @ResponseBody String delete(@PathVariable("username")String username,@PathVariable("clinicId")String clinicId){

		Long clinicID = Long.parseLong(clinicId);
		if(!username.equals(null)&&!clinicId.equals(null)) {

			List<Favourites> favourites = favouriteService.getFavourites(username, clinicID);
			if (favourites.size() != 0) {
				favourites.get(0).setClinicId(clinicID);
				favourites.get(0).setUserName(username);
				favouriteService.deleteFavourte(favourites.get(0));
				return "success";
			}
		}
		return  "error";
	}
	@RequestMapping(value = "/getfav/{username}", method = RequestMethod.GET, headers = "Accept=application/json")
	public  @ResponseBody List<Favourites> getfav(@PathVariable("username")String username){


		if(!username.equals(null)){

			List<Favourites> favourites = favouriteService.getFavourtes(username);
			return favourites;

		}
		return  null;
	}
	void sendSMS(String mobile ,String code){
		try {
			// Construct data
			String data = "";
	            /*
	             * Note the suggested encoding for certain parameters, notably
	             * the username, password and especially the message.  ISO-8859-1
	             * is essentially the character set that we use for message bodies,
	             * with a few exceptions for e.g. Greek characters.  For a full list,
	             * see:  http://developer.bulksms.com/eapi/submission/character-encoding/
	             */
			data += "username=" + URLEncoder.encode("hanyselim", "ISO-8859-1");
			data += "&password=" + URLEncoder.encode("carthage", "ISO-8859-1");
			data += "&message=" + URLEncoder.encode(code +" is your Tabiby Forget Password Code", "ISO-8859-1");
			data += "&want_report=1";
			data += "&msisdn="+mobile;

			// Send data
			// Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
			URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				// Print the response output...
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
		}
	}
	void sendSMS2(String mobile ,String code){
		try {
			// Construct data
			String data = "";
	            /*
	             * Note the suggested encoding for certain parameters, notably
	             * the username, password and especially the message.  ISO-8859-1
	             * is essentially the character set that we use for message bodies,
	             * with a few exceptions for e.g. Greek characters.  For a full list,
	             * see:  http://developer.bulksms.com/eapi/submission/character-encoding/
	             */
			data += "username=" + URLEncoder.encode("hanyselim", "ISO-8859-1");
			data += "&password=" + URLEncoder.encode("carthage", "ISO-8859-1");
			data += "&message=" + URLEncoder.encode(code +" is your Tabiby Account verification Code", "ISO-8859-1");
			data += "&want_report=1";
			data += "&msisdn="+mobile;

			// Send data
			// Please see the FAQ regarding HTTPS (port 443) and HTTP (port 80/5567)
			URL url = new URL("https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");

			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();

			// Get the response
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = rd.readLine()) != null) {
				// Print the response output...
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
		}
	}
	@ResponseBody
	@RequestMapping(value = "/photo/{clinic}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getphoto(@PathVariable("clinic") String clinic) throws IOException, SQLException {
		Reservation reservation = new Reservation();
		long id= Long.parseLong(clinic);
		//List<Clinics>list=clinicService.getClinic(id);
		List<ClinicPic>list1=clinicPicService.getclinicData(id);
		if(list1.size()!=0) {
			Blob blob = list1.get(0).getPhoto();
			long blobLength = blob.length();
			int pos = 1; // position is 1-based1
			int len = 10;
			byte[] bytes = blob.getBytes(pos, len);
			InputStream is = blob.getBinaryStream();
			return IOUtils.toByteArray(is);
		}
		return  null;
	}
}
