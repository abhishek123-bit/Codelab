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
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        checkSharedPreferences();

        increaseCount();

        resetAllValues();

    }

    // Reset All values
    private void resetAllValues() {
        b.btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                b.mcount.setText("0");
                mColor = getResources().getColor(R.color.text_bg);
                b.mcount.setBackgroundColor(mColor);

                //clear sharedPreferences data
                mPreferences.edit().clear().apply();
            }
        });
    }

    //Increase the count value
    private void increaseCount() {
        b.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.mcount.setText(++count + "");
            }
        });
    }

    //check sharedPreferences
    private void checkSharedPreferences() {
        if (mPreferences != null) {
            count = mPreferences.getInt("Count", 0);
            b.mcount.setText(count + "");
            mColor = mPreferences.getInt("Color", getResources().getColor(R.color.text_bg));
            b.mcount.setBackgroundColor(mColor);
        }

    }

    //On background color change
    @SuppressLint("NonConstantResourceId")
    public void ChangeBackground(View view) {
        switch (view.getId()) {
            case R.id.btn_black:
                mColor = getResources().getColor(R.color.black);
                break;
            case R.id.btn_blue:
                mColor = getResources().getColor(R.color.Blue);
                break;
            case R.id.btn_Red:
                mColor = getResources().getColor(R.color.Red);
                break;
            case R.id.btn_Green:
                mColor = getResources().getColor(R.color.Green);
        }
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