package com.wyble.procesagro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.wyble.procesagro.models.Tramite;

import java.io.Serializable;


public class CallFinishActivity extends ActionBarActivity implements View.OnClickListener{

    EditText justificacion;
    CheckBox terminos;
    Button finish;
    Tramite tramite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_finish);

        Serializable dataFromPaso6 = getIntent().getSerializableExtra("TRAMITE_PASO6");
        tramite = (Tramite) dataFromPaso6;

        justificacion = (EditText) findViewById(R.id.justificacion);
        terminos = (CheckBox) findViewById(R.id.terminos);

        finish= (Button) findViewById(R.id.endButt);
        finish.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        tramite.paso7(justificacion.getText().toString(), terminos.isChecked());
        Log.d(CallFinishActivity.class.getName(), "On CLICK, the music is the answer!");
    }
}
