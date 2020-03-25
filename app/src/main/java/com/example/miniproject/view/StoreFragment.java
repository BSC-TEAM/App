package com.example.miniproject.view;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.miniproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StoreFragment extends Fragment {


    private TabLayout tabLayout;
    private Toolbar toolBar;

    public StoreFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_store, container, false);
        tabLayout = v.findViewById(R.id.tabLayout);

        toolBar = v.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolBar);
        setHasOptionsMenu(true);

        tabLayout.addTab(tabLayout.newTab().setText("หนังสือ"));
        tabLayout.addTab(tabLayout.newTab().setText("บทความ"));
        tabLayout.addTab(tabLayout.newTab().setText("พระคัมภีร์"));
        tabLayout.addTab(tabLayout.newTab().setText("มานาประจำวัน"));

        return v;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.shopping:
                Toast.makeText(getActivity(),"Shopping",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search:
                Toast.makeText(getActivity(),"search",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
