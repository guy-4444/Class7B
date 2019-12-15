package com.example.class7b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {


    private ImageView main_IMG_top;

    private SensorManager mSensorManager;
    private Sensor mSensor;
    private int num = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_IMG_top = findViewById(R.id.main_IMG_top);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        intent.putExtra(Constants.KEY_SPEED, 5);
//        startActivity(intent);


        //https://www.tesla.com/ns_videos/homepage/main_hero_homepage_desktop.jpg


        Glide
                .with(this)
//                .load("https://www.tesla.com/ns_videos/homepage/main_hero_homepage_desktop.jpg")
                .load(R.drawable.img_cars)
                .centerCrop()
                .into(main_IMG_top);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(sensorEventListener, mSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(sensorEventListener);
    }

    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            sensorChanged(event.values[0] == 0.0f);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    private void sensorChanged(boolean faceOn) {
        num--;
        Log.d("pttt", "faceOn= " + faceOn);
    }

}

/*
            boolean bool = (event.values[0] == 0.0f) ? true : false;
            int x = 9;
            String message = (x <= 10) ? "Good" : "Bad";
 */
