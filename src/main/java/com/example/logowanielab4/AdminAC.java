package com.example.logowanielab4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAC extends AppCompatActivity {

    TextView recived_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_ac);
        recived_message = (TextView)findViewById(R.id.Username_View);
/*
        Intent intent = getIntent();

        String msg = intent.getStringExtra("message_key");
        recived_message.setText(msg);*/
        Bundle extras = getIntent().getExtras();
        String name = null;
        if(extras != null){
            name = extras.getString("username");
            recived_message.setText("Welcome " + name);
        }
    }
}
