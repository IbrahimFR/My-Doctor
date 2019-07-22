package com.Tabiby.Dao;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.PatientHistory;
import com.Tabiby.Model.Users;

import java.util.List;

/**
 * Created by zamalek on 9/30/2016.
 */
public interface  PatientHistoryDao {
    public void addVisit(PatientHistory patientHistory);
    public List<PatientHistory> getVisits(Users users , Clinics clinics);
    public List<PatientHistory> getVisits(long id);
    public PatientHistory getVisit(long id);
    public void deleteVisit(PatientHistory patientHistory);


}
