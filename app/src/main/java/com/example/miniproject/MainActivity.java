package com.example.miniproject;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.miniproject.databinding.ActivityMainBinding;
import com.example.miniproject.view.ContactFragment;
import com.example.miniproject.view.FavoriteFragment;
import com.example.miniproject.view.FreeFragment;
import com.example.miniproject.view.SettingFragment;
import com.example.miniproject.view.StoreFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setFragment(new FreeFragment());

        binding.navMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_free:
                        setFragment(new FreeFragment());
                        return true;
                    case R.id.nav_store:
                        setFragment(new StoreFragment());
                        return true;
                    case R.id.nav_contact:
                        setFragment(new ContactFragment());
                        return true;
                    case R.id.nav_favorite:
                        setFragment(new FavoriteFragment());
                        return true;
                    case R.id.nav_setting:
                        setFragment(new SettingFragment());
                        return true;
                    default:
                        return false;
                }
            }
        });


    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private static long back_pressed;

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed();
            finish();
        } else
            Toast.makeText(getApplicationContext(), "กรุณากดอีกครั้ง !", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
