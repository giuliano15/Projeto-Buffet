package com.cidafestas.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cidafestas.R;

import com.cidafestas.activitys.GaleriaAlomocoFamiliar;
import com.cidafestas.activitys.GaleriaAniversario;
import com.cidafestas.activitys.GaleriaBatizado;
import com.cidafestas.activitys.GaleriaEventosCasamentos;
import com.cidafestas.activitys.GaleriaFestaFormatura;
import com.cidafestas.activitys.GaleriaFestaInfantil;
import com.cidafestas.activitys.GaleriaFestasCorporativas;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class FotosEventosAdapter extends RecyclerView.Adapter<FotosEventosAdapter.FotosEventosHolder> {

    public Context mContext ;
    public List<FotosEventos> fotosEventosList;

    public FotosEventosAdapter(Context mContext ,List<FotosEventos> fotosEventosList) {

        this.mContext = mContext;
        this.fotosEventosList = fotosEventosList;

    }




    public FotosEventosHolder onCreateViewHolder( ViewGroup parent, int viewType) {



        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gradient_java, parent, false);
        RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        vista.setLayoutParams(layoutParams);

//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        View view = inflater.inflate(R.layout.item_gradient_java, null);
        return new FotosEventosHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull FotosEventosHolder holder, final int position) {

        holder.textViewDescricao.setText(fotosEventosList.get(position).getTituloEvento());


        holder.imageView.setImageResource(fotosEventosList.get(position).getFotoEvento());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(mContext, "position" + position, Toast.LENGTH_SHORT).show();
                if (position == 0){
                    Intent casamento = new Intent(mContext , GaleriaEventosCasamentos.class);
                   mContext.startActivity(casamento);
                }
                if(position == 1){
                    Intent aniversario = new Intent(mContext , GaleriaAniversario.class);
                    mContext.startActivity(aniversario);

                }

                if(position == 2){
                    Intent corporativa = new Intent(mContext , GaleriaFestasCorporativas.class);
                    mContext.startActivity(corporativa);

                }

                if(position == 3){
                    Intent infantil = new Intent(mContext , GaleriaFestaInfantil.class);
                    mContext.startActivity(infantil);

                }

                if(position == 4){
                    Intent formatura = new Intent(mContext , GaleriaFestaFormatura.class);
                    mContext.startActivity(formatura);

                }

                if(position == 5){
                    Intent batizado = new Intent(mContext , GaleriaBatizado.class);
                    mContext.startActivity(batizado);

                }

                if(position == 6){
                    Intent almoco = new Intent(mContext , GaleriaAlomocoFamiliar.class);
                    mContext.startActivity(almoco);

                }
            }
        });

        holder.textViewFlag.setVisibility(View.INVISIBLE);
        holder.textViewTitulo.setVisibility(View.INVISIBLE);

    }

    @Override
    public int getItemCount() {
        return fotosEventosList.size();
    }

    public static class FotosEventosHolder extends RecyclerView.ViewHolder {

        TextView textViewTitulo, textViewDescricao ,textViewFlag;
        ImageView imageView;
        public FotosEventosHolder(View itemView) {
            super(itemView);

            textViewDescricao = (TextView) itemView.findViewById(R.id.text_car_model);
            textViewTitulo = (TextView) itemView.findViewById(R.id.text_view_details);
            imageView = (ImageView) itemView.findViewById(R.id.img_detail_cardapio);
            textViewFlag = (TextView) itemView.findViewById(R.id.newFlagTv);


        }
    }



    // private Context mContext ;
   // List<FotosEventos> fotosEventosList;





}