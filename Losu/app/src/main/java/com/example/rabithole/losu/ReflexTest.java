package com.example.rabithole.losu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;

/**
 * Created by Rabithole on 11/2/2016.
 */

public class ReflexTest extends AppCompatActivity{
    GridView grid;
    int[] imageIDs = {R.drawable.ryzebutton,R.drawable.anniebutton};
    String[] text = {"Ryze","Annie"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reflex_test);

        ImageAdapter adapter = new ImageAdapter(ReflexTest.this, text, imageIDs);
        grid=(GridView)findViewById(R.id.reflexgrid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(ReflexTest.this, "You Clicked on " +text[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }


}





