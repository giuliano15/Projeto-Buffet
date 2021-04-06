package com.cidafestas.activitys;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;

import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cidafestas.R;
import com.cidafestas.model.FotosCardapio;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.ByteArrayOutputStream;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class ActivityDetails extends AppCompatActivity {

    List<FotosCardapio> fotosCardapioList;


    private FotosCardapio fotoSelecionada;

    ImageView imageView;
    TextView textViewTitle;
    TextView textViewDescricao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Fresco.initialize(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        // Instancia elementos de interfacew
        textViewTitle = findViewById(R.id.text_desc);
        textViewDescricao = findViewById(R.id.text_view_desc_details);
        imageView = findViewById(R.id.img_car_pic);


       //fonte de texto personalizada
        Typeface font1 = Typeface.createFromAsset(getAssets(), "fonts/Lobster-Regular.ttf");
        textViewDescricao.setTypeface(font1);

        //buscando Bitmap na classe fotosCardapioMysql
        final Bitmap foto = (Bitmap) getIntent().getParcelableExtra("foto");
        ImageView image = findViewById(R.id.img_car_pic);
        image.setImageBitmap(foto);

        final Intent intent = getIntent();

        //Recuperei o texto
        String texto = intent.getStringExtra("textoDescricao");





        //Picasso.get().load(foto).into(image);



//        Intent it = new Intent(getApplicationContext(),ActivityDetails.class);
//        it.putExtra("foto", fotoBmp);
//        it.putExtra("textoDescricao",txt);
//        startActivity(it);







        textViewDescricao.setText(texto);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* //transformei a foto que é BMP em uma string com nome img

                String img = BitMapToString(foto);
                Toast.makeText(ActivityDetails.this, "foto" + img, Toast.LENGTH_SHORT).show();


                */

                //Eviando foto Bmp para ser ampliada com photoview
                Intent intents = new Intent(getApplicationContext(), ImagemAmpliada.class);
                intents.putExtra("foto", foto);

                startActivity(intents);
            }
        });




    }

    public String BitMapToString(Bitmap bitmap){
        ByteArrayOutputStream baos=new  ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100, baos);
        byte [] b=baos.toByteArray();
        String temp= Base64.encodeToString(b, Base64.DEFAULT);
        return temp;
    }








    //imgCarPicture = (ImageView) findViewById(R.id.img_car_pic);
    // textModel = (TextView) findViewById(R.id.text_model);
    // textManufacturer = (TextView) findViewById(R.id.text_manufacturer);
    // textHorsePower = (TextView) findViewById(R.id.text_horse_power);
    //textPrice = (TextView) findViewById(R.id.text_price);


//        foto = (String) this.getIntent().getSerializableExtra("fotoSelecionada");
//       Picasso.get().load(String.valueOf(foto)).into(imgCarPicture);
//
//        Picasso.get().load(foto);

    //Uso Biblioteca Picasso para receber a string e abrir na ImageView desta activity


}
