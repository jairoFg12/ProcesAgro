package com.wyble.procesagro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wyble.procesagro.models.Tramite;

import java.io.Serializable;


public class Call_Form6Activity extends ActionBarActivity {

    private Button form6_next;
    private EditText primera_vez, nacimiento, compra_animales, perdida_din;
    Context context= this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__form6);

        Serializable dataFromPaso5 = getIntent().getSerializableExtra("TRAMITE_PASO5");
        final Tramite tramite = (Tramite) dataFromPaso5;

        primera_vez = (EditText) findViewById(R.id.primera_vez);
        nacimiento = (EditText) findViewById(R.id.nacimiento);
        compra_animales = (EditText) findViewById(R.id.compra_animales);
        perdida_din = (EditText) findViewById(R.id.perdida_din);

        form6_next = (Button) findViewById(R.id.form6_next);
        form6_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String primera_vez_v= primera_vez.getText().toString();
                final String nacimiento_v= nacimiento.getText().toString();
                final String compra_animales_v= compra_animales.getText().toString();
                final String perdida_din_v= perdida_din.getText().toString();
                if(primera_vez_v.equals("") || nacimiento_v.equals("")
                        || compra_animales_v.equals("") || perdida_din_v.equals("")){

                    Toast.makeText(context, "Todos los campos son requeridos.", Toast.LENGTH_SHORT).show();
                }else{
                    tramite.paso6(Integer.parseInt(primera_vez_v),
                            Integer.parseInt(nacimiento_v),
                            Integer.parseInt(compra_animales_v),
                            Integer.parseInt(perdida_din_v));
                    Intent intent = new Intent(Call_Form6Activity.this, CallFinishActivity.class);
                    intent.putExtra("TRAMITE_PASO6", tramite);
                    startActivity(intent);
                }
            }
        });
    }
}
