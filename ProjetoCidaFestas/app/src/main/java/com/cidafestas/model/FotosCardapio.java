package com.cidafestas.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.Serializable;

public class FotosCardapio implements Serializable {

    // private int id;
    private String arquivo_nome;
    private String arquivo_titulo;
    private String arquivo_tipo;
    private String arquivo_descricao;
    private Bitmap arquivo_conteudo;
    private String dado;

//    public FotosCardapio() {
//        this.arquivo_nome = arquivo_nome;
//        this.arquivo_titulo = arquivo_titulo;
//        this.arquivo_tipo = arquivo_tipo;
//        this.arquivo_descricao = arquivo_descricao;
//        this.arquivo_conteudo = arquivo_conteudo;
//        this.dado = dado;
//    }

   public FotosCardapio() {

    }

    public String getArquivo_nome() {
        return arquivo_nome;
    }

    public void setArquivo_nome(String arquivo_nome) {
        this.arquivo_nome = arquivo_nome;
    }

    public String getArquivo_titulo() {
        return arquivo_titulo;
    }

    public void setArquivo_titulo(String arquivo_titulo) {
        this.arquivo_titulo = arquivo_titulo;
    }

    public String getArquivo_tipo() {
        return arquivo_tipo;
    }

    public void setArquivo_tipo(String arquivo_tipo) {
        this.arquivo_tipo = arquivo_tipo;
    }

    public String getArquivo_descricao() {
        return arquivo_descricao;
    }

    public void setArquivo_descricao(String arquivo_descricao) {
        this.arquivo_descricao = arquivo_descricao;
    }

    public Bitmap getArquivo_conteudo() {
        return arquivo_conteudo;
    }

    public void setArquivo_conteudo(Bitmap arquivo_conteudo) {
        this.arquivo_conteudo = arquivo_conteudo;
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
            this.arquivo_conteudo = Bitmap.createScaledBitmap(foto, alt, larg, true);

        } catch (Exception e) {
            e.printStackTrace();
        }


        this.dado = dado;
    }


}