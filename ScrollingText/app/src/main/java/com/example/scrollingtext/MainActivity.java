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
        b=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setupLink();
    }

    //To clickable link
    private void setupLink() {
        b.article.setMovementMethod(LinkMovementMethod.getInstance());
    }
}