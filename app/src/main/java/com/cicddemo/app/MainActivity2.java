package com.cicddemo.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        int a = 10;
        int b = 20;
        int d = 30;

        int c = a + b == d ? 40 : 0;

    }
}