package com.wyble.procesagro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.wyble.procesagro.models.Convocatoria;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;


public class ConvDetalle extends ActionBarActivity {

    private TextView tituloConv;
    private TextView descConv;
    private Button linkUrl;
    private Button facebookBtn;
    private Button twitterBtn;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv_detalle);

        Serializable dataFromCallActivity = getIntent().getSerializableExtra("CONVOCATORIA_ITEM");
        final Convocatoria convocatoria = (Convocatoria) dataFromCallActivity;

        tituloConv = (TextView) findViewById(R.id.tituloConv);
        descConv = (TextView) findViewById(R.id.descConv);
        linkUrl = (Button) findViewById(R.id.linkUrl);
        facebookBtn = (Button) findViewById(R.id.facebookBtn);
        twitterBtn = (Button) findViewById(R.id.twitterBtn);

        getActionBar().setTitle(convocatoria.getTitulo());
        tituloConv.setText(convocatoria.getTitulo());
        descConv.setText(convocatoria.getDescripcionLarga());

        linkUrl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ConvDetalle.this, WebViewActivity.class);
                intent.putExtra("URL_PARAMETER", convocatoria.getUrl());
                startActivity(intent);
            }
        });

        facebookBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        twitterBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}
