package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private MainScreen mainScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DisplayMetrics displayMetrics = getFullScreen();
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //Loading screen

        //Main screen
        mainScreen = new MainScreen(this, width, height);
        mainScreen.setKeepScreenOn(true);
    }

    private DisplayMetrics getFullScreen() {
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(mainScreen);
    }
}