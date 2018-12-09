package com.example.mayank.bitotsav;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class EventDescriptionAndRules extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_description_and_rules);
        Intent intent=getIntent();
        String json=intent.getStringExtra("eventsJson");
        Log.d("pl",json);
        try {
            JSONObject jsonObject=new JSONObject(json);
            
        } catch (JSONException e) {

        }

    }
}
