package com.cidafestas.activitys;



import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
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


public class ActivitySite extends AppCompatActivity {

    WebView webView;

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        webView =findViewById(R.id.webView);
        webView.setWebChromeClient(new WebChromeClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            loadWebsite();
        }

        // Enable Javascript
        WebSettings webSettings =webView.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {


                //Abrir Whatsapp
                if (url.contains("api.whatsapp")) {
                    try {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);

                    } catch (ActivityNotFoundException ex) {

                        String MakeShortText = "Whatsapp have not been installed";

                        Toast.makeText(getApplication(), "" + MakeShortText, Toast.LENGTH_SHORT).show();


                    }

                }
                return super.shouldOverrideUrlLoading(view, url);
            }



        });

    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void onBackPressed() {
        //Botão BACK padrão do android



        if (webView.canGoBack() == true) {

            webView.goBack();

        } else {

            startActivity(new Intent(this, MainActivity.class));
            //Método para matar a activity e não deixa-lá indexada na pilhagem
            finishAffinity();
            return;

        }


    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void loadWebsite() {

        ConnectivityManager cm = (ConnectivityManager) getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        setDialog();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            webView.loadUrl("https://giulrodrigues13.wixsite.com/cidafestas");

            dialog.dismiss();
        }
        else{
            Intent semNet = new Intent(getApplicationContext(),SemInternet.class);
            startActivity(semNet);

            if (webView.canGoBack()) {
                dialog.dismiss();


                onBackPressed();

            }





        }

    }
    public void voltar() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);


    }
    public void setDialog() {





        dialog = new SpotsDialog.Builder()
                .setContext(this)
                .setMessage("Carregando...")
                .setCancelable(false)
                .build();
        dialog.show();

    }

}
