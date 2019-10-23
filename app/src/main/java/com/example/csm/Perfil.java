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
        Button btnOne = (Button) findViewById(R.id.button2);
        Button btnTwo = (Button) findViewById(R.id.button3);
        Button btnThree = (Button) findViewById(R.id.button4);
        Button btnFour = (Button) findViewById(R.id.button5);
        btnOne.setOnClickListener(this); // calling onClick() method
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button2:
                // code for button when user clicks btnOne.
                break;

            case R.id.button3:
                // do your code
                break;

            case R.id.button4:
                Intent intent = new Intent(this, Acciones.class);
                startActivity(intent);
                break;

            case R.id.button5:
                // do your code
                break;

            default:
                break;
        }
    }
}

