package com.cidafestas.activitys;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.Toast;

import com.cidafestas.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.github.chrisbanes.photoview.PhotoView;

import androidx.appcompat.app.AppCompatActivity;

public class ImagemAmpliada extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagem_ampliada);


        Bitmap foto = (Bitmap) getIntent().getParcelableExtra("foto");
        PhotoView imageview  = (PhotoView) findViewById(R.id.imageView10);
        imageview.setImageBitmap(foto);

        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null){
                try {
                    byte[] imageInByte = bundle.getByteArray("imagem");
                    Bitmap bmp = BitmapFactory.decodeByteArray(imageInByte,0,imageInByte.length);
                    PhotoView img  = (PhotoView) findViewById(R.id.imageViewBitmap);
                    imageview.setImageBitmap(bmp);
                }catch (Exception e){}
            }
        }catch (Exception e){
            Toast.makeText(this,""+e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}
