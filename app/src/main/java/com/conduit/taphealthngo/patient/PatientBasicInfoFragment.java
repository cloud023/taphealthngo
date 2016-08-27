package com.conduit.taphealthngo.patient;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conduit.taphealthngo.R;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientBasicInfoFragment extends Fragment {


    public static PatientBasicInfoFragment newInstance() {

        PatientBasicInfoFragment fragment = new PatientBasicInfoFragment();

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.patient_basic_info_layout,container,false);


        return view;
    }
}
