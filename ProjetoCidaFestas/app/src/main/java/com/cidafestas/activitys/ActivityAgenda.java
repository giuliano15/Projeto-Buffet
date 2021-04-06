package com.cidafestas.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.cidafestas.R;

public class ActivityAgenda extends AppCompatActivity {
    TextView txtpv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

      //fonte de texto personalizado
         txtpv = (TextView) findViewById(R.id.txt_agenda);
        Typeface font3 = Typeface.createFromAsset(getAssets(), "fonts/Lobster-Regular.ttf");
        txtpv.setTypeface(font3);
    }
}
