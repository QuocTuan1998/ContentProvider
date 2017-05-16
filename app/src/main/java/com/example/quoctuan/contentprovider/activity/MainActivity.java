package com.example.quoctuan.contentprovider.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.quoctuan.contentprovider.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleOpenContactActivity(View view) {
        Intent intent = new Intent(MainActivity.this,ContactActivity.class);
        startActivity(intent);

    }
}
