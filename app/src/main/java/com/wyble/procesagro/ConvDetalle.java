package com.wyble.procesagro;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
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

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


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
                share("facebook", null, convocatoria.getUrl());
            }
        });

        twitterBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                share("twitter", null, convocatoria.getUrl());
            }
        });

    }

    private void share(String nameApp, String imagePath,String message) {
        try
        {
            List<Intent> targetedShareIntents = new ArrayList<Intent>();
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("image/jpeg");
            List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(share, 0);
            if (!resInfo.isEmpty()){
                for (ResolveInfo info : resInfo) {
                    Intent targetedShare = new Intent(android.content.Intent.ACTION_SEND);
                    targetedShare.setType("image/jpeg"); // put here your mime type
                    if (info.activityInfo.packageName.toLowerCase().contains(nameApp) || info.activityInfo.name.toLowerCase().contains(nameApp)) {
                        targetedShare.putExtra(Intent.EXTRA_SUBJECT, "Sample Photo");
                        targetedShare.putExtra(Intent.EXTRA_TEXT,message);
                        targetedShare.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(imagePath)) );
                        targetedShare.setPackage(info.activityInfo.packageName);
                        targetedShareIntents.add(targetedShare);
                    }
                }
                Intent chooserIntent = Intent.createChooser(targetedShareIntents.remove(0), "Select app to share");
                chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetedShareIntents.toArray(new Parcelable[]{}));
                startActivity(chooserIntent);
            }
        }

        catch(Exception e){
            Log.v("VM","Exception while sending image on" + nameApp + " "+  e.getMessage());
        }
    }
}
