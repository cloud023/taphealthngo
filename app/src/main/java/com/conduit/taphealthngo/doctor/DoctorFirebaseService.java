package com.conduit.taphealthngo.doctor;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by owencortes on 8/27/16.
 */
public class DoctorFirebaseService {

    private static final String DOCTORS_REFERENCE_KEY = "doctors";

    public static DatabaseReference getAllDoctorsReference(){

        return FirebaseDatabase.getInstance().getReference(DOCTORS_REFERENCE_KEY);
    }

}
