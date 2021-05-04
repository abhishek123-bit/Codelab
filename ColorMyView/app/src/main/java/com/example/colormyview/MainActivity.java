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
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());


    }


    //Change background color
    @SuppressLint({"ResourceType", "NonConstantResourceId"})
    public void changeBackground(View view) {
        switch (view.getId()){
            case R.id.box_one_text:
                view.setBackgroundColor(Color.DKGRAY);
                break;
            case R.id.box_two_text:
                view.setBackgroundColor(Color.GRAY);
                break;
            case R.id.box_three_text:
            case R.id.box_five_text:
                view.setBackgroundColor(Color.BLUE);
                break;
            case R.id.box_four_text:
                view.setBackgroundColor(Color.MAGENTA);
                break;
            case R.id.btn_red:
                b.boxThreeText.setBackgroundColor(getResources().getColor(R.color.red));
                break;
            case R.id.btn_yellow:
                b.boxFourText.setBackgroundColor(getResources().getColor(R.color.yellow));
                break;
            case R.id.btn_green:
                b.boxFiveText.setBackgroundColor(getResources().getColor(R.color.green));
                break;
            default:
                view.setBackgroundColor(Color.LTGRAY);

        }
    }
}