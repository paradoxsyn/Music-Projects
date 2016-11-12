package com.example.rabithole.losu;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;

/**
 * Created by Rabithole on 11/5/2016.
 */

public class Ryze extends AppCompatActivity {

    boolean started = false;
    Handler handler = new Handler();

    Button r1;
    Button r2;
    Button r3;
    Button r4;

    public Runnable runone = new Runnable() {
        @Override
        public void run() {
            r1 = (Button) findViewById(R.id.ryze_1);
            r2 = (Button) findViewById(R.id.ryze_2);
            r3 = (Button) findViewById(R.id.ryze_3);
            r4 = (Button) findViewById(R.id.ryze_4);

            if(started){
                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setBackgroundColor(Color.GREEN);
                        r1.setClickable(false);
                        handler.postDelayed(runone, 6000);
                    }
                });r1.setBackgroundColor(Color.RED);
                r1.setClickable(true);
            }
        }
    };

    public Runnable runtwo = new Runnable() {
        @Override
        public void run() {
            r1 = (Button) findViewById(R.id.ryze_1);
            r2 = (Button) findViewById(R.id.ryze_2);
            r3 = (Button) findViewById(R.id.ryze_3);
            r4 = (Button) findViewById(R.id.ryze_4);

            r2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    r2.setBackgroundColor(Color.GREEN);
                    r1.setBackgroundColor(Color.RED);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r2.setClickable(false);
                    handler.postDelayed(runtwo, 13000);
                }
            });r2.setBackgroundColor(Color.RED);
            r2.setClickable(true);

        }
    };

    public Runnable runthree = new Runnable() {
        @Override
        public void run() {
            r1 = (Button) findViewById(R.id.ryze_1);
            r2 = (Button) findViewById(R.id.ryze_2);
            r3 = (Button) findViewById(R.id.ryze_3);
            r4 = (Button) findViewById(R.id.ryze_4);

            r3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    r3.setBackgroundColor(Color.GREEN);
                    r1.setBackgroundColor(Color.RED);
                    r1.setClickable(true);
                    handler.removeCallbacks(runone);
                    r3.setClickable(false);
                    handler.postDelayed(runthree, 2250);
                }
            });r3.setBackgroundColor(Color.RED);
            r3.setClickable(true);

        }
    };

    public Runnable runfour = new Runnable() {
        @Override
        public void run() {
            r2 = (Button) findViewById(R.id.ryze_2);
            r3 = (Button) findViewById(R.id.ryze_3);
            r4 = (Button) findViewById(R.id.ryze_4);

            r4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    r4.setBackgroundColor(Color.GREEN);
                    handler.postDelayed(runfour, 120000);
                }
            });
            //start();
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

        final Button start = (Button) findViewById(R.id.ryze_start);
        final Button stop = (Button) findViewById(R.id.ryze_stop);

        r1 = (Button) findViewById(R.id.ryze_1);
        r2 = (Button) findViewById(R.id.ryze_2);
        r3 = (Button) findViewById(R.id.ryze_3);
        r4 = (Button) findViewById(R.id.ryze_4);


        r1.setBackgroundColor(Color.BLUE);
        r2.setBackgroundColor(Color.BLUE);
        r3.setBackgroundColor(Color.BLUE);
        r4.setBackgroundColor(Color.BLUE);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ryzeQ(0,0);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ryzeW(0,0);
            }
        });

    }

    public void ryzeQ(int Latency, int Cooldown)
    {

        start();

    }

    public void ryzeW(int Latency, int Cooldown)
    {
        stop();
    }
}

