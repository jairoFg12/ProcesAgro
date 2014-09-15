package com.wyble.procesagro;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class DealsActivity extends ActionBarActivity {
    private TextView title;
    private TextView description;
    private ListView steps;
    Context context= this;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        steps= (ListView) findViewById(R.id.stepsListView);

        steps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DealsActivity.this, StepsDetailsActivity.class);
                Toast.makeText(context, "Item accionado", Toast.LENGTH_SHORT);
                    //Convocatoria item = convocatorias.get(position);
                    //intent.putExtra("CONVOCATORIA_ITEM", item);
                startActivity(intent);
            }
        });
    }
}
