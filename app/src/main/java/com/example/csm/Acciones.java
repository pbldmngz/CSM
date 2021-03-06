package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Acciones extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acciones);

        Button btnOne = (Button) findViewById(R.id.listButton2);
        Button btnTwo = (Button) findViewById(R.id.notificationsButton2);
        Button btnFour = (Button) findViewById(R.id.profileButton2);
        btnOne.setOnClickListener(this); // calling onClick() method
        btnTwo.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.listButton2:
                Intent intent = new Intent(this, List.class); //Notifications class is actually List class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent);
                break;

            case R.id.notificationsButton2:
                Intent intent2 = new Intent(this, Notifications.class); //List class is actually Notifications class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent2);
                break;

            case R.id.profileButton2:
                Intent intent4 = new Intent(this, Perfil.class);
                startActivity(intent4);
                break;

            default:
                break;
        }
    }
}

