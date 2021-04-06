package com.cidafestas.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cidafestas.R;
import com.cidafestas.activitys.FotosCardapioMysql;
import com.cidafestas.model.FotosCardapio;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class FotosCardapioAdapter extends RecyclerView.Adapter<FotosCardapioAdapter.FotosCardapioHolder> {

    private Context mContext;

    List<FotosCardapio> fotosCardapioList;

    public FotosCardapioAdapter(FotosCardapioMysql fotosCardapioMysql, List<FotosCardapio> fotosCardapioList){

        this.fotosCardapioList = fotosCardapioList;
    }




    @NonNull
    @Override
    public FotosCardapioHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gradient_java, parent, false);
        RecyclerView.LayoutParams layoutParams =
                new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        vista.setLayoutParams(layoutParams);
        return new FotosCardapioHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull FotosCardapioHolder holder, final int position) {
        Context ctx = null;
        FotosCardapio fotosCardapio = fotosCardapioList.get(position);







        holder.textViewTitulo.setText(fotosCardapioList.get(position).getArquivo_titulo());
        //holder.textViewTitle.setVisibility(View.INVISIBLE);
        holder.textViewDescricao.setText(fotosCardapioList.get(position).getArquivo_descricao());
        holder.textViewDescricao.setVisibility(View.INVISIBLE);


        if(fotosCardapioList.get(position).getArquivo_conteudo()!=null){
            holder.imageView.setImageBitmap(fotosCardapioList.get(position).getArquivo_conteudo());

            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                   // Toast.makeText(v.getContext(), " posição " + position, Toast.LENGTH_SHORT).show();

                }
            });
        }else{
            holder.imageView.setImageResource(R.drawable.sem_foto);
        }

    }





    @Override
    public int getItemCount() {
        return fotosCardapioList.size();
    }

    public class FotosCardapioHolder extends RecyclerView.ViewHolder {

        TextView textViewTitulo, textViewDescricao;
        ImageView imageView;



        public FotosCardapioHolder(View itemView) {
            super(itemView);

            textViewTitulo = (TextView) itemView.findViewById(R.id.text_car_model);
            textViewDescricao =(TextView) itemView.findViewById(R.id.text_view_details);
            imageView = (ImageView) itemView.findViewById(R.id.img_detail_cardapio);
        }
    }
}
