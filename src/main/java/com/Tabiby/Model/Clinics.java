package com.Tabiby.Model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.sql.Blob;
import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by zamalek on 8/7/2016.
 */
@Entity
@Table(name = "Clinics", uniqueConstraints = @UniqueConstraint(columnNames = {
        "name", "phone","mobile", "email"}))
public class Clinics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Size(max = 60, min = 0, message = "Not Valid Value in name Field .")
    private String name;

    @Size(max = 300, min = 0, message = "Not Valid Value in specialization Field .")
    private String specialization;
    @Size(max = 5000, min = 0, message = "Not Valid Value in descreption Field .")
    private String descreption;
    @Size(max = 30, min = 0, message = "Not Valid Value in phone Field .")
    private String phone;
    @Size(max = 30, min = 0, message = "Not Valid Value in mobile Field .")
    private String mobile;
	private String title;
    private String fbPage;
    private String twPage;
    private String address;
    private String email;
    private String password;
    private Date createdAt;
    private String role;
    private boolean active;
    private boolean inActive;
    private boolean deleted;
    private boolean locked;
    private boolean emailVerification;
    @Size(max = 50, min = 2, message = "Not Valid Value in emailVerificationToken Field .")
    private String emailVerificationToken;
    private boolean forgetPassword;
    @Size(max = 50, min = 2, message = "Not Valid Value in forgetPasswordToken Field .")
    private String forgetPasswordToken;
	private String price="0";
    private String Lat;
	private String Lang;
	private float rate;
	String satfrom="";
	String satto="";
	String sunfrom="";
	String sunto="";
	String monfrom="";
	String monto="";
	String tufrom="";
	String tuto="";
	String wefrom="";
	String weto="";
	String thfrom="";
	String thto="";
	String frfrom="";
	String frto="";
	String type;

//    @OneToMany(mappedBy="clinic",cascade=CascadeType.ALL)
//    private List<MedecineList> medecineList = new ArrayList<MedecineList>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isInActive() {
		return inActive;
	}

	public void setInActive(boolean inActive) {
		this.inActive = inActive;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public boolean isForgetPassword() {
		return forgetPassword;
	}

	public void setForgetPassword(boolean forgetPassword) {
		this.forgetPassword = forgetPassword;
	}

	public String getForgetPasswordToken() {
		return forgetPasswordToken;
	}

	public void setForgetPasswordToken(String forgetPasswordToken) {
		this.forgetPasswordToken = forgetPasswordToken;
	}

	public String getFbPage() {
		return fbPage;
	}

	public void setFbPage(String fbPage) {
		this.fbPage = fbPage;
	}

	public String getTwPage() {
		return twPage;
	}

	public void setTwPage(String twPage) {
		this.twPage = twPage;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getLat() {
		return Lat;
	}

	public void setLat(String lat) {
		Lat = lat;
	}

	public String getLang() {
		return Lang;
	}

	public void setLang(String lang) {
		Lang = lang;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getSatfrom() {
		return satfrom;
	}

	public void setSatfrom(String satfrom) {
		this.satfrom = satfrom;
	}

	public String getSatto() {
		return satto;
	}

	public void setSatto(String satto) {
		this.satto = satto;
	}

	public String getSunfrom() {
		return sunfrom;
	}

	public void setSunfrom(String sunfrom) {
		this.sunfrom = sunfrom;
	}

	public String getSunto() {
		return sunto;
	}

	public void setSunto(String sunto) {
		this.sunto = sunto;
	}

	public String getMonfrom() {
		return monfrom;
	}

	public void setMonfrom(String monfrom) {
		this.monfrom = monfrom;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getTufrom() {
		return tufrom;
	}

	public void setTufrom(String tufrom) {
		this.tufrom = tufrom;
	}

	public String getTuto() {
		return tuto;
	}

	public void setTuto(String tuto) {
		this.tuto = tuto;
	}

	public String getWefrom() {
		return wefrom;
	}

	public void setWefrom(String wefrom) {
		this.wefrom = wefrom;
	}

	public String getWeto() {
		return weto;
	}

	public void setWeto(String weto) {
		this.weto = weto;
	}

	public String getThfrom() {
		return thfrom;
	}

	public void setThfrom(String thfrom) {
		this.thfrom = thfrom;
	}

	public String getThto() {
		return thto;
	}

	public void setThto(String thto) {
		this.thto = thto;
	}

	public String getFrfrom() {
		return frfrom;
	}

	public void setFrfrom(String frfrom) {
		this.frfrom = frfrom;
	}

	public String getFrto() {
		return frto;
	}

	public void setFrto(String frto) {
		this.frto = frto;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
