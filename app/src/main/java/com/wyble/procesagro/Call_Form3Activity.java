package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wyble.procesagro.models.Tramite;

import java.io.Serializable;


public class Call_Form3Activity extends ActionBarActivity {

    private Button form3_next;
    private EditText nombre_solic, cedula_solic, telefono_solic, celular_solic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__form3);

        Serializable dataFromPaso2 = getIntent().getSerializableExtra("TRAMITE_PASO2");
        final Tramite tramite = (Tramite) dataFromPaso2;

        nombre_solic = (EditText) findViewById(R.id.nombre_solic);
        cedula_solic = (EditText) findViewById(R.id.cedula_solic);
        telefono_solic = (EditText) findViewById(R.id.telefono_solic);
        celular_solic = (EditText) findViewById(R.id.celular_solic);

        form3_next = (Button) findViewById(R.id.form3_next);
        form3_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tramite.paso3(nombre_solic.getText().toString(), cedula_solic.getText().toString(), telefono_solic.getText().toString(), celular_solic.getText().toString());
                Intent intent = new Intent(Call_Form3Activity.this, Call_Form4Activity.class);
                intent.putExtra("TRAMITE_PASO3", tramite);
                startActivity(intent);
            }
        });
    }
}
