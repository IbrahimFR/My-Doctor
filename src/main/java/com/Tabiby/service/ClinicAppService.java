package com.Tabiby.service;

import com.Tabiby.Model.ClinicAppointment;

import java.util.List;

/**
 * Created by ibrahimfouad on 10/21/2016.
 */
public interface ClinicAppService {

    public void addClinicApp(ClinicAppointment clinicAppointment);
    public void updateClinicApp(ClinicAppointment clinicAppointment);
    public void deleteClinicApp(ClinicAppointment clinicAppointment);
    public List<ClinicAppointment> getClinicAppointment(long clinicName , String appCategory);
    public List<ClinicAppointment> getClinicAppointment();
    public List<ClinicAppointment> getClinicAppointment(long clinicName , String appCategory, String time);
    public List<ClinicAppointment> getClinicAppointment(long id);
}
