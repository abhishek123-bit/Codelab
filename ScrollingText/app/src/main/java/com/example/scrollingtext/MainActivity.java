package com.example.scrollingtext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;

import com.example.scrollingtext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initialize binding
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupLink();
    }

    /**
     * Open URL inside Article TextView
     */
    private void setupLink() {
        //To open Url  in Browser
        b.article.setMovementMethod(LinkMovementMethod.getInstance());
    }
}