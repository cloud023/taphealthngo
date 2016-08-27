package com.conduit.taphealthngo.patient;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientMedicalHistoryListAdapter extends RecyclerView.Adapter<PatientMedicalHistoryListAdapter.ViewHolder>{

    public List<String> medicalHistory;

    public PatientMedicalHistoryListAdapter(List<String> medicalHistory){
        this.medicalHistory = medicalHistory;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return medicalHistory.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

}
