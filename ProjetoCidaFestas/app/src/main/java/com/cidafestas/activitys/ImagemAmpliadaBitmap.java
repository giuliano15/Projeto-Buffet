package com.cidafestas.activitys;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;


import android.widget.Toast;

import com.cidafestas.R;
import com.github.chrisbanes.photoview.PhotoView;

import androidx.appcompat.app.AppCompatActivity;


public class ImagemAmpliadaBitmap extends AppCompatActivity {

    PhotoView photoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_imagem_ampliada_bitmap);

        try {
            Bundle bundle = getIntent().getExtras();
            if (bundle != null){
                try {
                    byte[] imageInByte = bundle.getByteArray("imagem");
                    Bitmap bmp = BitmapFactory.decodeByteArray(imageInByte,0,imageInByte.length);
                    PhotoView imageview  = (PhotoView) findViewById(R.id.imageViewBitmap);
                    imageview.setImageBitmap(bmp);
                }catch (Exception e){}
            }
        }catch (Exception e){
            Toast.makeText(this,""+e, Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }




    }

}
