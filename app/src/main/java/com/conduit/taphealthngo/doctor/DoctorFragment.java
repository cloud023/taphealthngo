package com.conduit.taphealthngo.doctor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.conduit.taphealthngo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jayson duran on 8/27/16.
 */
public class DoctorFragment extends DialogFragment{

    @BindView(R.id.lst_doctor_fragment_list)
    RecyclerView mLstDoctors;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.doctor_list_fragment,container,false);
        ButterKnife.bind(this,view);

        return view;
    }
}
