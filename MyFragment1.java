package com.sunyoung.test2;


import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment1 extends android.support.v4.app.Fragment {

    protected void startFragment(FragmentManager fm, Class<? extends  MyFragment1> fragmentClass) {
        MyFragment1 fragment = null;
        try {
            fragment = fragmentClass.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (fragment == null) {
            throw new IllegalStateException("cannot start fragment. " + fragmentClass.getName());
        }
        getActivity().getSupportFragmentManager().beginTransaction().add(R.id.vehicleID, fragment).addToBackStack(null).commit();
    }

    protected void finishFragment() {
        getFragmentManager().popBackStack();
    }

    public void onPressedBackkey() {
        finishFragment();
    }

    public static android.support.v4.app.Fragment newInstance(int page) {
        MyFragment1 fragment = new MyFragment1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

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
        View rootView = inflater.inflate(R.layout.fragment_my_fragment1, container, false);
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

}