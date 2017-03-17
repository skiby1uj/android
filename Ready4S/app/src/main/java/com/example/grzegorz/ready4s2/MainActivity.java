package com.example.grzegorz.ready4s2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private PagerAdapter mPageAdapter;
    private ViewPager pager;
    private List<Fragment> fragments = new Vector<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.initialisePage();
    }

    private void initialisePage(){
        fragments.add(Fragment.instantiate(this, MapsActivity.class.getName()));
        fragments.add(Fragment.instantiate(this, Latest.class.getName()));


        this.mPageAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), fragments);
        pager = (ViewPager)super.findViewById(R.id.viewPagerId);
        pager.setAdapter(this.mPageAdapter);
    }

    private void updateLatestFragmentView(){
        Fragment frg = fragments.get(1);
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(frg);
        ft.attach(frg);
        ft.commit();

    }

    public void ButtonMapaClick(View view){
        pager.setCurrentItem(0);
    }

    public void ButtonOstatnioClick(View view){
        updateLatestFragmentView();
        pager.setCurrentItem(1);
    }
}
