package com.wyble.procesagro;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.wyble.procesagro.helpers.DB;
import com.wyble.procesagro.helpers.Webservice;
import com.wyble.procesagro.models.Convocatoria;
import com.wyble.procesagro.models.Oferta;
import com.wyble.procesagro.models.PasoOferta;
import com.wyble.procesagro.models.Servicio;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class MainActivity extends ActionBarActivity{

    private static final String CONVOCATORIAS_URL = "http://tucompualdia.com/aplicaciones/procesAgroWebService/convocatorias.php";

    private static final String OFERTAS_URL = "http://tucompualdia.com/aplicaciones/procesAgroWebService/ofertasinstitucionales.php";

    private static final String PASOS_OFERTAS_URL = "http://tucompualdia.com/aplicaciones/procesAgroWebService/pasosofertas.php";

    private static final String SERVICIOS_URL = "http://tucompualdia.com/aplicaciones/procesAgroWebService/servicios.php";

    private static final String CONVOCATORIAS_TABLE = "convocatorias";

    private static final String OFERTAS_TABLE = "ofertas";

    private static final String PASOS_OFERTAS_TABLE = "pasos_ofertas";

    private static final String SERVICIOS_TABLE = "servicios";

    private ArrayList<HashMap> tables;

    private DB db;

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

        // Just for testing, allow network access in the main thread
        // NEVER use this is productive code
        StrictMode.ThreadPolicy policy = new StrictMode.
                ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        tables = new ArrayList<HashMap>();

        Webservice wsConvocatorias = new Webservice(CONVOCATORIAS_URL);
        Webservice wsOfertas = new Webservice(OFERTAS_URL);
        Webservice wsPasosOfertas = new Webservice(PASOS_OFERTAS_URL);
        Webservice wsServicios = new Webservice(SERVICIOS_URL);

        HashMap<String, JSONArray> hmConvocatorias = new HashMap();
        HashMap<String, JSONArray> hmOfertas = new HashMap();
        HashMap<String, JSONArray> hmPasosOfertas = new HashMap();
        HashMap<String, JSONArray> hmServicios = new HashMap();

        hmConvocatorias.put(CONVOCATORIAS_TABLE, wsConvocatorias.parseJsonText(wsConvocatorias.getJsonText()));
        hmOfertas.put(OFERTAS_TABLE, wsOfertas.parseJsonText(wsOfertas.getJsonText()));
        hmPasosOfertas.put(PASOS_OFERTAS_TABLE, wsPasosOfertas.parseJsonText(wsPasosOfertas.getJsonText()));
        hmServicios.put(SERVICIOS_TABLE, wsServicios.parseJsonText(wsServicios.getJsonText()));

        tables.add(hmConvocatorias);
        tables.add(hmOfertas);
        tables.add(hmPasosOfertas);
        tables.add(hmServicios);

        db = new DB(this, tables);
        final ArrayList<Convocatoria> convocatorias = this.getConvocatorias();
        ArrayList<Oferta> ofertas = this.getOfertas();
        ArrayList<PasoOferta> pasosOfertas = this.getPasosOfertas();
        ArrayList<Servicio> servicios = this.getServicios();


        callView1= (Button) findViewById(R.id.row1_button1);//row1
        callView2= (Button) findViewById(R.id.row1_button2);//row1
        callView3= (Button) findViewById(R.id.row2_button1);//row2
        callView4= (Button) findViewById(R.id.row2_button2);//row2

        callView5= (Button) findViewById(R.id.row3_button1);//row3
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(convocatorias.size());
        callView5.setText(convocatorias.get(index).getTitulo() + "\n" + convocatorias.get(index).getDescripcionCorta());

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
                intentToCall.putExtra("CONVOCATORIAS", convocatorias);
                startActivity(intentToCall);
            }
        });

        callView6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("events", "clic boton 6");
                Intent intentToForm = new Intent(MainActivity.this, Call_Form1Activity.class);
                startActivity(intentToForm);
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

    private ArrayList<Convocatoria> getConvocatorias() {
        ArrayList convocatorias = new ArrayList();
        ArrayList<HashMap> data = db.getAllData(CONVOCATORIAS_TABLE);
        for (HashMap d : data) {
            convocatorias.add(new Convocatoria(
                    Integer.parseInt(d.get("autoId").toString()),
                    d.get("tituloConvocatoria").toString(),
                    d.get("descripcion").toString(),
                    d.get("descripcionLarga").toString(),
                    d.get("urlConvocatoria").toString(),
                    d.get("usuario_id").toString()
            ));
        }

        db.close();
        return convocatorias;
    }

    private ArrayList<Oferta> getOfertas() {
        ArrayList ofertas = new ArrayList();
        ArrayList<HashMap> data = db.getAllData(OFERTAS_TABLE);
        for (HashMap d : data) {
            ofertas.add(new Oferta(
                    Integer.parseInt(d.get("autoId").toString()),
                    d.get("usuario_id").toString(),
                    d.get("tituloOferta").toString(),
                    d.get("descripcionOferta").toString(),
                    d.get("urlAudioOferta").toString(),
                    d.get("urlOferta").toString()
            ));
        }

        /*{"id":"1","usuario_id":"2","tituloOferta":"COMPRA DE ARTICULOS","descripcionOferta":"sadasdas","urlAudioOferta":"http:\/\/gos.com","urlOferta":"http:\/\/gos.com"},*/

        db.close();
        return ofertas;
    }

    private Oferta getOfertaById(String id) {
        HashMap data = db.getDataByValue(OFERTAS_TABLE, "id", id);
        Oferta oferta = new Oferta(
            Integer.parseInt(data.get("autoId").toString()),
            data.get("usuario_id").toString(),
            data.get("tituloOferta").toString(),
            data.get("descripcionOferta").toString(),
            data.get("urlAudioOferta").toString(),
            data.get("urlOferta").toString()
        );
        db.close();
        return oferta;
    }

    private ArrayList<PasoOferta> getPasosOfertas() {
        ArrayList pasosOfertas = new ArrayList();
        ArrayList<HashMap> data = db.getAllData(PASOS_OFERTAS_TABLE);
        for (HashMap d : data) {
            pasosOfertas.add(new PasoOferta(
                    Integer.parseInt(d.get("autoId").toString()),
                    d.get("tituloPasos").toString(),
                    d.get("descripcionPaso").toString(),
                    d.get("urlPaso").toString(),
                    getOfertaById(d.get("ofertaInstitucional_id").toString())
            ));
        }

        /*{"id":"6","tituloPasos":"sadasdasdasd","descripcionPaso":"asdasd asd as das d asd as","urlPaso":"http:\/\/paso.com","ofertaInstitucional_id":"1"},*/

        db.close();
        return pasosOfertas;
    }

    private ArrayList<Servicio> getServicios() {
        ArrayList servicios = new ArrayList();
        ArrayList<HashMap> data = db.getAllData(SERVICIOS_TABLE);
        for (HashMap d : data) {
            servicios.add(new Servicio(
                    Integer.parseInt(d.get("autoId").toString()),
                    d.get("usuario_id").toString(),
                    d.get("tituloServicio").toString(),
                    d.get("descripcionServicio").toString(),
                    d.get("urlAudioServicio").toString(),
                    d.get("urlServicio").toString()
            ));
        }

        /*{"id":"2","usuario_id":"2","tituloServicio":"Servicio 1","descripcionServicio":"DEscripcion del servicio","urlAudioServicio":"https:\/\/www.google.com\/glass\/start\/","urlServicio":"http:\/\/audio.com"}*/

        db.close();
        return servicios;
    }



}
