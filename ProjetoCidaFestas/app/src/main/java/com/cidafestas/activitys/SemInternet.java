package com.cidafestas.activitys;



import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cidafestas.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class SemInternet extends AppCompatActivity {

    ImageView imageView;
    boolean doubleBackToExitPressedOnce = false;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem_internet);

        imageView = findViewById(R.id.imageViewSemInternet);

        onBackPressed();

    }



    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            voltar();
        } else {
            doubleBackToExitPressedOnce = true;

            toast_me();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = true;
                }
            }, 2000);
        }
    }

    public void voltar() {
        Intent int1 = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(int1);


    }public void toast_me(){
        Toast toast = Toast.makeText(this, "Toast me!", Toast.LENGTH_LONG);
        // Inflamos um layout criado especificamente para a toast
        LayoutInflater inflater = getLayoutInflater();
        View toastLayout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.constraint_root_layout));
        toast.setView(toastLayout);

        TextView textView = toast.getView().findViewById(R.id.text_message);
        textView.setText("Você esta sem internet!");

        toast.show();


    }




}

