package com.piyushsatija.pollutionmonitor.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.piyushsatija.pollutionmonitor.BuildConfig;
import com.piyushsatija.pollutionmonitor.R;
import com.piyushsatija.pollutionmonitor.utils.SharedPrefUtils;

public class SplashActivity extends AppCompatActivity {
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPrefUtils sharedPrefUtils = SharedPrefUtils.getInstance(this);
        if (sharedPrefUtils.isDarkMode()) setTheme(R.style.AppTheme_Light);
        else setTheme(R.style.AppTheme_Dark);
        setContentView(R.layout.activity_splash);
        TextView versionTextView = findViewById(R.id.splash_version_text);
        versionTextView.setText(String.format("v%s", BuildConfig.VERSION_NAME));

        handler.postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }, 2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove all the callbacks otherwise navigation will execute even after activity is killed or closed.
        handler.removeCallbacksAndMessages(null);
    }
}
