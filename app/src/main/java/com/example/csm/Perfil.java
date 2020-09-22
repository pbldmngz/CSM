package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfil extends AppCompatActivity implements
        View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Button btnTwo = (Button) findViewById(R.id.notificationsButton4);
        Button btnThree = (Button) findViewById(R.id.actionsButton4);
        Button btnFour = (Button) findViewById(R.id.listButton4);
        // calling onClick() method
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.notificationsButton4:
                Intent intent = new Intent(Perfil.this, Notifications.class
                ); //Notifications class is actually List class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent);
                break;


            case R.id.actionsButton4:
                Intent intent3 = new Intent(Perfil.this, Acciones.class);
                startActivity(intent3);
                break;

            case R.id.listButton4:
                Intent intent4 = new Intent(Perfil.this, List.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }
}

