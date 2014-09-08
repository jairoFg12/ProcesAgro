package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wyble.procesagro.models.Tramite;

import java.io.Serializable;


public class Call_Form2Activity extends ActionBarActivity {

    private Button form2_next;
    private EditText municipio, departamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__form2);

        Serializable dataFromPaso1 = getIntent().getSerializableExtra("TRAMITE_PASO1");
        final Tramite tramite = (Tramite) dataFromPaso1;

        municipio = (EditText) findViewById(R.id.municipio);
        departamento = (EditText) findViewById(R.id.departamento);

        form2_next = (Button) findViewById(R.id.form2_next);
        form2_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tramite.paso2(municipio.getText().toString(), departamento.getText().toString());
                Intent intent = new Intent(Call_Form2Activity.this, Call_Form3Activity.class);
                intent.putExtra("TRAMITE_PASO2", tramite);
                startActivity(intent);
            }
        });

    }
}
