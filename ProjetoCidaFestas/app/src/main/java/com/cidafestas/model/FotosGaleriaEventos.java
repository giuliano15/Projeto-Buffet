package com.cidafestas.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class FotosGaleriaEventos {



    // private int id;
    private String arquivo_nome;
    private String arquivo_descricao;
    private Bitmap arquivo_foto;
    private String dado;


    public FotosGaleriaEventos() {
    }




    public String getArquivo_nome() {
        return arquivo_nome;
    }

    public void setArquivo_nome(String arquivo_nome) {
        this.arquivo_nome = arquivo_nome;
    }

    public String getArquivo_descricao() {
        return arquivo_descricao;
    }

    public void setArquivo_descricao(String arquivo_descricao) {
        this.arquivo_descricao = arquivo_descricao;
    }

    public Bitmap getArquivo_foto() {
        return arquivo_foto;
    }

    public void setArquivo_foto(Bitmap arquivo_foto) {
        this.arquivo_foto = arquivo_foto;
    }

    public String getDado() {
        return dado;
    }

    public void setDado(String dado) {



        this.dado = dado;
        try {
            byte[] byteCode = Base64.decode(dado, Base64.DEFAULT);
            // this.imagem = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);

            int alt = 320;
            int larg = 320;

            Bitmap foto = BitmapFactory.decodeByteArray(byteCode, 0, byteCode.length);
            this.arquivo_foto = Bitmap.createScaledBitmap(foto, alt, larg, true);

        } catch (Exception e) {
            e.printStackTrace();
        }


        this.dado = dado;
    }


}

