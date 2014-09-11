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


public class Call_Form1Activity extends ActionBarActivity {


    private Button form1_next;
    private EditText ica, finca, propietario, cedula_prop, telefono_prop, celular_prop;
    final Context context= this;

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
                final String ica_v = ica.getText().toString();
                final String finca_v = finca.getText().toString();
                final String propietario_v = propietario.getText().toString();
                final String cedula_prop_v = cedula_prop.getText().toString();
                final String telefono_prop_v = telefono_prop.getText().toString();
                final String celular_prop_v = celular_prop.getText().toString();

                //si todos los campos vacios
                if(ica_v.equals("") || finca_v.equals("") || propietario_v.equals("")
                        || cedula_prop_v.equals("") || telefono_prop_v.equals("") || celular_prop_v.equals("")) {

                    Toast.makeText(context, "Todos los campos son requeridos.", Toast.LENGTH_SHORT).show();
                }else{
                    Tramite tramite = new Tramite();
                            tramite.paso1(ica_v,
                                    finca_v,
                                    propietario_v,
                                    cedula_prop_v,
                                    telefono_prop_v,
                                    celular_prop_v);

                    Intent intent = new Intent(Call_Form1Activity.this, Call_Form2Activity.class);
                    intent.putExtra("TRAMITE_PASO1", tramite);
                    startActivity(intent);
                }
            }
        });
    }
}
