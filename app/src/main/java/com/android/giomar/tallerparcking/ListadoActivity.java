package com.android.giomar.tallerparcking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListadoActivity extends AppCompatActivity {


    TextView txtv;
    ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        final Intent list = getIntent();
        Bundle bundle = list.getExtras();

        lista = (ListView)findViewById(R.id.lv_lista);
        txtv = (TextView) findViewById(R.id.textView2);


        String cContS = bundle.getString("LISTC");
        int cContI = Integer.parseInt(cContS);


        ArrayList<String> arrayList = new ArrayList<>();


        for(int i=0; i<=cContI; i++){

            arrayList.add(bundle.getString("LIST"+i));

        }

        VehiculosArrayAdapter adapter = new VehiculosArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        lista.setAdapter(adapter);


    }
}
