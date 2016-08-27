package com.conduit.taphealthngo.doctor;

/**
 * Created by owencortes on 8/28/16.
 */
public interface OnPatientInventEventListener {

    void onViewInvite();
    void onAcceptInvite(DoctorInviteData doctorInviteData,int recordPosition);
}
