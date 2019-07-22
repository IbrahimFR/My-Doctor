package com.Tabiby.Dao;

import com.Tabiby.Model.ClinicPic;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.util.List;

/**
 * Created by ibrahimfouad on 12/3/2016.
 */
public interface ClinicPicDao {
   public List<ClinicPic> getclinicData(long id);
    public void updatePic(ClinicPic clinicPic);
    public  void addPic(ClinicPic clinicPic);
}
