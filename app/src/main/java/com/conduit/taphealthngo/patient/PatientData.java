package com.conduit.taphealthngo.patient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientData {

    private String name;
    private int age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
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

    public List<String> getPatientMedicalHistory(){

        List<String> medicalHistory = new ArrayList<>();
        medicalHistory.add("Has asthma and allergic to crabs");
        medicalHistory.add("Recently operated on the heart");
        medicalHistory.add("Diagnose with allergy in the rice");

        return medicalHistory;

    }


}
