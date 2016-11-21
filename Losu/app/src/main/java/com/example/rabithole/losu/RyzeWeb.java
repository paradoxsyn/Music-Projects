package com.example.rabithole.losu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/**
 * Created by Rabithole on 11/19/2016.
 */

public class RyzeWeb extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ryze_webview);
        WebView ryzeWeb = (WebView) findViewById(R.id.ryze_webview);
        WebSettings webSettings = ryzeWeb.getSettings();
        //webSettings.setJavaScriptEnabled(true);
        ryzeWeb.loadUrl("http://leagueoflegends.wikia.com/wiki/Ryze");
        ryzeWeb.setWebViewClient(new WebViewController());
        //layout.setVisibility(View.VISIBLE);
        //ryzeWeb.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

    @Override
    public void onBackPressed() {
        //if (ryzeWeb.canGoBack()){
        // ryzeWeb.goBack();
        // }
        // else
        //super.onBackPressed();
        finish();
    }

}
