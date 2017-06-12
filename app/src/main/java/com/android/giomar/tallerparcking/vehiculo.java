package com.android.giomar.tallerparcking;

import java.io.Serializable;

/**
 * Created by Giomar on 6/06/2017.
 */

public class vehiculo implements Serializable{

    private String tipo="";
    private String placa="";
    private String hora_i="";
    private String hora_s="";
    private String price="";



    public void setTipo(String t) {

        this.tipo = t;
    }
    public void setPlaca(String pl) {
        this.placa = pl;
    }
    public void setHora_i(String horai) {
        this.hora_i = horai;
    }
    public void setHora_s(String horas) {
        this.hora_s = horas;
    }
    public void setPrice(String pr) {
        this.price = pr;
    }

    public String getTipo() {
        return tipo;
    }
    public String getPlaca() {
        return placa;
    }
    public String getHora_i() {
        return hora_i;
    }
    public String getHora_s() {
        return hora_s;
    }
    public String getPrice() {
        return price;
    }

}