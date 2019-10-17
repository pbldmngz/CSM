package com.example.csm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private EditText name;
    private EditText password;
    private TextView info;
    private Button login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        name = (EditText) findViewById(R.id.tvName);
        password = (EditText) findViewById(R.id.tvPassword);
        info = (TextView) findViewById(R.id.tvInfo);
        login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate(name.getText().toString(), password.getText().toString());
            }
        });
    }

    private void Validate(String userName, String userPassword) {
        if((userName.equals("admin")) && (userPassword.equals("1234"))) {
            Intent intent = new Intent(Login.this, Notifications.class);
            startActivity(intent);
        }
        else {
            counter--;

            info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0) {
                login.setEnabled(false);
            }
        }
    }
}
