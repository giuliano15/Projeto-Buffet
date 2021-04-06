package com.cidafestas.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cidafestas.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.ByteArrayOutputStream;

public class GaleriaFestaFormatura extends AppCompatActivity {

    CarouselView carouselView;
    int[] sampleImages = {R.drawable.formatura01, R.drawable.formatura02, R.drawable.formatura03, R.drawable.formatura04, R.drawable.formatura05};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_festa_formatura);
        carouselView = (CarouselView) findViewById(R.id.carouselViewFormatura);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);


    }
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, final ImageView imageView) {
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
