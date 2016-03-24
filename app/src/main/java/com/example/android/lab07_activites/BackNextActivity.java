package com.example.android.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BackNextActivity extends AppCompatActivity {

    private TextView tvNext;
    private int color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_next);

        tvNext = (TextView)findViewById(R.id.tv_next);
        color = getIntent().getIntExtra(ColorPickerActivity.BUNDLE_KEY_COLOR_INT, 0);
        tvNext.setBackgroundColor(color);

    }

    public void back(View view) {
//        Intent intent = new Intent(this, NextActivity.class);
//        startActivity(intent);
        finish();
    }

    public void next(View view) {
        Intent intent = new Intent(this, BackMainActivity.class);
        intent.putExtra(ColorPickerActivity.BUNDLE_KEY_COLOR_INT, color);
        startActivity(intent);
    }
}
