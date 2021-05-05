package com.example.hellosharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.hellosharedprefs.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;
    int count = 0;
    int mColor;
    SharedPreferences mPreferences;
    final String sharedPrefFile = "com.example.android.HelloSharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize binding
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Initialize SharedPreferences
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        //check sharedPreference data
        checkSharedPreferences();

        //Increase count
        increaseCount();

        //Reset the value
        resetAllValues();

    }

    /**
     * Reset count value and background of count
     * update views
     */
    private void resetAllValues() {
        //click listener on Reset Button
        b.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                b.mcount.setText("0");
                mColor = getResources().getColor(R.color.text_bg);

                //update background
                b.mcount.setBackgroundColor(mColor);

                //clear sharedPreferences data
                mPreferences.edit().clear().apply();
            }
        });
    }

    /**
     * Increase the count value
     * update Count TextView
     */
    private void increaseCount() {
        //click listener on Count Button
        b.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To update count and TextView
                b.mcount.setText(++count + "");
            }
        });
    }

    /**
     * check sharedPreferences on configuration change
     * check sharedPreferences On restart app
     */
    private void checkSharedPreferences() {
        if (mPreferences != null) {
            count = mPreferences.getInt("Count", 0);
            b.mcount.setText(count + "");
            mColor = mPreferences.getInt("Color", getResources().getColor(R.color.text_bg));
            b.mcount.setBackgroundColor(mColor);
        }

    }

    /**
     *
     * Background color change on click event
     * @param view To get which view is click
     */
    @SuppressLint("NonConstantResourceId")
    public void ChangeBackground(View view) {
        //check which view is click
        switch (view.getId()) {
            //Black Button is click
            case R.id.btn_black:
                mColor = getResources().getColor(R.color.black);
                break;
            //Blue Button is click
            case R.id.btn_blue:
                mColor = getResources().getColor(R.color.Blue);
                break;
            //Red Button is click
            case R.id.btn_Red:
                mColor = getResources().getColor(R.color.Red);
                break;
            //Green Button is click
            case R.id.btn_Green:
                mColor = getResources().getColor(R.color.Green);
        }
        //To update the background
        b.mcount.setBackgroundColor(mColor);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //store value in shared Preference
        mPreferences.edit().putInt("Count", count)
                .putInt("Color", mColor)
                .apply();
    }

}