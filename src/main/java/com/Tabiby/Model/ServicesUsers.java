package com.Tabiby.Model;

import javax.persistence.*;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
@Entity
@Table(name = "UserServices")
public class ServicesUsers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="serviceId",nullable=false)
    private Service serviceId;
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="userId",nullable=false)
    private Users  userId;
    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="clinicId",nullable=false)
    private Clinics clinicId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Service getServiceId() {
        return serviceId;
    }

    public void setServiceId(Service serviceId) {
        this.serviceId = serviceId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Clinics getClinicId() {
        return clinicId;
    }

    public void setClinicId(Clinics clinicId) {
        this.clinicId = clinicId;
    }
}
