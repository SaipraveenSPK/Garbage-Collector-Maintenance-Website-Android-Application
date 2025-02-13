package com.example.Garbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class userlogin extends AppCompatActivity {

    EditText user,password;
    Button log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin);

        user = (EditText) findViewById(R.id.et_user);
        password = (EditText) findViewById(R.id.et_password);

        log = (Button) findViewById(R.id.btn_log);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( user.getText().toString().equals("sai") && password.getText().toString().equals("1234"))
                {
                    Intent i = new Intent(userlogin.this,userhomepage.class);
                    startActivity(i);
                }
            }
        });
    }
}