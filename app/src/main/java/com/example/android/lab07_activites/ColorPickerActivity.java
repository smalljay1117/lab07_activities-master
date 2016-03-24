package com.example.android.lab07_activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ColorPickerActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY_COLOR_INT = "com.example.android.colorInt";
    public static final String BUNDLE_KEY_COLOR_NAME = "com.example.android.colorName";

    private int mColorInt;
    private CharSequence mColorName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);
        initColorData();
    }

    public void clickColor(View view) {
        RadioButton radio = (RadioButton)view;
        mColorInt = radio.getCurrentTextColor();
        mColorName = radio.getText();
    }

    private void initColorData() {
        RadioButton radio = (RadioButton)findViewById(R.id.radio_holo_red_light);
        mColorInt = radio.getCurrentTextColor();
        mColorName = radio.getText();
    }

    public void ok(View view) {
        Intent intent = new Intent();
        intent.putExtra(BUNDLE_KEY_COLOR_INT , mColorInt);
        intent.putExtra(BUNDLE_KEY_COLOR_NAME , mColorName);
        setResult(RESULT_OK, intent);
        finish();
    }

}
