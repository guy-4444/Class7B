package com.example.class7b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);



        int speed = -1;
        speed = getIntent().getIntExtra(Constants.KEY_SPEED, 0);

        Log.d("pttt", "speed= "  + speed);

        long time = System.currentTimeMillis();
        //Time format

    }
}
