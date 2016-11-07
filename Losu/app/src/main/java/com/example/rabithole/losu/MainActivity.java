package com.example.rabithole.losu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static android.R.attr.button;

/**
 * Created by Rabithole on 10/17/2016.
 */

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front_page);

        final Button but1 = (Button) findViewById(R.id.button_1);
        final Button but2 = (Button) findViewById(R.id.button_2);
        final Button but3 = (Button) findViewById(R.id.button_3);
        final Button but4 = (Button) findViewById(R.id.button_4);

        but1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {

                Intent intent = new Intent(getApplicationContext(),com.example.rabithole.losu.PickChamp.class);
                startActivity(intent);


            }

        }
        );
        but2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                setContentView(R.layout.words_hurt);
            }

        }
        );
        but3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                setContentView(R.layout.range);
            }

        }
        );
        but4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                setContentView(R.layout.about);
            }

        }
        );
    }


    public void selfDestruct(View view) {
        // Kabloey
    }
}

 