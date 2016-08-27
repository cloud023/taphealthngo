package com.conduit.taphealthngo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.conduit.taphealthngo.doctor.DoctorFirebaseService;
import com.conduit.taphealthngo.doctor.DoctorInviteData;
import com.conduit.taphealthngo.doctor.DoctorInvitesRecyclerAdapter;
import com.conduit.taphealthngo.doctor.OnPatientInventEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoctorActivity extends AppCompatActivity implements ValueEventListener,
        OnPatientInventEventListener{


    @BindView(R.id.recycler_doctor_activity_patient_invites_list)
    RecyclerView mRecyclerMedicalHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        ButterKnife.bind(this);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerMedicalHistory.setLayoutManager(mLayoutManager);
        mRecyclerMedicalHistory.setItemAnimator(new DefaultItemAnimator());

        DoctorFirebaseService.getAllPatientInvitesReference().addValueEventListener(this);

    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        List<DoctorInviteData> invites = new ArrayList<>();

        for(DataSnapshot invite : dataSnapshot.getChildren()){
            DoctorInviteData doctorInviteData = invite.getValue(DoctorInviteData.class);
            doctorInviteData.setFirebaseKey(invite.getKey());
            doctorInviteData.onPatientInventEventListener = this;
            invites.add(doctorInviteData);
        }

        DoctorInvitesRecyclerAdapter doctorInvitesRecyclerAdapter = new DoctorInvitesRecyclerAdapter(invites);
        mRecyclerMedicalHistory.setAdapter(doctorInvitesRecyclerAdapter);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }

    @Override
    public void onViewInvite() {
        Intent intentViewPatient = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentViewPatient);
    }

    @Override
    public void onAcceptInvite(DoctorInviteData doctorInviteData,int recordPosition) {

        final ProgressDialog progressDialog = ProgressDialog.show(DoctorActivity.this,
                "Accept Invite","Accepting invite please wait...");

        DoctorFirebaseService.getPatientInviteStatusReference(doctorInviteData.getFirebaseKey())
                .setValue("accepted", new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                        if(progressDialog != null && progressDialog.isShowing()){
                            progressDialog.dismiss();
                        }
                    }
                });
    }
}
