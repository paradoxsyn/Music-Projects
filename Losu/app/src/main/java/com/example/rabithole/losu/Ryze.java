package com.example.rabithole.losu;

import android.animation.ObjectAnimator;
import android.app.ActionBar;
import android.app.Dialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.button;
import static java.security.AccessController.getContext;

/**
 * Created by Rabithole on 11/5/2016.
 */

public class Ryze extends AppCompatActivity {

    boolean started = false;
    Handler handler = new Handler();

    ImageButton r1;
    ImageButton r2;
    ImageButton r3;
    ImageButton r4;

    int ryzeQ;
    int ryzeW;
    int ryzeE;
    int ryzeR;

    Button cooldown1;
    Button cooldown2;
    Button cooldown3;
    Button cooldown4;
    Button ryzeinfo;

    LayoutInflater ryzeToast;

    AnimationDrawable qanim = new AnimationDrawable();
    AnimationDrawable wanim = new AnimationDrawable();
    AnimationDrawable eanim = new AnimationDrawable();
    AnimationDrawable ranim = new AnimationDrawable();


    public Runnable runone = new Runnable() {
        @Override
        public void run() {
            r1 = (ImageButton) findViewById(R.id.ryze_1);
            r2 = (ImageButton) findViewById(R.id.ryze_2);
            r3 = (ImageButton) findViewById(R.id.ryze_3);
            r4 = (ImageButton) findViewById(R.id.ryze_4);

            if(started){
                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setClickable(false);
                        handler.postDelayed(runone, ryzeQ);
                        animateButtonQ();
                    }
                });r1.setBackgroundResource(R.drawable.overload);
                r1.setClickable(true);

            }
        }
    };

    public Runnable runtwo = new Runnable() {
        @Override
        public void run() {
            r1 = (ImageButton) findViewById(R.id.ryze_1);
            r2 = (ImageButton) findViewById(R.id.ryze_2);
            r3 = (ImageButton) findViewById(R.id.ryze_3);
            r4 = (ImageButton) findViewById(R.id.ryze_4);

            r2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qanim.stop();
                    r1.setBackgroundResource(R.drawable.overload);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r2.setClickable(false);
                    handler.postDelayed(runtwo, ryzeW);
                    animateButtonW();
                }
            });r2.setBackgroundResource(R.drawable.runeprison);
            r2.setClickable(true);

        }
    };

    public Runnable runthree = new Runnable() {
        @Override
        public void run() {
            r1 = (ImageButton) findViewById(R.id.ryze_1);
            r2 = (ImageButton) findViewById(R.id.ryze_2);
            r3 = (ImageButton) findViewById(R.id.ryze_3);
            r4 = (ImageButton) findViewById(R.id.ryze_4);

            r3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qanim.stop();
                    r1.setBackgroundResource(R.drawable.overload);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r3.setClickable(false);
                    handler.postDelayed(runthree, ryzeE);
                    animateButtonE();
                }
            });r3.setBackgroundResource(R.drawable.spellflux);
            r3.setClickable(true);

        }
    };

    public Runnable runfour = new Runnable() {
        @Override
        public void run() {
            r1 = (ImageButton) findViewById(R.id.ryze_1);
            r2 = (ImageButton) findViewById(R.id.ryze_2);
            r3 = (ImageButton) findViewById(R.id.ryze_3);
            r4 = (ImageButton) findViewById(R.id.ryze_4);

            r4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    handler.postDelayed(runfour, ryzeR);
                    animateButtonR();
                }
            });r4.setBackgroundResource(R.drawable.realmwarp);
        }
    };

    public void stop() {
        started = false;

        r1.setBackgroundResource(R.drawable.overload);
        r2.setBackgroundResource(R.drawable.runeprison);
        r3.setBackgroundResource(R.drawable.spellflux);
        r4.setBackgroundResource(R.drawable.realmwarp);

        handler.removeCallbacks(runone);
        handler.removeCallbacks(runtwo);
        handler.removeCallbacks(runthree);
        handler.removeCallbacks(runfour);

        r1.setClickable(false);
        r2.setClickable(false);
        r3.setClickable(false);
        r4.setClickable(false);

        ryzeQ = 6000;
        ryzeW = 13000;
        ryzeE = 2250;
        ryzeR = 120000;

        r1.clearAnimation();
        r2.clearAnimation();
        r3.clearAnimation();
        r4.clearAnimation();


    }

    public void start() {
        started = true;

        handler.post(runone);
        handler.post(runtwo);
        handler.post(runthree);
        handler.post(runfour);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ryze_layout);

        ryzeQ = 6000;
        ryzeW = 13000;
        ryzeE = 2250;
        ryzeR = 120000;

        Toolbar ryzebar = (Toolbar) findViewById(R.id.ryze_bar);
        setSupportActionBar(ryzebar);
        getSupportActionBar().setTitle("Ryze");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setSpinner();

        final Button start = (Button) findViewById(R.id.ryze_start);
        final Button stop = (Button) findViewById(R.id.ryze_stop);

        r1 = (ImageButton) findViewById(R.id.ryze_1);
        r2 = (ImageButton) findViewById(R.id.ryze_2);
        r3 = (ImageButton) findViewById(R.id.ryze_3);
        r4 = (ImageButton) findViewById(R.id.ryze_4);
        cooldown1 = (Button) findViewById(R.id.cooldown10);
        cooldown2 = (Button) findViewById(R.id.cooldown20);
        cooldown3 = (Button) findViewById(R.id.cooldown30);
        cooldown4 = (Button) findViewById(R.id.cooldown40);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopButton();
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        // or call onBackPressed()
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ryze_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.cooldown10){
            //has to be running
            if(started==false){
                startButton();
            }

            ryzeQ = 5400;
            ryzeW = 11700;
            ryzeE = 2000;
            ryzeR = 108000;

        }
        else if(id == R.id.cooldown20){
            //has to be running
            if(started==false){
                startButton();
            }

            ryzeQ = 4800;
            ryzeW = 10400;
            ryzeE = 1800;
            ryzeR = 96000;
        }
        else if(id == R.id.cooldown30){
            //has to be running
            if(started==false){
                startButton();
            }

            ryzeQ = 4200;
            ryzeW = 9100;
            ryzeE = 1575;
            ryzeR = 84000;
        }
        else if(id == R.id.cooldown40){
            //has to be running
            if(started==false){
                startButton();
            }

            ryzeQ = 3600;
            ryzeW = 7800;
            ryzeE = 1325;
            ryzeR = 72000;
        }

        else if(id == R.id.information){
            Intent intent = new Intent(getApplicationContext(), com.example.rabithole.losu.RyzeWeb.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
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

    public void startButton()
    {

        start();

    }

    public void setSpinner()
    {
        Spinner spinnerq = (Spinner) findViewById(R.id.q_spinner);
        Spinner spinnerw = (Spinner) findViewById(R.id.w_spinner);
        Spinner spinnere = (Spinner) findViewById(R.id.e_spinner);
        Spinner spinnerr = (Spinner) findViewById(R.id.r_spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.levels_array, R.layout.spinner_title);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
// Apply the adapter to the spinner
        spinnerq.setAdapter(adapter);
        spinnerw.setAdapter(adapter);
        spinnere.setAdapter(adapter);
        spinnerr.setAdapter(adapter);

        spinnerw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                if(position == 1 && started == true){
                    ryzeW = ryzeW - 1000;
                }
                else if(position == 2 && started == true){
                    ryzeW = ryzeW - 2000;
                }
                else if(position == 3 && started == true){
                    ryzeW = ryzeW - 3000;
                }
                else if(position == 4 && started == true){
                    ryzeW = ryzeW - 4000;
                }
                else if(started == false && position != 0){
                    Toast.makeText(Ryze.this, "Please press start first ", Toast.LENGTH_SHORT).show();
                    spinnerReset();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinnerq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (started == false && position != 0) {
                    Toast.makeText(Ryze.this, "Please press start first ", Toast.LENGTH_SHORT).show();
                    spinnerReset();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        spinnere.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (started == false && position != 0) {
                    Toast.makeText(Ryze.this, "Please press start first ", Toast.LENGTH_SHORT).show();
                    spinnerReset();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
        spinnerr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if (started == false && position != 0) {
                    Toast.makeText(Ryze.this, "Please press start first ", Toast.LENGTH_SHORT).show();
                    spinnerReset();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }
    public void spinnerReset()
    {
        Spinner spinnerq = (Spinner) findViewById(R.id.q_spinner);
        Spinner spinnerw = (Spinner) findViewById(R.id.w_spinner);
        Spinner spinnere = (Spinner) findViewById(R.id.e_spinner);
        Spinner spinnerr = (Spinner) findViewById(R.id.r_spinner);

        spinnerq.setSelection(0);
        spinnerw.setSelection(0);
        spinnere.setSelection(0);
        spinnerr.setSelection(0);
    }

    public void animateButtonQ(){

        r1.setBackgroundResource(R.drawable.overload_cooldown);

        qanim = (AnimationDrawable) r1.getBackground();
        qanim.setEnterFadeDuration(ryzeQ);

        ryzeToast = getLayoutInflater();

        View toastlay =ryzeToast.inflate(R.layout.ryze_toast,(ViewGroup)findViewById(R.id.toastlayout));
        final TextView messageOne=(TextView)toastlay.findViewById(R.id.cloudmessage);
        messageOne.setText("Quick! Click it again Summoner!");

        final Toast lastToast=new Toast(getApplicationContext());
        lastToast.setDuration(Toast.LENGTH_SHORT);
        lastToast.setView(toastlay);
        //myToast.show();
        qanim.start();

        new CountDownTimer(ryzeQ, ryzeQ / 2)
        {

            public void onTick(long millisUntilFinished) {messageOne.setText("OooOoOoo..I hear it ticking..");lastToast.show();}
            public void onFinish() {messageOne.setText("Quick! Click it again Summoner!");lastToast.show();}

        }.start();
    }
    public void animateButtonW(){

        r2.setBackgroundResource(R.drawable.runeprison_cooldown);

        wanim = (AnimationDrawable) r2.getBackground();
        wanim.setEnterFadeDuration(ryzeW);
        //Toast.makeText(Ryze.this, "" + ryzeW, Toast.LENGTH_SHORT).show();
        wanim.start();
    }
    public void animateButtonE(){

        r3.setBackgroundResource(R.drawable.spellflux_cooldown);

        eanim = (AnimationDrawable) r3.getBackground();
        eanim.setEnterFadeDuration(ryzeE);
        eanim.start();
    }
    public void animateButtonR(){

        r4.setBackgroundResource(R.drawable.realmwarp_cooldown);

        ranim = (AnimationDrawable) r4.getBackground();
        ranim.setEnterFadeDuration(ryzeR);
        ranim.start();
    }

    public void stopButton()
    {
        stop();
        spinnerReset();
    }
}

