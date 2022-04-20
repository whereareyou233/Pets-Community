package com.example.pats_community;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton b1;
    private ToggleButton b2;

    Load_Fragment load_fragment = new Load_Fragment();
    Rigist_Fragment rigist_fragment = new Rigist_Fragment();
    ViewPager viewPager;

    List<Fragment> fragments=new ArrayList<>();;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        viewPager=findViewById( R.id.ViewPager );
        fragments.add(load_fragment);
        fragments.add(rigist_fragment);

        myAdapter adapter=new myAdapter( getSupportFragmentManager(),fragments );
        viewPager.setAdapter( adapter );

        b1 = findViewById(R.id.load);
        b2 = findViewById(R.id.regist);
        b1.setOnCheckedChangeListener(this);
        b2.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.load:
                viewPager.setCurrentItem( 0 );
                break;
            case R.id.regist:

                viewPager.setCurrentItem( 1 );
                //设置选中状态
                break;
        }
    }

    private static class myAdapter extends FragmentPagerAdapter {

        private  final List<Fragment>fragments;
        public myAdapter(FragmentManager fm, List<Fragment>fragments) {
            super( fm );
            this.fragments=fragments;
        }
        @NonNull
        public Fragment getItem(int position) {
            return fragments.get( position );
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}