package com.aditep.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.aditep.mvcstructure.R;
import com.aditep.mvcstructure.fragment.MainFragment;
import com.aditep.mvcstructure.fragment.SecondFragment;
import com.aditep.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_second_fragment:
                Fragment fragment = getSupportFragmentManager()
                        .findFragmentById(R.id.contentContainer);
                if (fragment instanceof SecondFragment == false) {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.contentContainer, SecondFragment.newInstance())
                            .addToBackStack(null)
                            .commit();
                    Toast.makeText(MainActivity.this, "Second Fragment", Toast.LENGTH_SHORT).show();
                    return true;
                }
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        //Toast screenWidth & screenHeight
        Toast.makeText(MainActivity.this, "Width = " + screenWidth + "Height" + screenHeight, Toast.LENGTH_SHORT).show();

        // Separate bt Android Version
        if (Build.VERSION.SDK_INT >= 21) {
            //RUN on Android 21+
        } else {
            // Run on Android 1- 20
        }

        if (savedInstanceState == null) {
            // First Created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstance(123), "MainFragment")
                    .commit();


        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {

            MainFragment fragment = (MainFragment)
                    getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setHelloText("Woo Hooooooooo");
        }
    }
}
