package com.Tabiby.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

@Controller
@RequestMapping({ "/" })
public class Inti {

	private static final Logger logger = LoggerFactory
			.getLogger(WebSecurityConfig.class);

	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	private class SMTPAuthenticator extends Authenticator {
		public PasswordAuthentication getPasswordAuthetntication() {
			return new PasswordAuthentication("ahmed98772372@gmail.com",
					"mmmsss123");
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request,
			HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		System.out.println("IN log Out mapping ");
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			System.out
					.println("IN log Out mapping and not null th security part ");
		}

		try {
			redirectStrategy.sendRedirect(request, response, "/login?logout");
		} catch (IOException e) {
			System.out.println(e);
		}

		return "/login?logout";

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView testMethod() {
		ModelAndView modelAndView = new ModelAndView("home");
		logger.info("INTO HOME ____________");
		System.out.println("HIOOOOOOOOOOOME");
		modelAndView.addObject("message", "Hello World ");
		return modelAndView;
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public ModelAndView ErrorMethod() {
		ModelAndView modelAndView = new ModelAndView("error");
		System.out.println("Error .... ");
		modelAndView.addObject("message", "Error -------- ");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView LoginPageGet() {

		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("message", "In Login Page Mapping .");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView LoginPagePost() {
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("message", "In Login Page Mapping .");
		return modelAndView;
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView TestMail() {

		final String d_email = "algoritmicloud@gmail.com";
		final String d_password = "algoritmicloud123456";
		String d_host = "smtp.gmail.com", d_port = "465", m_to = "ibrahimrashwan@mufix.org", m_subject = "Email Verification", // m_to
																														// =
																														// "MOHAMMED.HAMID131232@ci.menofia.edu.eg",
																														// m_subject
																														// =
																													// "Testing koko",
		m_text = "<h1>Kotkot</h1>Hey, this is the testing email.8768768768768768ffcgsfds 2222222222222222 kokokok";

		Properties props = new Properties();
		props.put("mail.smtp.user", d_email);
		props.put("mail.smtp.host", d_host);
		props.put("mail.smtp.port", d_port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		// props.put("mail.smtp.debug", "true");
		props.put("mail.smtp.socketFactory.port", d_port);
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();

		try {
			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);
			// session.setDebug(true);

			MimeMessage msg = new MimeMessage(session);
			msg.setText(m_text, "UTF-8", "html");
			// msg.setText(m_text);
			msg.setSubject(m_subject);
			msg.setFrom(new InternetAddress(d_email));
			msg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(m_to));
			Transport.send(msg);
		} catch (Exception mex) {
			mex.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView("AAA");
		modelAndView.addObject("message", "In Mail Page Mapping .");
		return modelAndView;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView testMethohgd() {
		ModelAndView modelAndView = new ModelAndView("clinics");
		modelAndView.addObject("message",
				"signup signup signup Hello World MMMMMMMM");
		return modelAndView;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView LoginPageGittt() {
	// ModelAndView modelAndView = new ModelAndView("AAA");
	// modelAndView.addObject("message", "Hello World Sigin");
	// return modelAndView;
	// }

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public ModelAndView login(@RequestParam(value = "error", required =
	// false) String error,
	// @RequestParam(value = "logout", required = false) String logout) {
	//
	// ModelAndView model = new ModelAndView();
	// if (error != null) {
	// model.addObject("error", "Invalid username and password!");
	// }
	//
	// if (logout != null) {
	// model.addObject("msg", "You've been logged out successfully.");
	// }
	// model.setViewName("login");
	//
	// return model;
	//
	// }

}
