package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.wyble.procesagro.models.Tramite;


public class Call_Form1Activity extends ActionBarActivity {


    private Button form1_next;
    private EditText ica, finca, propietario, cedula_prop, telefono_prop, celular_prop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__form1);

        ica = (EditText) findViewById(R.id.ica);
        finca = (EditText) findViewById(R.id.finca);
        propietario = (EditText) findViewById(R.id.propietario);
        cedula_prop = (EditText) findViewById(R.id.cedula_prop);
        telefono_prop = (EditText) findViewById(R.id.telefono_prop);
        celular_prop = (EditText) findViewById(R.id.celular_prop);

        form1_next = (Button) findViewById(R.id.form1_next);
        form1_next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Tramite tramite = new Tramite();
                tramite.paso1(ica.getText().toString(),
                        finca.getText().toString(),
                        propietario.getText().toString(),
                        cedula_prop.getText().toString(),
                        telefono_prop.getText().toString(),
                        celular_prop.getText().toString());

                Intent intent = new Intent(Call_Form1Activity.this, Call_Form2Activity.class);
                intent.putExtra("TRAMITE_PASO1", tramite);
                startActivity(intent);
            }
        });

    }


}
