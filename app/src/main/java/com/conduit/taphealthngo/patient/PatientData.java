package com.conduit.taphealthngo.patient;

import com.google.firebase.database.IgnoreExtraProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owencortes on 8/27/16.
 */
@IgnoreExtraProperties
public class PatientData {

    public static final String HARDCODED_PATIENT_ID = "0000001";

    private String name;
    private String age;
    private String birthdate;
    private String gender;
    private String sssNumber;
    private String maritalStatus;
    private String address;
    private String philhealthNumber;
    private String hmoAffiliation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSssNumber() {
        return sssNumber;
    }

    public void setSssNumber(String sssNumber) {
        this.sssNumber = sssNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhilhealthNumber() {
        return philhealthNumber;
    }

    public void setPhilhealthNumber(String philhealthNumber) {
        this.philhealthNumber = philhealthNumber;
    }

    public String getHmoAffiliation() {
        return hmoAffiliation;
    }

    public void setHmoAffiliation(String hmoAffiliation) {
        this.hmoAffiliation = hmoAffiliation;
    }

    public static List<String> getPatientMedicalHistory(){

        List<String> medicalHistory = new ArrayList<>();
        medicalHistory.add("Has asthma and allergic to crabs");
        medicalHistory.add("Recently operated on the heart");
        medicalHistory.add("Diagnose with allergy in the rice");

        return medicalHistory;

    }

    public static List<String> getPatientMedicalPrescriptions(){

        List<String> medicalHistory = new ArrayList<>();
        medicalHistory.add("Please take alaxan 3 times a day");
        medicalHistory.add("Drink 3 bottles of water 8 times a day");
        return medicalHistory;

    }


}
