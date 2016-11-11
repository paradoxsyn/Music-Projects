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

    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            r1 = (Button) findViewById(R.id.ryze_1);
            r2 = (Button) findViewById(R.id.ryze_2);
            r3 = (Button) findViewById(R.id.ryze_3);
            r4 = (Button) findViewById(R.id.ryze_4);

            r1.setBackgroundColor(Color.RED);
            r2.setBackgroundColor(Color.RED);
            r3.setBackgroundColor(Color.RED);
            r4.setBackgroundColor(Color.RED);



            if(started){
                r1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r1.setBackgroundColor(Color.GREEN);
                        handler.postDelayed(runnable, 6000);
                    }
                }); handler.removeCallbacks(runnable);
                r2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r2.setBackgroundColor(Color.GREEN);
                        r1.setBackgroundColor(Color.RED);
                        handler.postDelayed(runnable, 13000);
                    }
                });handler.removeCallbacks(runnable);
                r3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r3.setBackgroundColor(Color.GREEN);
                        r1.setBackgroundColor(Color.RED);
                        handler.postDelayed(runnable, 2250);

                    }
                });handler.removeCallbacks(runnable);
                r4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        r4.setBackgroundColor(Color.GREEN);
                        handler.postDelayed(runnable, 120000);
                    }
                });
                //start();
            }
        }
    };

    public void stop() {
        started = false;

        r1.setBackgroundColor(Color.BLUE);
        r2.setBackgroundColor(Color.BLUE);
        r3.setBackgroundColor(Color.BLUE);
        r4.setBackgroundColor(Color.BLUE);

        handler.removeCallbacks(runnable);
    }

    public void start() {
        started = true;

        handler.post(runnable);
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

