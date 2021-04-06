package com.cidafestas.activitys;



import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cidafestas.R;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySobre extends AppCompatActivity {

    ImageView imgEquipe;
    TextView txtGrid;

       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        View decorView = getWindow().getDecorView();
        // Esconde tanto a barra de navegação e a barra de status .
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);

      TextView  politica = findViewById(R.id.textPolitica);
      politica.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent politica = new Intent(getApplicationContext(),PoliticaPrivacidade.class);
              startActivity(politica);
          }
      });


        imgEquipe = findViewById(R.id.img_equipe);
        Drawable bitmap = getResources().getDrawable(R.drawable.equipe);
        imgEquipe.setImageDrawable(bitmap);




        txtGrid = (TextView) findViewById(R.id.textGrid);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/Lobster-Regular.ttf");
        txtGrid.setTypeface(font);

        TextView tv = (TextView) findViewById(R.id.textView1);
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/Lobster-Regular.ttf");
        tv.setTypeface(font1);


        Typeface font2 = Typeface.createFromAsset(getAssets(), "fonts/Lobster-Regular.ttf");
        tv.setTypeface(font1);

        imgEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passarImagem();
            }
        });



    }
    private void passarImagem() {
        imgEquipe = findViewById(R.id.img_equipe);
        Drawable drawable = imgEquipe.getDrawable();
        Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, stream);
        byte[] imageInByte = stream.toByteArray();

        Intent intent = new Intent(ActivitySobre.this,ImagemAmpliadaBitmap.class);
        intent.putExtra("imagem",imageInByte);
        startActivity(intent);
        finish();
    }




}



