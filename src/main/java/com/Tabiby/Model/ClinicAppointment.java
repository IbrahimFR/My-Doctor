package com.Tabiby.Model;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by zamalek on 10/21/2016.
 */
@Entity
@Table(name = "ClinicAppointment")
public class ClinicAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    long clinicName;
    String appCategory;
    String Category;
    String time;
    Date updatedAt;
    Date createdAt;
    Date timeFlag;

    public long getClinicName() {
        return clinicName;
    }

    public void setClinicName(long clinicName) {
        this.clinicName = clinicName;
    }
    public String getAppCategory() {
        return appCategory;
    }

    public void setAppCategory(String appCategory) {
        this.appCategory = appCategory;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getTimeFlag() {
        return timeFlag;
    }

    public void setTimeFlag(Date timeFlag) {
        this.timeFlag = timeFlag;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}
