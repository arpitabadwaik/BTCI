package com.bynry.bpal.ui.activities;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.adapters.ViewPagerAdapter;
import com.bynry.bpal.ui.fragments.BazaarFragment;
import com.bynry.bpal.ui.fragments.ConnectFragment;
import com.bynry.bpal.ui.fragments.TechBitesFragment;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;

public class MainActivity extends AppCompatActivity {

    private Context context;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
}
