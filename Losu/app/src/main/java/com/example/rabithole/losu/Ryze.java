package com.example.rabithole.losu;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by Rabithole on 11/5/2016.
 */

public class Ryze extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ryze_layout);

        final Button r1 = (Button) findViewById(R.id.ryze_1);
        final Button r2 = (Button) findViewById(R.id.ryze_2);
        final Button r3 = (Button) findViewById(R.id.ryze_3);
        final Button r4 = (Button) findViewById(R.id.ryze_4);

        r1.setBackgroundColor(Color.BLUE);
        r2.setBackgroundColor(Color.BLUE);
        r3.setBackgroundColor(Color.BLUE);
        r4.setBackgroundColor(Color.BLUE);

        //3 seconds wait?

        new CountDownTimer(3000,50)
        {
            @Override
            public void onTick(long arg0){

            }
            @Override
            public void onFinish(){
                r1.setBackgroundColor(Color.RED);
            }
        }.start();








    }

}

