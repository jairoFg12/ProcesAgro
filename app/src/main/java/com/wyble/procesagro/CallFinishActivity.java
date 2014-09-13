package com.wyble.procesagro;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.wyble.procesagro.models.Tramite;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;


public class CallFinishActivity extends ActionBarActivity implements View.OnClickListener{

    private EditText justificacion;
    private CheckBox terminos;
    private Button finish;
    private Tramite tramite;
    private Context context= this;

    private static final String TRAMITE_URL = "http://181.41.200.108/procesAgroWeb/web/app.php/crearFormulario/";

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

        ArrayList<String> fields = new ArrayList();
        fields.add(tramite.getIca());
        fields.add(tramite.getNombreFinca());
        fields.add(tramite.getNombrePropietario());
        fields.add(tramite.getCedulaPropietario());
        fields.add(tramite.getFijoPropietario());
        fields.add(tramite.getCelularPropietario());
        fields.add(tramite.getMunicipio());
        fields.add(tramite.getDepartamento());
        fields.add(tramite.getNombreSolicitante());
        fields.add(tramite.getCedulaSolicitante());
        fields.add(tramite.getFijoSolicitante());
        fields.add(tramite.getCelularSolicitante());
        fields.add(Integer.toString(tramite.getMenor1Bovinos()));
        fields.add(Integer.toString(tramite.getEntre12Bovinos()));
        fields.add(Integer.toString(tramite.getEntre23Bovinos()));
        fields.add(Integer.toString(tramite.getMayores3Bovinos()));
        fields.add(Integer.toString(tramite.getMenor1Bufalino()));
        fields.add(Integer.toString(tramite.getEntre12Bufalino()));
        fields.add(Integer.toString(tramite.getEntre23Bufalino()));
        fields.add(Integer.toString(tramite.getMayor3Bufalino()));
        fields.add(Integer.toString(tramite.getPrimeraVez()));
        fields.add(Integer.toString(tramite.getNacimiento()));
        fields.add(Integer.toString(tramite.getCompra()));
        fields.add(Integer.toString(tramite.getPerdidaDIN()));

        String complete_string = this.TRAMITE_URL + this.join(fields, "/");
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(complete_string);

        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) {
                Toast.makeText(context, "Información enviada...", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Error, intente nuevamente...", Toast.LENGTH_SHORT).show();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Intent goToHome= new Intent(CallFinishActivity.this, MainActivity.class);
        startActivity(goToHome);
    }

    private String join(ArrayList<String> r, String delimiter) {
        if(r == null || r.size() == 0 ){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i, len = r.size() - 1;
        for (i = 0; i < len; i++){
            sb.append(r.get(i) + delimiter);
        }
        return sb.toString() + r.get(i);
    }
}
