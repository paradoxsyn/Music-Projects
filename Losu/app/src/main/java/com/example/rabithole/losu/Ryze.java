package com.example.rabithole.losu;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.attr.button;

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

    final Animation in = new AlphaAnimation(0.0f, 1.0f);
    final Animation out = new AlphaAnimation(1.0f, 0.0f);





    public Runnable runone = new Runnable() {
        @Override
        public void run() {
            r1 = (ImageButton) findViewById(R.id.ryze_1);
            r2 = (ImageButton) findViewById(R.id.ryze_2);
            r3 = (ImageButton) findViewById(R.id.ryze_3);
            r4 = (ImageButton) findViewById(R.id.ryze_4);
            ryzeQ = 6000;
            ryzeW = 13000;
            ryzeE = 2250;
            ryzeR = 120000;

            if(started){
                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setBackgroundColor(Color.GREEN);
                        r1.setClickable(false);
                        handler.postDelayed(runone, ryzeQ);
                        animateButton();
                    }
                });r1.setBackgroundColor(Color.RED);
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
                    r2.setBackgroundColor(Color.GREEN);
                    r1.setBackgroundColor(Color.RED);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r2.setClickable(false);
                    handler.postDelayed(runtwo, ryzeW);
                }
            });r2.setBackgroundColor(Color.RED);
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
                    r3.setBackgroundColor(Color.GREEN);
                    r1.setBackgroundColor(Color.RED);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r3.setClickable(false);
                    handler.postDelayed(runthree, ryzeE);
                }
            });r3.setBackgroundColor(Color.RED);
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
                    r4.setBackgroundColor(Color.GREEN);
                    handler.postDelayed(runfour, ryzeR);
                }
            });
        }
    };

    public void stop() {
        started = false;

        r1.setBackgroundColor(Color.BLUE);
        r2.setBackgroundColor(Color.BLUE);
        r3.setBackgroundColor(Color.BLUE);
        r4.setBackgroundColor(Color.BLUE);

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

    }

    public void start() {
        started = true;

        r1.setBackgroundColor(Color.RED);
        r2.setBackgroundColor(Color.RED);
        r3.setBackgroundColor(Color.RED);
        r4.setBackgroundColor(Color.RED);

        handler.post(runone);
        handler.post(runtwo);
        handler.post(runthree);
        handler.post(runfour);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ryze_layout);

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

        r1.setBackgroundColor(Color.BLUE);
        r2.setBackgroundColor(Color.BLUE);
        r3.setBackgroundColor(Color.BLUE);
        r4.setBackgroundColor(Color.BLUE);

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
        //setContentView(R.layout.ryze_fragment);

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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
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
                if(position == 1){
                    ryzeW = ryzeW - 1000;
                }
                else if(position == 2){
                    ryzeW = ryzeW - 2000;
                }
                else if(position == 3){
                    ryzeW = ryzeW - 3000;
                }
                else if(position == 4){
                    ryzeW = ryzeW - 4000;
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

    public void animateButton(){

        in.setDuration(3000);
        out.setDuration(3000);

        AnimationSet as = new AnimationSet(true);
        as.addAnimation(out);
        in.setStartOffset(3000);
        as.addAnimation(in);

        r1.startAnimation(as);
    }

    public void stopButton()
    {
        stop();
        spinnerReset();
    }
}

