package com.example.mobile_application.vue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobile_application.R;
import com.example.mobile_application.controller.DetailController;

public class Detail extends Activity {

    DetailController ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent myIntent = getIntent();
        String id = myIntent.getStringExtra("id");

        ma = new DetailController(this , id);
        ma.onStart();

    }

    public void showMovie (String title, String director, Integer date) {
        TextView txTitle = findViewById(R.id.Title);
        TextView txDirector = findViewById(R.id.Director);
        TextView txRelease = findViewById(R.id.Release_Date);

        txTitle.setText(title);
        txDirector.setText(director);
        txRelease.setText(date);

    }

}
