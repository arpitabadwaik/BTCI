package com.bynry.bpal.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bynry.bpal.ui.fragments.BazaarFragment;
import com.bynry.bpal.ui.fragments.ConnectFragment;
import com.bynry.bpal.ui.fragments.TechBitesFragment;
import com.bynry.bpal.ui.fragments.WhatsUpFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String[] tabs = {"What's Up?", "Tech Bites", "Bazaar", "Connect"};

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    //For setting tab name
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Fragment getItem(int i) {


        switch (i) {
            case 0:
                return new WhatsUpFragment();
            case 1:
                return new TechBitesFragment();
            case 2:
                return new BazaarFragment();
            case 3:
                return new ConnectFragment();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}