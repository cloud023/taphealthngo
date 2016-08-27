package com.conduit.taphealthngo.patient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conduit.taphealthngo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientMedicalPrescriptionsFragment extends Fragment {

    @BindView(R.id.recycler_medical_prescription_list) RecyclerView mRecyclerMedicalPrescription;
    private PatientMedicalHistoryListAdapter mAdapter;

    public static PatientMedicalPrescriptionsFragment newInstance(){
        return new PatientMedicalPrescriptionsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new PatientMedicalHistoryListAdapter(PatientData.getPatientMedicalPrescriptions());
        
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.patient_medical_prescription,container,false);
        ButterKnife.bind(this,view);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerMedicalPrescription.setLayoutManager(mLayoutManager);
        mRecyclerMedicalPrescription.setItemAnimator(new DefaultItemAnimator());
        mRecyclerMedicalPrescription.setAdapter(mAdapter);

        return view;
    }
}
