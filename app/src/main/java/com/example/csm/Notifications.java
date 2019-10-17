package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Notifications extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Button btnOne = (Button) findViewById(R.id.listButton);
        Button btnThree = (Button) findViewById(R.id.actionsButton);
        Button btnFour = (Button) findViewById(R.id.profileButton);
        btnOne.setOnClickListener(this); // calling onClick() method
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.listButton:
                Intent intent = new Intent(Notifications.this, List.class
                ); //Notifications class is actually List class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent);
                break;


            case R.id.actionsButton:
                Intent intent3 = new Intent(Notifications.this, Acciones.class);
                startActivity(intent3);
                break;

            case R.id.profileButton:
                Intent intent4 = new Intent(Notifications.this, Perfil.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }
}
