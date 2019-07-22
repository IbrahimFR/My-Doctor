package com.Tabiby.Controller;

import com.Tabiby.Model.Clinics;
import com.Tabiby.service.ClinicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements
		AuthenticationSuccessHandler, AuthenticationFailureHandler,
		LogoutSuccessHandler {

	RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	private static final Logger logger = LoggerFactory
			.getLogger(WebSecurityConfig.class);

	@Autowired
	@Qualifier("clinicService")
	private ClinicService userService;

	@Autowired
	private DataSource dataSource;

	PasswordEncoder pe = new BCryptPasswordEncoder();

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	/**
	 * @param dataSource
	 *            the dataSource to set
	 */
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/css/**", "/resources/js/**",
				"/resources/images/**", "/resources/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/logout", "/error","/api/**/**",
						"/pleas_verfiy","/verifyemail/**/**" ,"/about", "/update","/admin/new","admin/add",
						"/api/**/**/**/**/**/**").permitAll().antMatchers("/**/**")
				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
				.anyRequest().authenticated().and().formLogin()
				.loginPage("/login").defaultSuccessUrl("/index")
				.successHandler(this).failureHandler(this)
				.failureUrl("/login?error").permitAll()

				.and().logout().deleteCookies("remove")
				.invalidateHttpSession(true).logoutUrl("/logout")
				// .logoutSuccessHandler(this)

				.logoutSuccessUrl("/logout").permitAll();
		http.sessionManagement().invalidSessionUrl("/login") // session-management@invalid-session-url
				.sessionAuthenticationErrorUrl("/error") // session-management@session-authentication-error-url
				.maximumSessions(3) // session-management/concurrency-control@max-sessions
				.maxSessionsPreventsLogin(true) // session-management/concurrency-control@error-if-maximum-exceeded
				.expiredUrl("/logout"); // session-management/concurrency-control@expired-url
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.jdbcAuthentication()
				.dataSource(dataSource)
				.passwordEncoder(pe)
				.usersByUsernameQuery(
						"select name as principal , password as credentials, true  from Clinics where name=? and active=true")
				.authoritiesByUsernameQuery(
						"select name as principal ,  role as role from Clinics where name=? and active=true")
				.rolePrefix("ROLE_");
		//

		// auth.jdbcAuthentication()emailverification as TRUE
		// .dataSource(dataSource)
		// .passwordEncoder(pe)
		// .usersByUsernameQuery(
		// "select username as principal , password as credentials, emailverification as TRUE  from user where email=?")
		// .authoritiesByUsernameQuery(
		// "select username as principal ,  role as role from user where email=?")
		// .rolePrefix("ROLE_");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {

		auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName(); // get logged in username

		Clinics uu = (Clinics) userService.getClinicByEmail(userName);


		if (!uu.isLocked()) {
			HttpSession session = request.getSession();
			session.setAttribute("C_U",
					userService.getClinicByEmail(userName));
			session.setAttribute("verfiy", true);
		///	System.out.println("-02");
			// set our response to OK status
			response.setStatus(HttpServletResponse.SC_OK);
			session.setAttribute("verfiy", true);
			System.out.println(userName);
			redirectStrategy.sendRedirect(request, response, "/index");

		} else {
	//		System.out.println("-03");

			// set our response to OK status
			response.setStatus(HttpServletResponse.SC_OK);
			// session.setAttribute("verfiy", false);
			System.out.println("Not verfy ");
			redirectStrategy.sendRedirect(request, response, "/pleas_verfiy");
		}
	}

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ex)
			throws IOException, ServletException {
		// response.sendRedirect("/" + request.getContextPath() +
		// "/login?error");


		redirectStrategy.sendRedirect(request, response, "/login?error");

	}

	@Override
	public void onLogoutSuccess(HttpServletRequest arg0,
			HttpServletResponse arg1, Authentication arg2) throws IOException,
			ServletException {


	}
}
