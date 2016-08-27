package com.conduit.taphealthngo.patient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conduit.taphealthngo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientMedicalHistoryFragment extends Fragment implements ValueEventListener {

    @BindView(R.id.recycler_medical_history_list) RecyclerView mRecyclerMedicalHistory;

    private PatientMedicalHistoryListAdapter mAdapter;
    public static PatientMedicalHistoryFragment newInstance(){
        return new PatientMedicalHistoryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PatientFirebaseService.getPatientMedicalHistoryReference(PatientData.HARDCODED_PATIENT_ID).addValueEventListener(this);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.patient_medical_history,container,false);
        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerMedicalHistory.setLayoutManager(mLayoutManager);
        mRecyclerMedicalHistory.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        List<String> histories = new ArrayList<>();
        for(DataSnapshot medicalHistory : dataSnapshot.getChildren()){
            if(medicalHistory != null){
                String medicalHistoryDesc = medicalHistory.child("description").getValue().toString();
                histories.add(medicalHistoryDesc);
            }
        }

        mAdapter = new PatientMedicalHistoryListAdapter(histories);
        mRecyclerMedicalHistory.setAdapter(mAdapter);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

    }
}
