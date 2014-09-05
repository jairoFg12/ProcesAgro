package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;

import android.widget.Button;


public class MainActivity extends ActionBarActivity{
    Button callView1;
    Button callView2;
    Button callView3;
    Button callView4;
    Button callView5;
    Button callView6;
    Button callView7;
    Button callView8;
    Button callView9;
    Button callView10;

    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callView1= (Button) findViewById(R.id.row1_button1);
        callView2= (Button) findViewById(R.id.row1_button2);
        callView3= (Button) findViewById(R.id.row2_button1);
        callView4= (Button) findViewById(R.id.row2_button2);

        callView5= (Button) findViewById(R.id.row3_button1);
        callView6= (Button) findViewById(R.id.row2_button2);

        callView7= (Button) findViewById(R.id.row2_button2);
        callView8= (Button) findViewById(R.id.row2_button2);

        callView9= (Button) findViewById(R.id.row2_button2);
        callView10= (Button) findViewById(R.id.row2_button2);

        callView1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 1");
                String url1= "http://www.google.com";
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("URL_PARAMETER", url1);
                startActivity(intent);
            }
        });

        callView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 2");
                String url2= "http://www.siembra.gov.co/";
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("URL_PARAMETER", url2);
                startActivity(intent);
            }
        });

        callView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 3");
                String url3= "http://www.siembra.gov.co/";
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("URL_PARAMETER", url3);
                startActivity(intent);
            }
        });

        callView4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 4");
                String url4= "http://www.corpoica.org.co/";
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("URL_PARAMETER", url4);
                startActivity(intent);
            }
        });


    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
