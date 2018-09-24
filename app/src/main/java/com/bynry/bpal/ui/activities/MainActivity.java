package com.bynry.bpal.ui.activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.bynry.bpal.R;
import com.bynry.bpal.ui.adapters.ViewPagerAdapter;
import com.bynry.bpal.ui.fragments.BazaarFragment;
import com.bynry.bpal.ui.fragments.ConnectFragment;
import com.bynry.bpal.ui.fragments.TechBitesFragment;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_action_whats_up,
            R.drawable.ic_action_tech_bites,
            R.drawable.ic_action_bazaar,
            R.drawable.ic_action_connect
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(null);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                tab.setIcon(R.drawable.ic_action_facebook);
                /*int tabIconColor = ContextCompat.getColor(this, R.color.black);
                tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);*/
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab.setIcon(tabIconsUnSelected[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        // CODE HERE
                        tabLayout.getTabAt(0).setIcon(tabIcons[3]);
                        break;
                    case 1:
                        // CODE HERE
                        tabLayout.getTabAt(0).setIcon(tabIcons[3]);
                        break;
                    case 2:
                        // CODE HERE
                        tabLayout.getTabAt(0).setIcon(tabIcons[3]);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabOne.setText("What's Up?");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_whats_up, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabTwo.setText("Tech Bites");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_tech_bites, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabThree.setText("Bazaar");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_bazaar, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab_layout, null);
        tabFour.setText("Connect");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_action_connect, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WhatsUpFragment(), "What's Up?");
        adapter.addFrag(new TechBitesFragment(), "Tech Bites");
        adapter.addFrag(new BazaarFragment(), "Bazaar ");
        adapter.addFrag(new ConnectFragment(), "Connect ");
        viewPager.setAdapter(adapter);
    }
}
