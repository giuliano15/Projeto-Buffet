package com.cidafestas.activitys;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.cidafestas.R;
import com.cidafestas.adapters.GaleriaImagensAdapter;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class GaleriaEventosCasamentos extends AppCompatActivity {

    CarouselView carouselView;

    int[] sampleImages = {R.drawable.casamento01, R.drawable.casamento02, R.drawable.casamento03, R.drawable.casamento04, R.drawable.casamento06};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_eventos_casamentos);

        View decorView = getWindow().getDecorView();
    // Esconde tanto a barra de navegação e a barra de status .
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;

        decorView.setSystemUiVisibility(uiOptions);




        carouselView = (CarouselView) findViewById(R.id.carouselViewCasamento);
        carouselView.setPageCount(sampleImages.length);
        carouselView.setImageListener(imageListener);


    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(final int position, final ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Drawable drawable = imageView.getDrawable();
                    Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                    byte[] imageInByte = stream.toByteArray();

                    Intent intent = new Intent(getApplicationContext(),ImagemAmpliada.class);
                    intent.putExtra("imagem",imageInByte);
                    startActivity(intent);
                    finish();

                }
            });
        }
    };


}

