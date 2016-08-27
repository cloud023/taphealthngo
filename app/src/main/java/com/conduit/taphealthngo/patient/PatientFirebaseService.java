package com.conduit.taphealthngo.patient;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientFirebaseService {

    private static final String PATIENT_INFO_REFERENCE_KEY = "patients";
    private static final String PATIENT_MEDICAL_HISTORY_REFERENCE_KEY = "medical_history";
    private static final String PATIENT_PRESCRIPTIONS_REFERENCE_KEY = "prescriptions";
    private static final String PATIENT_DOCTOR_INVITES_REFERENCE_KEY = "doctor_invites";


    public static DatabaseReference getPatientInfoReference(String patientId){

        return FirebaseDatabase.getInstance().getReference(PATIENT_INFO_REFERENCE_KEY).child(patientId);
    }

    public static DatabaseReference getPatientMedicalHistoryReference(String patientId){

        return FirebaseDatabase.getInstance().getReference(PATIENT_INFO_REFERENCE_KEY)
                .child(patientId).child(PATIENT_MEDICAL_HISTORY_REFERENCE_KEY);
    }

    public static DatabaseReference getPatientPrescriptionsRefererence(String patientId){

        return FirebaseDatabase.getInstance().getReference(PATIENT_INFO_REFERENCE_KEY)
                .child(patientId).child(PATIENT_PRESCRIPTIONS_REFERENCE_KEY);
    }

    public static DatabaseReference getDoctorInvitesReference(String patientId){
        return FirebaseDatabase.getInstance().getReference(PATIENT_DOCTOR_INVITES_REFERENCE_KEY);
    }
}
