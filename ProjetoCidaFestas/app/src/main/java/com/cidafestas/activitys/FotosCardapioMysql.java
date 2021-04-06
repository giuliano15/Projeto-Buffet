package com.cidafestas.activitys;



import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;


import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cidafestas.R;
import com.cidafestas.adapters.FotosCardapioAdapter;
import com.cidafestas.entidades.MySingleton;
import com.cidafestas.entidades.RecyclerItemClickListener;
import com.cidafestas.model.FotosCardapio;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import dmax.dialog.SpotsDialog;

public class FotosCardapioMysql extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener {


    private List<FotosCardapio> fotosCardapioList = new ArrayList<>();


    private AlertDialog dialog;


    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    // private static final String URL_PRODUCTS = "http://192.168.2.3/consultarLista.php";


    private FotosCardapioAdapter fotosCardapioAdapter;
    private RecyclerView recyclerView;

   // RecyclerView recyclerView;

    JsonObjectRequest jsonObjectReq;

    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos_cardapio_mysql);

        DetectConnection detectConnection = new DetectConnection();


        //getting the recyclerview from xml


        fotosCardapioList = new ArrayList<>();

        recyclerView = findViewById(R.id.idRecyclerImagem);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


         carregarWEBService();


        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


                FotosCardapio fotoSelecionada = fotosCardapioList.get(position);
                String img = BitMapToString(fotoSelecionada.getArquivo_conteudo());
                String txt  = (fotoSelecionada.getArquivo_descricao());


                //Pegando foto Bitmap da lista de fotos
                Bitmap fotoBmp =((Bitmap)fotoSelecionada.getArquivo_conteudo());




                //Enviando foto Bitmap para ActivityDetails
                Intent it = new Intent(FotosCardapioMysql.this,ActivityDetails.class);
                it.putExtra("foto", fotoBmp);
                it.putExtra("textoDescricao",txt);
                startActivity(it);




            }

            @Override
            public void onLongItemClick(View view, int position) {

                Toast.makeText(FotosCardapioMysql.this, "teste click longo", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));

    }


    private void carregarWEBService() {

        ConnectivityManager con_manager = (ConnectivityManager)
                getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (con_manager.getActiveNetworkInfo() != null
                && con_manager.getActiveNetworkInfo().isAvailable()
                && con_manager.getActiveNetworkInfo().isConnected()) {

            setDialog();


        } else {
            Toast.makeText(this, "sem internet", Toast.LENGTH_SHORT).show();


        }


        String ip = getString(R.string.ip);
        String url = ip + "/consultarLista.php";

        jsonObjectReq = new JsonObjectRequest(Request.Method.GET, url, null, (Response.Listener<JSONObject>) this, this);
        MySingleton.getInstance(this).addToRequestQueue(jsonObjectReq);

    }



    /*
     * Creating a String Request
     * The request type is GET defined by first parameter
     * The URL is defined in the second parameter
     * Then we have a Response Listener and a Error Listener
     * In response listener we will get the JSON response as a String
     * */


    @Override
    public void onResponse(JSONObject response) {


      FotosCardapio fotosCardapio = null;
        JSONArray json;
        json = response.optJSONArray("imagens");


        try {
            for (int i = 0; i < json.length(); i++) {
                fotosCardapio = new FotosCardapio();
                JSONObject jsonObject = null;
                jsonObject = json.getJSONObject(i);


                fotosCardapio.setArquivo_nome(jsonObject.optString("arquivo_nome"));
                fotosCardapio.setArquivo_titulo(jsonObject.optString("arquivo_titulo"));
                fotosCardapio.setArquivo_tipo(jsonObject.optString("arquivo_tipo"));
                fotosCardapio.setDado(jsonObject.optString("arquivo_conteudo"));
                fotosCardapio.setArquivo_descricao(jsonObject.optString("arquivo_descricao"));
                fotosCardapioList.add(fotosCardapio);

                dialog.dismiss();
            }


            fotosCardapioAdapter = new FotosCardapioAdapter(FotosCardapioMysql.this, fotosCardapioList);
            recyclerView.setAdapter(fotosCardapioAdapter);

        } catch (JSONException e) {
            e.printStackTrace();


            //dialog.dismiss();


            Toast.makeText(this, "Não foi possível listar as fotos " + e, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), FotosCardapioMysql.class);
            startActivity(intent);


        }


    }


    @Override
    public void onErrorResponse(VolleyError error) {


           Toast.makeText(this, "Não foi possível listar os membros" + error.toString(), Toast.LENGTH_LONG).show();
           Intent intent = new Intent(getApplicationContext(), SemInternet.class);
           startActivity(intent);


        Log.i("ERROR", error.toString());
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public String BitMapToString(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] b = baos.toByteArray();
        String temp = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.FROYO) {
            temp = Base64.encodeToString(b, Base64.DEFAULT);
        }
        return temp;
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