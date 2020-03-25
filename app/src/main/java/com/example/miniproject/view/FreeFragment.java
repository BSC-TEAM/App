package com.example.miniproject.view;



import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miniproject.PageAdapter;
import com.example.miniproject.R;


public class FreeFragment extends Fragment {

    TabLayout tabLayout;
    Toolbar toolBar;
    ViewPager viewPage;
    PageAdapter pageAdapter;

    public FreeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_free, container, false);

        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);

        toolBar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        setHasOptionsMenu(true);

        tabLayout.addTab(tabLayout.newTab().setText("หนังสือ"));
        tabLayout.addTab(tabLayout.newTab().setText("บทความ"));
        tabLayout.addTab(tabLayout.newTab().setText("พระคัมภีร์"));
        tabLayout.addTab(tabLayout.newTab().setText("มานาประจำวัน"));

        viewPage = v.findViewById(R.id.viewPage);
        viewPage.setAdapter(new PageAdapter(getChildFragmentManager(), tabLayout.getTabCount()));
        viewPage.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPage.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(getActivity(),"search",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
