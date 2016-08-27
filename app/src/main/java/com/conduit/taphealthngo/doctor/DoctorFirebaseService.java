package com.conduit.taphealthngo.doctor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by owencortes on 8/27/16.
 */
public class DoctorFirebaseService {

    private static final String DOCTORS_REFERENCE_KEY = "doctors";
    private static final String DOCTORS_INVITES_REFERENCE_KEY = "doctor_invites";
    private static final String DOCTORS_INVITES_STATUS_REFERENCE_KEY = "status";

    public static DatabaseReference getAllDoctorsReference(){

        return FirebaseDatabase.getInstance().getReference(DOCTORS_REFERENCE_KEY);
    }

    public static DatabaseReference getAllPatientInvitesReference(){
        return FirebaseDatabase.getInstance().getReference(DOCTORS_INVITES_REFERENCE_KEY);
    }

    public static DatabaseReference getPatientInviteStatusReference(String firebaseKey){
        return FirebaseDatabase.getInstance().getReference(DOCTORS_INVITES_REFERENCE_KEY)
                .child(firebaseKey).child(DOCTORS_INVITES_STATUS_REFERENCE_KEY);
    }

}
