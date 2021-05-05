package com.example.colormyview;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.colormyview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize binding
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


    }


    /**
     * Background color change on click event
     *
     * @param view To get which view is click
     */
    @SuppressLint({"ResourceType", "NonConstantResourceId"})
    public void changeBackground(View view) {
        //check which view is click
        switch (view.getId()) {
            //BoxOne is click
            case R.id.box_one_text:
                view.setBackgroundColor(Color.DKGRAY);
                break;
            //BoxTwo is click
            case R.id.box_two_text:
                view.setBackgroundColor(Color.GRAY);
                break;
            //BoxThree is click
            case R.id.box_three_text:
                //BoxFive is click
            case R.id.box_five_text:
                view.setBackgroundColor(Color.BLUE);
                break;
            //BoxFour is click
            case R.id.box_four_text:
                view.setBackgroundColor(Color.MAGENTA);
                break;
            //Red Button is click
            case R.id.btn_red:
                b.boxThreeText.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            //Yellow Button is click
            case R.id.btn_yellow:
                b.boxFourText.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            //Green Button is click
            case R.id.btn_green:
                b.boxFiveText.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            //click on root
            default:
                view.setBackgroundColor(Color.LTGRAY);

        }
    }
}