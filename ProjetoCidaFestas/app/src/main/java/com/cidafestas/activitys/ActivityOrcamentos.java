package com.cidafestas.activitys;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import android.net.ConnectivityManager;
import android.os.Bundle;

import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cidafestas.R;
import com.cidafestas.entidades.MySingleton;

import org.json.JSONObject;

import androidx.appcompat.app.AppCompatActivity;
import dmax.dialog.SpotsDialog;

public class ActivityOrcamentos extends AppCompatActivity {

    WebView webviewOrcamentos;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamentos);

       //Inicia Dialog
        setDialog();
        carregarWEBService();
    }
    private void carregarWEBService() {

       //Detecta se ha conexão com internet
        ConnectivityManager con_manager = (ConnectivityManager)
                getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected()) {


            webviewOrcamentos =findViewById(R.id.webViewOrcamentos);
            webviewOrcamentos.setWebChromeClient(new WebChromeClient());
           //carrega script de envio de email
            webviewOrcamentos.loadUrl("https://giulrdeveloper.com/enviar_email/contato.php");

            WebSettings webSettings =webviewOrcamentos.getSettings();
            webSettings.setJavaScriptEnabled(true);



        } else {
            Intent it = new Intent(getApplicationContext(),SemInternet.class);
            startActivity(it);
            Toast.makeText(this, "sem internet", Toast.LENGTH_SHORT).show();


        }
        //fecha Dialog
        dialog.dismiss();
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

