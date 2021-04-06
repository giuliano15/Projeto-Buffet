package com.cidafestas.activitys;



import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;



import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Toast;

import com.cidafestas.R;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import dmax.dialog.SpotsDialog;

public class ActivityFotos extends AppCompatActivity {

    WebView webviewFotos;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);

        //webview fotos
        webviewFotos =findViewById(R.id.webViewFotos);
        webviewFotos.setWebChromeClient(new WebChromeClient());
        loadWebsite();

        WebSettings webSettings =webviewFotos.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webviewFotos.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {


                //Abrir Whatsapp
                if (url.contains("api.whatsapp")) {
                    try {
                        Intent it = new Intent(Intent.ACTION_VIEW);
                        it.setData(Uri.parse(url));
                        startActivity(it);

                    } catch (android.content.ActivityNotFoundException ex) {

                        String MakeShortText = "Whatsapp have not been installed";

                        Toast.makeText(getApplication(), "" + MakeShortText, Toast.LENGTH_SHORT).show();


                    }

                }
                return super.shouldOverrideUrlLoading(view, url);
            }



        });


    }

    private void loadWebsite() {
       //Verifica conexão com internet
        ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        setDialog();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            webviewFotos.loadUrl("https://giulrodrigues13.wixsite.com/cidafestas/galeria");

            dialog.dismiss();
        }
        else{
            //Caso nao tenha conexao abre Activity SemInternet
            Intent semNet = new Intent(getApplicationContext(),SemInternet.class);
            startActivity(semNet);

            if ( webviewFotos.canGoBack()) {
                dialog.dismiss();


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    onBackPressed();
                }

            }

        }

    }
    public void setDialog() {

        dialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Carregando...")
                .setCancelable(false)
                .build();
        dialog.show();

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    //Botão BACK padrão do android
    public void onBackPressed() {

        if (webviewFotos.canGoBack() == true) {

            startActivity(new Intent(this, MainActivity.class));
            finishAffinity();

        } else {

            startActivity(new Intent(this, MainActivity.class));
            //Método para matar a activity e não deixa-lá indexada na pilhagem
            finishAffinity();
            return;

        }


    }
}
