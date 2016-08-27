package com.conduit.taphealthngo.doctor;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owencortes on 8/27/16.
 */
@IgnoreExtraProperties
public class DoctorData {

    private String name;
    private boolean isAvailable;


    public DoctorData(){

    }

    public DoctorData(String name, boolean isAvailable){
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public static List<DoctorData> getDoctors(){

        List<DoctorData> doctors = new ArrayList<>();
        doctors.add(new DoctorData("Dr. Jayson Duran",true));
        doctors.add(new DoctorData("Dr. Juan Dela Cruz",true));
        doctors.add(new DoctorData("Dr. Jessa Duran",true));
        doctors.add(new DoctorData("Dr. Jaysel Duran",false));
        return doctors;
    }
}
