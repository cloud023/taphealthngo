package com.conduit.taphealthngo.doctor;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.conduit.taphealthngo.R;
import com.conduit.taphealthngo.patient.PatientData;
import com.conduit.taphealthngo.patient.PatientFirebaseService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayson duran on 8/27/16.
 */
public class DoctorInviteFragment extends DialogFragment implements ValueEventListener,OnDoctorSelectedListener {

    @BindView(R.id.lst_doctor_fragment_list)
    RecyclerView mLstDoctors;

    DoctorListAdapter doctorListAdapter;

    private ProgressDialog mProgressDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProgressDialog = ProgressDialog.show(getContext(),"Doctors","Getting available doctors please wait...", true, true);

        DoctorFirebaseService.getAllDoctorsReference().addValueEventListener(this);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doctor_list_fragment,container,false);
        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLstDoctors.setLayoutManager(mLayoutManager);
        mLstDoctors.setItemAnimator(new DefaultItemAnimator());

        getDialog().setTitle("Doctors Available");

        return view;
    }


    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<DoctorData> doctors = new ArrayList<>();

        for(DataSnapshot doctor : dataSnapshot.getChildren()){
            DoctorData doctorData = doctor.getValue(DoctorData.class);
            doctorData.setDoctorId(doctor.getKey());
            doctorData.onDoctorSelectedListener = this;
            doctors.add(doctorData);
        }

        doctorListAdapter = new DoctorListAdapter(doctors);
        mLstDoctors.setAdapter(doctorListAdapter);

        if(mProgressDialog != null && mProgressDialog.isShowing()){
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    public void onSelect(final DoctorData doctorData) {
        new AlertDialog.Builder(getContext()).setTitle("Confirm Invite")
                .setMessage("Are you sure to invite this doctor?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        final ProgressDialog progressDialog = ProgressDialog.show(getContext(),"Sending Invite","Sending invite to selected doctor please wait...");
                        DoctorInviteData doctorInviteData = new DoctorInviteData();
                        doctorInviteData.setDoctorId(doctorData.getDoctorId());
                        doctorInviteData.setInviteType("msg");
                        doctorInviteData.setMessage("Invitation from patient");
                        doctorInviteData.setDoctorName(doctorData.getName());
                        doctorInviteData.setPatientId(PatientData.HARDCODED_PATIENT_ID);
                        doctorInviteData.setStatus(DoctorInviteData.INVITE_STATUS_PENDING);
                        doctorInviteData.setPatientName("Jayson Duran");

                        PatientFirebaseService.getDoctorInvitesReference(PatientData.HARDCODED_PATIENT_ID)
                                .push()
                                .setValue(doctorInviteData, new DatabaseReference.CompletionListener() {
                                    @Override
                                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                        if(progressDialog != null && progressDialog.isShowing()){
                                            progressDialog.dismiss();
                                        }
                                        dismiss();
                                    }
                                });

                    }
                }).setNegativeButton("NO",null)
                .show();
    }
}
