package com.example.Garbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class gc_login extends AppCompatActivity {

    EditText gc_id;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gclogin);

        gc_id = (EditText) findViewById(R.id.et_gc_id);
        login = (Button) findViewById(R.id.btn_login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gc_id.getText().toString().equals("GC001") || gc_id.getText().toString().equals("GC002") || gc_id.getText().toString().equals("GC003")) {

                    Intent i = new Intent(gc_login.this, MainActivity.class);
                    startActivity(i);
                    //correct password
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wrong User", Toast.LENGTH_LONG);
                }
            }
        });
    }


}