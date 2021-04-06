package com.cidafestas.activitys;



import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;

import android.view.View;

import android.widget.Toast;
import androidx.gridlayout.widget.GridLayout;


import com.cidafestas.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {

    androidx.gridlayout.widget.GridLayout mainGrid;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        androidx.gridlayout.widget.GridLayout        mainGrid = (androidx.gridlayout.widget.GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
        //setToggleEvent(mainGrid);
    }

    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color

                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#EF70A9"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setSingleEvent(final GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {



                    //usando switch
                    switch(cardView.getId()){

                        case R.id.site:

                            Intent intent5 = new Intent(MainActivity.this, ActivitySite.class);
                            startActivity(intent5);
                            break;

                        case R.id.eventos:

                            Intent intent2 = new Intent(MainActivity.this, ActivityFotosEventos.class);
                            startActivity(intent2);
                            break;

                        case R.id.cardapio:

                            Intent intent3 = new Intent(MainActivity.this,FotosCardapioMysql.class);
                            startActivity(intent3);
                            break;

                        case R.id.fotos:

                            Intent intent4 = new Intent(MainActivity.this, ActivityFotos.class);
                            startActivity(intent4);
                            break;

                        case R.id.serviços:

                            Intent intent1 = new Intent(MainActivity.this, ActivityAgenda.class);
                            startActivity(intent1);
                            break;//

                        case R.id.contatos:

                            Intent intent6 = new Intent(MainActivity.this, ActivityContatos.class);
                            startActivity(intent6);
                            break;

                        case R.id.orçamentos:

                            Intent intent7 = new Intent(MainActivity.this,ActivityOrcamentos.class);
                            startActivity(intent7);
                            break;

                        case R.id.sobre:

                            Intent intent8 = new Intent(MainActivity.this, ActivitySobre.class);
                            startActivity(intent8);
                            break;

                    }


                }
            });
        }
    }
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            voltar();
        } else {
            doubleBackToExitPressedOnce = true;

            Toast.makeText(this, "Pressione novamente para sair", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
    }

    public void voltar() {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
        finish();


    }
}
