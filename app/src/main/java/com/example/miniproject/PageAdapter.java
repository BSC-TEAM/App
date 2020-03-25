package com.example.miniproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.miniproject.tabview.TabBook;

public class PageAdapter extends FragmentPagerAdapter {
    int count;

    public PageAdapter(FragmentManager fm,int count) {
        super(fm);
        this.count = count;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new TabBook();
            case 1:
                return new TabBook();
            case 2:
                return new TabBook();
            case 3:
                return new TabBook();
        }
        return null;
    }

    @Override
    public int getCount() {
        return count;
    }
}
