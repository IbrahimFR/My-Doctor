package com.Tabiby.Model;

import javax.persistence.*;

import java.util.Date;

/**
 * Created by zamalek on 8/11/2016.
 */
@Entity
@Table(name ="MedecineList")
public class MedecineList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String medecineName;
    private String descreption;
  //  @ManyToOne

    private long clinicId;




    private Date updatedAt;
    private Date createddAt;
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedecineName() {
        return medecineName;
    }

    public void setMedecineName(String medecineName) {
        this.medecineName = medecineName;
    }

    public String getDescreption() {
        return descreption;
    }

    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }

    public long getClinicId() {
        return clinicId;
    }

    public void setClinicId(long clinicId) {
        this.clinicId = clinicId;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreateddAt() {
        return createddAt;
    }

    public void setCreateddAt(Date createddAt) {
        this.createddAt = createddAt;
    }
}
