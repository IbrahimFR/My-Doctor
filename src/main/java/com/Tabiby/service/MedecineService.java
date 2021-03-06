package com.Tabiby.service;

import com.Tabiby.Model.Clinics;
import com.Tabiby.Model.MedecineList;

import java.util.List;

/**
 * Created by ibrahimfouad on 9/17/2016.
 */
public interface MedecineService {

    public void addMedecine(MedecineList medecineList);
    public boolean updateMedecine(MedecineList medecineList);
    public boolean deleteMedecine(MedecineList medecineList);
    public int getMedecineCount(long clinics);
    public int getMedecineCount();
    public List<MedecineList> getMedecineClinic(long clinics);
    public List<MedecineList> getAllMedecine();
    public MedecineList getMedicine(long id);
}
