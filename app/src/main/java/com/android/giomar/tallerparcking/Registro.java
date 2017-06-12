package com.android.giomar.tallerparcking;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Registro extends AppCompatActivity {



    TextView test, tests;
    EditText tipo, placa, hora_i;
    Button save, list, salida, next;

    vehiculo[] m = new vehiculo[99];
    int cont=0;
    int cCont=0;
    String sHs="";

    String comp[]={

            "Moto","MOTO","moto",
            "Carro","CARRO","carro"
    };

    int compH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        tipo = (EditText)findViewById(R.id.edt_tipo);
        placa = (EditText)findViewById(R.id.edt_placa);
        hora_i = (EditText)findViewById(R.id.edt_hi);
        save = (Button) findViewById(R.id.btn_save);
        test = (TextView) findViewById(R.id.tv_test);
        next = (Button) findViewById(R.id.btn_next);
        salida = (Button) findViewById(R.id.btn_s);
        list = (Button) findViewById(R.id.btn_lista);


        next.setEnabled(false);
        salida.setEnabled(false);
        list.setEnabled(false);



        /*if (!sHs.equals("")) {

            Intent BTB = getIntent();
            Bundle bBack = BTB.getExtras();

            sHs = bBack.getString("BACK");
            m[cont].setHora_s(sHs);

        }*/

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                compH = Integer.parseInt(hora_i.getText().toString());

                if(tipo.getText().toString().equals("")||placa.getText().toString().equals("")||hora_i.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"Ingrese la información completa", Toast.LENGTH_SHORT).show();
                    next.setEnabled(false);
                }else {

                    if ((tipo.getText().toString().equals(comp[0])||tipo.getText().toString().equals(comp[1])||tipo.getText().toString().equals(comp[2])||
                         tipo.getText().toString().equals(comp[3])||tipo.getText().toString().equals(comp[4])||tipo.getText().toString().equals(comp[5]))&&
                            (compH<24)){


                    m[cont] = new vehiculo();

                    //Guardar datos
                    m[cont].setTipo(tipo.getText().toString());
                    m[cont].setPlaca(placa.getText().toString());
                    m[cont].setHora_i(hora_i.getText().toString());

                    test.setText("Vehículo - " + (cont + 1));

                    next.setEnabled(true);
                    salida.setEnabled(true);
                        list.setEnabled(true);

                    }else{

                        Toast.makeText(getApplicationContext(),"Valores aceptados: TIPO: Moto/moto/MOTO/Carro/carro/CARRO\nHORA: Menor a 24hrs", Toast.LENGTH_SHORT).show();

                    }

                }

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cont++;
                salida.setEnabled(false);

                tipo.setText("");
                placa.setText("");
                hora_i.setText("");

                test.setText("Vehículo - "+(cont+1));


                next.setEnabled(false);
                save.setEnabled(true);


            }

        });

        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Registro.this, SalidaActivity.class);
                intent.putExtra("TIPO",m[cont].getTipo());
                intent.putExtra("PLACA",m[cont].getPlaca());
                intent.putExtra("HORAI", m[cont].getHora_i());

                String sC = String.valueOf(cont);
                intent.putExtra("POS", sC);
                startActivity(intent);


                save.setEnabled(false);
                salida.setEnabled(false);

            }

        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent listaIntent = new Intent(Registro.this, ListadoActivity.class);

                String asig;


               for(int i=0; i<=cont; i++){

                    if(m[i].getHora_s().equals("")){

                        Toast.makeText(getApplicationContext(),"Ingrese a for", Toast.LENGTH_SHORT).show();

                        asig = m[i].getPlaca()+"-"+m[i].getTipo()+"-"+m[i].getHora_i();

                        listaIntent.putExtra("LIST"+cCont, asig);


                        cCont++;

                    }
                }

                Toast.makeText(getApplicationContext(),"Ingrese a for", Toast.LENGTH_SHORT).show();
                String d = String.valueOf(cCont);
                listaIntent.putExtra("LISTC", d);
                startActivity(listaIntent);


            }

        });







    }


}



