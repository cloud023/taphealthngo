package com.conduit.taphealthngo.doctor;

import com.google.firebase.database.Exclude;

/**
 * Created by owencortes on 8/28/16.
 */
public class DoctorInviteData {

    @Exclude
    public static final String INVITE_STATUS_PENDING = "pending";

    @Exclude
    public static final String INVITE_STATUS_ACCCEPTED = "accepted";

    private String doctorId;
    private String inviteType;
    private String message;

    private String patientId;

    private String firebaseKey;

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirebaseKey() {
        return firebaseKey;
    }

    public void setFirebaseKey(String firebaseKey) {
        this.firebaseKey = firebaseKey;
    }

    @Exclude
    public OnPatientInventEventListener onPatientInventEventListener;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    private String patientName;

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getInviteType() {
        return inviteType;
    }

    public void setInviteType(String inviteType) {
        this.inviteType = inviteType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
