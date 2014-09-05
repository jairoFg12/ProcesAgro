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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callView1= (Button) findViewById(R.id.row1_button1);//row1
        callView2= (Button) findViewById(R.id.row1_button2);//row1
        callView3= (Button) findViewById(R.id.row2_button1);//row2
        callView4= (Button) findViewById(R.id.row2_button2);//row2
        callView5= (Button) findViewById(R.id.row3_button1);//row3
        callView6= (Button) findViewById(R.id.row4_button1);//row4
        callView7= (Button) findViewById(R.id.row5_button1);//row5
        callView8= (Button) findViewById(R.id.row5_button2);//row5
        callView9= (Button) findViewById(R.id.row6_button1);//row6
        callView10= (Button) findViewById(R.id.row6_button2);//row6

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

        callView5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 5");
                Intent intentToCall = new Intent(MainActivity.this, CallActivity.class);
                startActivity(intentToCall);
            }
        });

        callView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 6");
                Intent intentToTransact = new Intent(MainActivity.this, TransactActivity.class);
                startActivity(intentToTransact);
            }
        });

        callView7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 7");
                Intent intentToDeals1 = new Intent(MainActivity.this, DealsActivity.class);
                startActivity(intentToDeals1);
            }
        });

        callView8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 8");
                Intent intentToDeals2 = new Intent(MainActivity.this, DealsActivity.class);
                startActivity(intentToDeals2);
            }
        });

        callView9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 9");
                Intent intentToDeals3 = new Intent(MainActivity.this, DealsActivity.class);
                startActivity(intentToDeals3);
            }
        });

        callView10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 10");
                Intent intentToDeals4 = new Intent(MainActivity.this, DealsActivity.class);
                startActivity(intentToDeals4);
            }
        });
    }
}
