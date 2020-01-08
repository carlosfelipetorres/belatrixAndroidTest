package com.example.shakerapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ShakeDetectorActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorMgr;
    private static final float SHAKE_THRESHOLD = 3.25f;
    private static final int MIN_TIME_BETWEEN_SHAKES_MILLISECS = 1000;
    private long mLastShakeTime;
    private TextView flag;
    private TextView currentAcceleration;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake_detector);

        mSensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);

        Sensor accelerometer = null;
        if (mSensorMgr != null) {
            accelerometer = mSensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        if (accelerometer != null) {
            mSensorMgr.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        currentAcceleration = findViewById(R.id.currentAcceleration);
        flag = findViewById(R.id.flag);
    }

    @Override
    protected void onDestroy() {
        mSensorMgr.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            long curTime = System.currentTimeMillis();
            if ((curTime - mLastShakeTime) > MIN_TIME_BETWEEN_SHAKES_MILLISECS) {

                float x = event.values[0];
                float y = event.values[1];
                float z = event.values[2];

                double acceleration = Math.sqrt(Math.pow(x, 2) +
                        Math.pow(y, 2) +
                        Math.pow(z, 2)) - SensorManager.GRAVITY_EARTH;

                currentAcceleration.setText("Acceleration " + acceleration);

                if (acceleration > SHAKE_THRESHOLD) {
                    mLastShakeTime = curTime;
                    flag.setText("Phone has been shaked");
                }
            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
