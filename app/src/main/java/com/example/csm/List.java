package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class List extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        Button btnTwo = (Button) findViewById(R.id.notificationsButton);
        Button btnThree = (Button) findViewById(R.id.actionsButton);
        Button btnFour = (Button) findViewById(R.id.profileButton);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.notificationsButton:
                Intent intent2 = new Intent(this, Notifications.class); //List class is actually Notifications class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent2);
                break;

            case R.id.actionsButton:
                Intent intent3 = new Intent(this, Acciones.class);
                startActivity(intent3);
                break;

            case R.id.profileButton:
                Intent intent4 = new Intent(this, Perfil.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }
}

