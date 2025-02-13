package com.example.Garbell;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    String[] years = {"1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year", "All"};
    AutoCompleteTextView autoCompleteTxt;
    ArrayAdapter<String> adapterItems;
    private EditText title,message;
    private Button sentbtn,bt_logout;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTxt = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_of_years, years);
        autoCompleteTxt.setAdapter(adapterItems);
        autoCompleteTxt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Year: "+item,Toast.LENGTH_SHORT).show();
            }
        });

        FirebaseMessaging.getInstance().subscribeToTopic("all");

        title = findViewById(R.id.title_id);
        message = findViewById(R.id.message_id);
        sentbtn = findViewById(R.id.sent_btn);
        bt_logout = (Button) findViewById(R.id.bt_logout);

        sentbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!title.getText().toString().isEmpty() && !message.getText().toString().isEmpty()) {
                    FcmNotificationsSender notificationsSender = new FcmNotificationsSender("/topics/all", title.getText().toString(),
                            message.getText().toString(), getApplicationContext(), MainActivity.this);
                    notificationsSender.SendNotifications();
                }else{
                    Toast.makeText(MainActivity.this,"Please give your data",Toast.LENGTH_LONG).show();
                }

            }
        });

        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Homepage.class);
                startActivity(i);
            }
        });
    }

}