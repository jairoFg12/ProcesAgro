package com.wyble.procesagro;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.wyble.procesagro.models.Convocatoria;

import java.io.Serializable;
import java.util.ArrayList;

public class CallActivity extends ActionBarActivity {

    private ListView convListView;
    String idregistro;
    final Context context = this;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Serializable dataFromMainActivity = getIntent().getSerializableExtra("CONVOCATORIAS");
        ArrayList<Convocatoria> convocatorias = (ArrayList<Convocatoria>) dataFromMainActivity;

        convListView = (ListView) findViewById(R.id.convListView);
        ArrayAdapter<Convocatoria> arrayAdapter = new ArrayAdapter<Convocatoria>(this, R.layout.convocatoria_text_view, convocatorias);
        convListView.setAdapter(arrayAdapter);
    }

    private void listenerMethod() {
        convListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                idregistro = (String) parentView.getItemAtPosition(position);
                Log.d("id", idregistro);
                Toast.makeText(context, "You seleceted " + idregistro + ".", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });
    }
}
