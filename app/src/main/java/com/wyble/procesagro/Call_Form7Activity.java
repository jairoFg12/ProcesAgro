package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;

import com.wyble.procesagro.models.Tramite;

import java.io.Serializable;


public class Call_Form7Activity extends ActionBarActivity {

    Button enviar;
    private EditText justificacion;
    private CheckBox terminos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__form7);

        //Serializable dataFromPaso6 = getIntent().getSerializableExtra("TRAMITE_PASO6");
        //final Tramite tramite = (Tramite) dataFromPaso6;

        //justificacion = (EditText) findViewById(R.id.justificacion);
        //terminos = (CheckBox) findViewById(R.id.terminos);

        enviar = (Button) findViewById(R.id.finish_butt);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("->", "el click");
                //tramite.paso7(justificacion.getText().toString(), Boolean.parseBoolean(terminos.getText().toString()));
                //Log.d(Call_Form7Activity.class.getName(), terminos.getText().toString());
            }
        });
    }
}
