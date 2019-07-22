package com.Tabiby.Model;

import javax.persistence.*;

/**
 * Created by ibrahimfouad on 8/7/2016.
 */
@Entity
@Table(name = "Doctors", uniqueConstraints = @UniqueConstraint(columnNames = {
        "name", "email","mobile"}))
public class Doctors {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String specialization;
    private String  descreprion;
    private String mobile;
    private String email;


    private long clinicId;

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

    public String getDescreprion() {
        return descreprion;
    }

    public void setDescreprion(String descreprion) {
        this.descreprion = descreprion;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getClinicId() {
        return clinicId;
    }

    public void setClinicId(long clinicId) {
        this.clinicId = clinicId;
    }
}
