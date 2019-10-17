package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Perfil extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        Button btnOneTwo = (Button) findViewById(R.id.listButton4);
        Button btnTwoTwo = (Button) findViewById(R.id.notificationsButton4);
        Button btnThreeTwo = (Button) findViewById(R.id.actionsButton4);
        btnOneTwo.setOnClickListener(this); // calling onClick() method
        btnTwoTwo.setOnClickListener(this);
        btnThreeTwo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.listButton4:
                Intent intent = new Intent(this, List.class); //Notifications class is actually List class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent);
                break;

            case R.id.notificationsButton4:
                Intent intent2 = new Intent(this, Notifications.class); //List class is actually Notifications class DO NOT CHANGE CLASS DESTINATION NAME
                startActivity(intent2);
                break;

            case R.id.actionsButton4:
                Intent intent3 = new Intent(this, Acciones.class);
                startActivity(intent3);
                break;

            default:
                break;
        }
    }
}

