package com.example.miniproject.view;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.miniproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends Fragment {


    private TabLayout tabLayout;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);
        tabLayout = (TabLayout) v.findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("แจ้งเตือน"));
        tabLayout.addTab(tabLayout.newTab().setText("ติดต่อเรา"));

        return v;
    }

}
