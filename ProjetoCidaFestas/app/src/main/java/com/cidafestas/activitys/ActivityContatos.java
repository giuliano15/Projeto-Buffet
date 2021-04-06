package com.cidafestas.activitys;



import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;


import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.cidafestas.R;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityContatos extends AppCompatActivity {

    WebView webviewFotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);



    }



    public void enviarZap(View view){

        openWhatsApp();

    }

    public void enviarEmail(View view){
        openGmail();

    }
    public void ligar(View view){
        call();
    }

    private void openGmail() {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("mailto:" + getResources().getString(R.string.emailId) + "?subject=" + getResources().getString(R.string.app_name) + " feedback"));
            startActivity(Intent.createChooser(intent, "E_mail"));
        } catch (ActivityNotFoundException e) {

        }

    }

    private void call() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + getResources().getString(R.string.contactNo)));
        startActivity(intent);
    }
    public void openWhatsApp(){
        try {

            // Replace with mobile phone number without +Sign or leading zeros.
            String toNumber = "5531987020851";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+toNumber +"&text="));
            startActivity(intent);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}