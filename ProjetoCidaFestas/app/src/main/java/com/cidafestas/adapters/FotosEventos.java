package com.cidafestas.adapters;



public class FotosEventos {
    private String TituloEvento;
    private int FotoEvento;

    public FotosEventos(String TituloEvento , int FotoEvento){
        this.TituloEvento = TituloEvento;
        this.FotoEvento = FotoEvento;

    }



    public String getTituloEvento() {
        return TituloEvento;
    }

    public void setTituloEvento(String tituloEvento) {
        TituloEvento = tituloEvento;
    }

    public int getFotoEvento() {
        return FotoEvento;
    }

    public void setFotoEvento(int fotoEvento) {
        FotoEvento = fotoEvento;
    }
}
