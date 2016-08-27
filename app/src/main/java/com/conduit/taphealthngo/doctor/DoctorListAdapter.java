package com.conduit.taphealthngo.doctor;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.conduit.taphealthngo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by owencortes on 8/27/16.
 */
public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.ViewHolder> implements View.OnClickListener {

    public List<DoctorData> doctors;

    public DoctorListAdapter(List<DoctorData> doctors){
        this.doctors = doctors;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_list_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxtDoctorName.setText(doctors.get(position).getName());
        holder.mBtnCallDoctor.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return doctors.size();
    }

    @Override
    public void onClick(View view) {

    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_doctor_fragment_list_item_name)
        TextView mTxtDoctorName;

        @BindView(R.id.btn_doctor_fragment_item_call)
        Button mBtnCallDoctor;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }
}

