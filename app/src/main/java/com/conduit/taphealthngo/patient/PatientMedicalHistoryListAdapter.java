package com.conduit.taphealthngo.patient;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.conduit.taphealthngo.R;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by owencortes on 8/27/16.
 */
public class PatientMedicalHistoryListAdapter extends RecyclerView.Adapter<PatientMedicalHistoryListAdapter.ViewHolder>{

    public List<String> medicalHistory;
    public static final String MEDICAL_HISTORY_TYPE = "history";
    public static final String MEDICAL_PRESCRIPTION_TYPE = "prescription";
    String medicalType = "";

    public PatientMedicalHistoryListAdapter(List<String> medicalHistory,String medicalType){
        this.medicalHistory = medicalHistory;
        this.medicalType = medicalType;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.patient_medical_history_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtMedicalHistoryDesc.setText(medicalHistory.get(position));
        
        if(medicalType.equals(MEDICAL_HISTORY_TYPE)){
            holder.imgMedIcon.setImageResource(R.drawable.report);
        } else{
            holder.imgMedIcon.setImageResource(R.drawable.pills);
        }

    }

    @Override
    public int getItemCount() {
        return medicalHistory.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_medical_history_list_item_desc)
        TextView txtMedicalHistoryDesc;

        @BindView(R.id.img_med_icon)
        ImageView imgMedIcon;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
