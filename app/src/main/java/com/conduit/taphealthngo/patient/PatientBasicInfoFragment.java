package com.conduit.taphealthngo.patient;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conduit.taphealthngo.R;
import com.conduit.taphealthngo.doctor.DoctorFirebaseService;
import com.conduit.taphealthngo.doctor.DoctorInviteFragment;
import com.conduit.taphealthngo.doctor.DoctorInviteData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientBasicInfoFragment extends Fragment implements ValueEventListener {

    @BindView(R.id.txt_patient_address)
    TextView mTxtPatientAddress;

    @BindView(R.id.txt_patient_birthdate)
    TextView mTxtPatientBirthDate;

    @BindView(R.id.txt_patient_hmo_affiliation)
    TextView mTxtPatientHMOAffiliation;

    @BindView(R.id.txt_patient_sss_number)
    TextView mTxtPatientSSSNumbr;

    @BindView(R.id.txt_patient_age)
    TextView mTxtPatientAge;

    @BindView(R.id.txt_patient_gender)
    TextView mTxtPatientGender;

    @BindView(R.id.txt_patient_name)
    TextView mTxtPatientName;

    @BindView(R.id.txt_patient_invite_status)
    TextView mTxtPatientInviteStatus;

    private ProgressDialog mProgressDialog;

    public static PatientBasicInfoFragment newInstance() {

        PatientBasicInfoFragment fragment = new PatientBasicInfoFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.patient_basic_info_layout, container, false);
        ButterKnife.bind(this, view);

        mProgressDialog = ProgressDialog.show(getContext(), "Patient Information", "Getting Patient Info please wait...",
                true,
                true);

        PatientFirebaseService.getPatientInfoReference(PatientData.HARDCODED_PATIENT_ID).addValueEventListener(this);

        DoctorFirebaseService.getAllPatientInvitesReference().addValueEventListener(patientInviteStatusListener);
        return view;
    }

    private ValueEventListener patientInviteStatusListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {

            for (DataSnapshot invite : dataSnapshot.getChildren()) {

                DoctorInviteData doctorInviteData = invite.getValue(DoctorInviteData.class);
                if (doctorInviteData.getPatientId().equals(PatientData.HARDCODED_PATIENT_ID)) {

                    if (doctorInviteData.getStatus().equals(DoctorInviteData.INVITE_STATUS_ACCCEPTED)) {
                        mTxtPatientInviteStatus.setText("Care of " + doctorInviteData.getDoctorName());
                        mTxtPatientInviteStatus.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.inviteStatusAccepted));
                        mTxtPatientInviteStatus.setVisibility(View.VISIBLE);
                    } else if (doctorInviteData.getStatus().equals(DoctorInviteData.INVITE_STATUS_PENDING)) {
                        mTxtPatientInviteStatus.setText("Pending Request for " + doctorInviteData.getDoctorName());
                        mTxtPatientInviteStatus.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.inviteStatusPending));
                        mTxtPatientInviteStatus.setVisibility(View.VISIBLE);
                    }
                }
            }

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    @OnClick(R.id.btn_patient_call_doctor)
    public void showDoctorListFragment(View view) {
        DoctorInviteFragment doctorInviteFragment = new DoctorInviteFragment();
        doctorInviteFragment.show(getActivity().getSupportFragmentManager(), "doctor_list_frag");
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        PatientData patientData = dataSnapshot.getValue(PatientData.class);
        if (patientData != null) {
            mTxtPatientAddress.setText(patientData.getAddress());
            mTxtPatientAge.setText(String.valueOf(patientData.getAge()));
            mTxtPatientBirthDate.setText(patientData.getBirthdate());
            mTxtPatientGender.setText(patientData.getGender());
            mTxtPatientHMOAffiliation.setText(patientData.getHmoAffiliation());
            mTxtPatientName.setText(patientData.getName());
            mTxtPatientSSSNumbr.setText(patientData.getSssNumber());
        }

        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
