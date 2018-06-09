package com.aditep.mvcstructure.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.aditep.mvcstructure.R;
import com.aditep.mvcstructure.fragment.MainFragment;
import com.aditep.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        //Tiast screenWidth & screenHeight
        Toast.makeText(MainActivity.this, "Width = " + screenWidth + "Height" + screenHeight, Toast.LENGTH_SHORT).show();

        // Separate bt Android Version
        if (Build.VERSION.SDK_INT >= 21){
            //RUN on Android 21+
        } else {
            // Run on Android 1- 20
        }

        if (savedInstanceState == null) {
            // First Created
            // Place Fragment here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstance(123))
                    .commit();
        }
    }

}
