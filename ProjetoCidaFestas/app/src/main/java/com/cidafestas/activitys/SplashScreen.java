package com.cidafestas.activitys;


import android.content.Intent;
import android.os.Bundle;

import android.view.WindowManager;

import com.cidafestas.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                moveNext();
            }
        });
        thread.start();

    }



    private void moveNext() {
        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        intent.putExtra("from","no");
        startActivity(intent);
        finish();
    }

}
