package com.cidafestas.activitys;



import android.os.Bundle;


import com.cidafestas.R;

import com.cidafestas.adapters.FotosEventos;
import com.cidafestas.adapters.FotosEventosAdapter;


import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ActivityFotosEventos extends AppCompatActivity {

    List<FotosEventos> listFotosEventos ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos_eventos);

        listFotosEventos = new ArrayList<>();
        listFotosEventos.add(new FotosEventos("Casamentos",R.drawable.casamento));
        listFotosEventos.add(new FotosEventos("Aniversarios",R.drawable.aniversario));
        listFotosEventos.add(new FotosEventos("Festas corporativas",R.drawable.festa_corporativa));
        listFotosEventos.add(new FotosEventos("Festa Infantil",R.drawable.festa_infantil));
        listFotosEventos.add(new FotosEventos("Festa Formatura",R.drawable.festa_formatura));
        listFotosEventos.add(new FotosEventos("Batizado",R.drawable.festa_batizado));
        listFotosEventos.add(new FotosEventos("Almoço Familiar",R.drawable.almoco_familia));

        //Carrega lista da activity FotosEventos
        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerImagemFotosEventos);
        FotosEventosAdapter myAdapter = new FotosEventosAdapter(this,listFotosEventos);
        myrv.setLayoutManager(new GridLayoutManager(this,1));
        myrv.setAdapter(myAdapter);


    }
}
