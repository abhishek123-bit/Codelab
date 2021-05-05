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
        //Initialize binding
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        //Handel the click event
         eventHandler();
    }

    /**
     * Trigger Event handlers to listen the actions
     */
    private void eventHandler() {
        //click listener on Toast button
        b.btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Show toast message
                Toast.makeText(MainActivity.this, R.string.toast_msg, Toast.LENGTH_SHORT).show();
            }
        });

        //click listener on Count button
        b.btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                 *Increase the count
                 *Update count TextView
                 */
                b.count.setText(++count+"");
            }
        });
    }
}