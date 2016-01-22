package com.sunyoung.test2;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private ListView navList;
    private FragmentManager fragmentManager;
    private android.app.FragmentManager vehicleFragmentManager;
    private android.app.FragmentTransaction vehicleFragmentTransaction;
    private FragmentTransaction fragmentTransaction;

    ViewPager viewPager = null;
    //ImageButton CarBtn1, CarBtn2, CarBtn3, CarBtn4;

    Thread thread = null;
    Handler handler = null;

    int p=0; //페이지 번호
    int v=1;	//화면 전환 뱡향

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view_pager);

        MyViewPagerAdapter myAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(myAdapter);

        TabPagerAdapter pageAdapter = new TabPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        setTitle("Fanta CarManager");
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        navList = (ListView)findViewById(R.id.navlist);
        navList.setOnItemClickListener(this);
        ArrayList<String> navArray = new ArrayList<String>();
        navArray.add("차량관리");
        navArray.add("날씨");
        navArray.add("도로교통");
        navArray.add("주차");
        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(adapter);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.opendrawer,R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        loadSelection(0);

        /*CarBtn1 = (ImageButton) findViewById(R.id.carBtn1);
        CarBtn2 = (ImageButton) findViewById(R.id.carBtn2);
        CarBtn3 = (ImageButton) findViewById(R.id.carBtn3);
        CarBtn4 = (ImageButton) findViewById(R.id.carBtn4);

        final Intent mIntent1 = new Intent(this, MyFragment1.VehicleRun.class);
        CarBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mIntent1);
            }
        });

        final Intent mIntent2 = new Intent(this,MyFragment1.VehicleRecord.class);
        CarBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(mIntent2);
            }
        });*/

        /*setContentView(R.layout.fragment_my_fragment1);
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentholder, new VehicleRun()).commit();
        }*/
    }

    private void loadSelection(int i) {
        navList.setItemChecked(i, true);
        switch (i) {
            case 0 :
                viewPager.setCurrentItem(0);
                /*MyFragment1 myFragment1 = new MyFragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myFragment1);
                fragmentTransaction.commit();*/
                break;
            case 1 :
                viewPager.setCurrentItem(1);
                /*MyFragment2 myFragment2 = new MyFragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myFragment2);
                fragmentTransaction.commit();*/
                break;
            case 2 :
                viewPager.setCurrentItem(2);
                /*MyFragment3 myFragment3 = new MyFragment3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myFragment3);
                fragmentTransaction.commit();*/
                break;
            case 3 :
                viewPager.setCurrentItem(3);
                /*MyFragment4 myFragment4 = new MyFragment4();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentholder, myFragment4);
                fragmentTransaction.commit();*/
                break;
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == android.R.id.home) {
           if (drawerLayout.isDrawerOpen(navList)) {
               drawerLayout.closeDrawer(navList);
           }
            else {
               drawerLayout.openDrawer(navList);
           }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        loadSelection(position);
        drawerLayout.closeDrawer(navList);
    }
}
