package com.wyble.procesagro;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class WebViewActivity extends ActionBarActivity {
    WebView webView1_aux;
    String url_setter;

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle dataFromHomeActivity= getIntent().getExtras();
        url_setter= dataFromHomeActivity.getString("URL_PARAMETER");

        webView1_aux= (WebView) findViewById(R.id.webView1);
        webView1_aux.loadUrl(url_setter);
        webView1_aux.setWebViewClient(new WebViewClient());
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.web_view, menu);
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
