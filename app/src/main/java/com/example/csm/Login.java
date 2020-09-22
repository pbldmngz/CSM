package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button loginbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginbutton=(Button) findViewById(R.id.btnLogin);
        loginbutton.setOnClickListener(this);

    }
    public void OpenActivity2(){
        Intent intent = new Intent(this,Perfil.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        OpenActivity2();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
