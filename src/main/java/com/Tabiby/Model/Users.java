package com.Tabiby.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ibrahimfouad on 8/7/2016.
 */
@Entity
@Table(name = "Users", uniqueConstraints = @UniqueConstraint(columnNames = {
        "email", "username","mobile"}))
public class Users {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Size(max = 50, min = 2, message = "Not Valid Value in username Field .")
        private String username;
        @Size(max = 50, min = 2, message = "Not Valid Value in email Field .")
        private String email;
        @Size(max = 30, min = 5, message = "Not Valid Value in mobile Field .")
        private String mobile;
        @Size(max =150,  min = 2, message = "Not Valid Value in address Field .")
        private String address;
        @Size(max = 60, min = 2, message = "Not Valid Value in password Field .")
        private String password;
        private Date createdAt;
        private String role;
        @Size(max = 20)
        private String ssid;
        private boolean active;
        private boolean inActive;
        private boolean deleted;
        private boolean locked;
        private boolean emailVerification;
         private String emailVerificationToken;
        private boolean forgetPassword;
               private String forgetPasswordToken;
        

        
        

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id= id;
        }

        public String getUsername() {
                return username;
        }

        public void setUsername(String username) {
                this.username = username;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getMobile() {
                return mobile;
        }

        public void setMobile(String mobile) {
                this.mobile = mobile;
        }

        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
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

        public String getSsid() {
                return ssid;
        }

        public void setSsid(String ssid) {
                this.ssid = ssid;
        }


        
}
