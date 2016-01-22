package com.sunyoung.test2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ToggleButton;

public class VehicleRun extends MyFragment1 {
    ImageButton CarBtn1;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.run_vehicle, container, false);

        CarBtn1 = (ImageButton)rootView.findViewById(R.id.carBtn1);

        CarBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFragment(getFragmentManager(), VehicleRun.class);
            }
        });

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
    /*
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
    }*/
}
