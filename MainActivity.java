package com.sunyoung.viewpager;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn[] = new Button[4];
    ViewPager viewPager = null;

    Thread thread = null;
    Handler handler = null;

    int p=0; //페이지 번호
    int v=1;	//화면 전환 뱡향

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Fanta");

        viewPager = (ViewPager)findViewById(R.id.view_pager);

        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        btn[0] = (Button)findViewById(R.id.btn1);
        btn[1] = (Button)findViewById(R.id.btn2);
        btn[2] = (Button)findViewById(R.id.btn3);
        btn[3] = (Button)findViewById(R.id.btn4);

        for(int i=0;i<btn.length; i++){
            btn[i].setOnClickListener(this);
        }

        handler = new Handler(){
            public void handleMessage(android.os.Message msg) {
                if(p==0) {
                    viewPager.setCurrentItem(1);
                    p++;
                    v=1;
                }
                else if(p==1&&v==0) {
                    viewPager.setCurrentItem(0);
                    p--;
                }
                else if(p==1&&v==1) {
                    viewPager.setCurrentItem(2);
                    p++;
                }
                else if(p==2&&v==0) {
                    viewPager.setCurrentItem(1);
                    p--;
                }
                else if(p==2&&v==1) {
                    viewPager.setCurrentItem(3);
                    p++;
                }
                else if(p==3) {
                    viewPager.setCurrentItem(2);
                    p--;
                    v=0;
                }
            }
        };
    }
        @Override
    public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn1:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.btn2:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.btn3:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.btn4:
                    viewPager.setCurrentItem(3);
                default:
                    break;
            }
        }
}
