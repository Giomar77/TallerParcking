package com.android.giomar.tallerparcking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SalidaActivity extends AppCompatActivity {

    EditText hora_s;
    Button salva, back;
    TextView tvPrecio, cPlaca;
    long pm= 1200;
    long pc= 4600;


    String cTipo, cHorai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.salida);

        final Intent intent = getIntent();
        Bundle b = intent.getExtras();


        cPlaca = (TextView) findViewById(R.id.tv_placa);
        hora_s = (EditText) findViewById(R.id.edt_hs);
        salva = (Button)findViewById(R.id.btn_salva);
        back = (Button)findViewById(R.id.btn_back);
        tvPrecio = (TextView) findViewById(R.id.tv_precio);

        cPlaca.setText(getIntent().getStringExtra("PLACA"));


        cTipo = b.getString("TIPO");
        cHorai = b.getString("HORAI");
        final String sCont = b.getString("POS");
        final int iCont = Integer.parseInt(sCont);



        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                long lPrice;
                int  i,s;
                String sPrice;

                i = Integer.parseInt(cHorai);
                s = Integer.parseInt(hora_s.getText().toString());

                lPrice = s-i;

                if (s>i){

                if(cTipo.equals("Moto")||cTipo.equals("moto")||cTipo.equals("MOTO")){


                    lPrice = lPrice*pm;
                    sPrice = "$"+Long.toString(lPrice);

                    tvPrecio.setText(sPrice);

                }else {

                    lPrice = lPrice*pc;
                    sPrice = "$"+Long.toString(lPrice);

                    tvPrecio.setText(sPrice);
                }

                }else{

                    Toast.makeText(getApplicationContext(),"La hora de ingreso supera a la de salida", Toast.LENGTH_SHORT).show();
                }

            }
        });


       /* back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intBack = new Intent(SalidaActivity.this, Registro.class);
                intBack.putExtra("BACK", hora_s.getText().toString());
                startActivity(intBack);

            }
        });*/

    }
}
