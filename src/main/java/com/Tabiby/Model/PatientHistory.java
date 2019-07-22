package com.Tabiby.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created by ibrahimfouad on 9/30/2016.
 */

@Entity
@Table(name ="PatientHistory")
public class PatientHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clinicName;

    private String  userName;
    @Size(max = 45)
    private String visitNum;
    @Size(max = 45)
    private String visitDate;
    @Size(max =1000)
    private String symtops;
    @Size(max = 1500)
    private String diseases;
    @Size(max = 5)
    private String drugs;
    @Size(max = 1500)
    private String assignedMedecine;
    @Size(max = 1500)
    private String comment;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(String visitNum) {
        this.visitNum = visitNum;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getSymtops() {
        return symtops;
    }

    public void setSymtops(String symtops) {
        this.symtops = symtops;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getDrugs() {
        return drugs;
    }

    public void setDrugs(String drugs) {
        this.drugs = drugs;
    }

    public String getAssignedMedecine() {
        return assignedMedecine;
    }

    public void setAssignedMedecine(String assignedMedecine) {
        this.assignedMedecine = assignedMedecine;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
