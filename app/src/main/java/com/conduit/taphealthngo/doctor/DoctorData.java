package com.conduit.taphealthngo.doctor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owencortes on 8/27/16.
 */
public class DoctorData {

    private String doctorName;
    private boolean isAvailable;

    public DoctorData(String doctorName, boolean isAvailable){
        this.doctorName = doctorName;
        this.isAvailable = isAvailable;
    }


    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
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
