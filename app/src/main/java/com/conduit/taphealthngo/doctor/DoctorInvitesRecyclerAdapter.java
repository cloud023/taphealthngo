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
 * Created by owencortes on 8/28/16.
 */
public class DoctorInvitesRecyclerAdapter extends RecyclerView.Adapter<DoctorInvitesRecyclerAdapter.ViewHolder>{

    List<DoctorInviteData> patientInvites;

    public DoctorInvitesRecyclerAdapter(List<DoctorInviteData> patientInvites){
        this.patientInvites = patientInvites;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doctor_invites_list_item,parent,false);

        DoctorInvitesRecyclerAdapter.ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.patientName.setText(patientInvites.get(position).getPatientName());


        if(patientInvites.get(position).getStatus().equals(DoctorInviteData.INVITE_STATUS_PENDING)){
            holder.btnAcceptInvite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    patientInvites.get(position).onPatientInventEventListener.onAcceptInvite(patientInvites.get(position)
                            ,position);
                }
            });
            holder.btnAcceptInvite.setText("Accept");
        } else if (patientInvites.get(position).getStatus().equals(DoctorInviteData.INVITE_STATUS_ACCCEPTED)) {
            holder.btnAcceptInvite.setText("Accepted");
        }

        holder.btnViewInvite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                patientInvites.get(position).onPatientInventEventListener.onViewInvite();
            }
        });

    }

    @Override
    public int getItemCount() {
        return patientInvites.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.txt_doctor_invites_patient_name)
        TextView patientName;

        @BindView(R.id.txt_doctor_invites_patient_msg)
        TextView patientMsg;

        @BindView(R.id.btn_patient_invite_view)
        Button btnViewInvite;

        @BindView(R.id.btn_patient_invites_accept)
        Button btnAcceptInvite;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }

    }

}
