package com.cidafestas.activitys;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cidafestas.R;

import androidx.appcompat.app.AppCompatActivity;


public class Book_Activity extends AppCompatActivity {

    private TextView tvtitle,tvdescription,tvcategory;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_book_);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvdescription = (TextView) findViewById(R.id.txtDesc);
        tvcategory = (TextView) findViewById(R.id.txtCat);
        img = (ImageView) findViewById(R.id.bookthumbnail);
        final String teste = img.toString();

        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String Description = intent.getExtras().getString("Description");
        int image = intent.getExtras().getInt("Thumbnail") ;
        final String testeFoto = (String) intent.getExtras().get("teste");

        // Setting values

        tvtitle.setText(Title);
        tvdescription.setText(Description);
        img.setImageResource(image);






       // Picasso.get().load(String.valueOf(teste)).into(img);



        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Book_Activity.this, "teste", Toast.LENGTH_SHORT).show();





                Intent intent = new Intent(getApplicationContext(), ImagemAmpliada.class);
                intent.putExtra("teste", testeFoto); //nesta linha ja com a string capturada na posiçao passei ela via intent para outra activity(Imagem.class)
                Toast.makeText(Book_Activity.this, "" + testeFoto, Toast.LENGTH_SHORT).show();
                startActivity(intent);


            }
        });



    }
}
