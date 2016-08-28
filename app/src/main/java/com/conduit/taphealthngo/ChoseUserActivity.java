package com.conduit.taphealthngo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChoseUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose_user);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_choose_hospital)
    public void onChooseHospital(View view) {
        Intent intent = new Intent(getApplicationContext(),NFCActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btn_choose_doctor)
    public void onChooseDoctor(View view){
        Intent intent = new Intent(getApplicationContext(),DoctorActivity.class);
        startActivity(intent);
        finish();
    }

}
