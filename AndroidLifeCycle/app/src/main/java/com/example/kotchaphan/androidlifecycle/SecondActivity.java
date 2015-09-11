package com.example.kotchaphan.androidlifecycle;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
////        if (keyCode == event.KEYCODE_BACK)
////            return true;
//        return false;
//    }

}
