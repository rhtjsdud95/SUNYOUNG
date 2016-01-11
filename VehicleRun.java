package com.sunyoung.viewpager;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ToggleButton;

public class VehicleRun extends AppCompatActivity {
    Button StopBtn;
    ToggleButton TimeToggle;
    Chronometer Chrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.run_vehicle);

        setTitle("차량주행");

        StopBtn = (Button) findViewById(R.id.stopBtn);
        TimeToggle = (ToggleButton) findViewById(R.id.timeToggle);
        Chrono = (Chronometer) findViewById(R.id.chrono);

        StopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Chrono.setBase(SystemClock.elapsedRealtime());
            }
        });

        TimeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TimeToggle.isChecked()) {
                    Chrono.start();
                }
                else {
                    Chrono.stop();
                }
            }
        });
    }
}