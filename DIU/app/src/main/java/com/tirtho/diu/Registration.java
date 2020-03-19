package com.tirtho.diu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registration extends AppCompatActivity implements View.OnClickListener {

    Button register, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        register = findViewById(R.id.btn_register);
        login = findViewById(R.id.btn_login);





        register.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_register:
//                startActivity(new Intent(Registration.this, ));
                break;
            case R.id.btn_login:
                startActivity(new Intent(Registration.this, LoginActivity.class));
                break;
        }

    }
}
