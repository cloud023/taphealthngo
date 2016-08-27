package com.conduit.taphealthngo.doctor;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.conduit.taphealthngo.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayson duran on 8/27/16.
 */
public class DoctorFragment extends DialogFragment implements ValueEventListener {

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

        return view;
    }

    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<DoctorData> doctors = new ArrayList<>();

        for(DataSnapshot doctor : dataSnapshot.getChildren()){
            doctors.add(doctor.getValue(DoctorData.class));
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
}
