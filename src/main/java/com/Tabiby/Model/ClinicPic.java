package com.Tabiby.Model;

import javax.persistence.*;
import java.sql.Blob;

/**
 * Created by ibrahimfouad on 12/3/2016.
 */
@Entity
@Table(name = "ClinicPic")
public class ClinicPic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="content")
    @Lob
    private Blob photo;

    long clinicId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public long getClinicId() {
        return clinicId;
    }

    public void setClinicId(long clinicId) {
        this.clinicId = clinicId;
    }
}
