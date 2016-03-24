package com.example.android.lab07_activites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int SELECT_COLOR_REQUEST = 0;
    private  int colorInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectColor(View view) {
        Intent intent = new Intent(this, ColorPickerActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, SELECT_COLOR_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_COLOR_REQUEST) {
            Bundle bundle = data.getExtras();
            colorInt = bundle.getInt(ColorPickerActivity.BUNDLE_KEY_COLOR_INT);
            CharSequence colorName = bundle.getCharSequence(ColorPickerActivity.BUNDLE_KEY_COLOR_NAME);
            TextView tv_color = (TextView)findViewById(R.id.tv_color);
            tv_color.setText(colorName);
            tv_color.setBackgroundColor(colorInt);
        }
    }

    public void next(View view) {
        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra(ColorPickerActivity.BUNDLE_KEY_COLOR_INT, colorInt);
        startActivity(intent);
    }
}
