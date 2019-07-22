package com.Tabiby.service;

import com.Tabiby.Model.ClinicPic;

import java.util.List;

/**
 * Created by ibrahimfouad on 12/3/2016.
 */
public interface ClinicPicService {
    public List<ClinicPic> getclinicData(long id);
    public void updatePic(ClinicPic clinicPic);
    public  void addPic(ClinicPic clinicPic);
}
