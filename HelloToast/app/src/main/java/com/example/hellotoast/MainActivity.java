package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hellotoast.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

         eventHandler();
    }

    private void eventHandler() {

        //To show the toast message
        b.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.toast_msg, Toast.LENGTH_SHORT).show();
            }
        });

        //To Increase the count value
        b.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.count.setText(++count+"");
            }
        });
    }
}