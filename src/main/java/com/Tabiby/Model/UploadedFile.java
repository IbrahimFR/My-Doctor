package com.Tabiby.Model;

/**
 * Created by zamalek on 9/27/2016.
 */
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILES_UPLOAD")
public class UploadedFile {
    private long id;
    private String fileName;

    private byte[] data;
    private long patientHistoryId;
    private long userId;
    private long clinicId;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "FILE_NAME")
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Column(name = "FILE_DATA",columnDefinition = "LONGBLOB")
    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public long getPatientHistoryId() {
        return patientHistoryId;
    }

    public void setPatientHistoryId(long patientHistoryId) {
        this.patientHistoryId = patientHistoryId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getClinicId() {
        return clinicId;
    }

    public void setClinicId(long clinicId) {
        this.clinicId = clinicId;
    }
}