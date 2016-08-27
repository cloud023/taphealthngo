package com.conduit.taphealthngo.doctor;

/**
 * Created by owencortes on 8/27/16.
 */
public class DoctorInvitesMessageEvent {

    public DoctorData mDoctorData;

    public DoctorInvitesMessageEvent(DoctorData doctorData){
        this.mDoctorData = doctorData;
    }

}
