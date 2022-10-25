package com.example.administrator.cocaro;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class PvsPActivity extends AppCompatActivity {
    GridView grid;
    AdapterGridViewPvsP adapter;
    ArrayList<Integer> list, rep, red;
    TextView pwin;
    Button btNewGame;
    ConstraintLayout constraintLayout;
    ConstraintLayout.LayoutParams layoutParams;
    ImageView px, po;
    int vitri;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_pvsp, menu);
        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.pvsp_undo:
                    if (rep.size()>1 && rep.get(rep.size()-1)>=0) {
                        list.set(rep.get(rep.size()-1), 0);
                        red.add(rep.get(rep.size()-1));
                        rep.remove(rep.size()-1);
                        adapter.notifyDataSetChanged();
                    }
                    if (rep.size()>1 && rep.get(rep.size()-1)<0) {
                        for (int i=0; i<19*19; i++)
                            if (list.get(i)==7) list.set(i, 0);
                        rep.remove(rep.size()-1);
                        list.set(rep.get(rep.size()-1), 0);
                        rep.remove(rep.size()-1);
                        btNewGame.setEnabled(false);
                        adapter.notifyDataSetChanged();
                    }
                break;
            case R.id.pvsp_redo:
                    if (red.size()>0) {
                        if (rep.size()%2==0) list.set(red.get(red.size()-1), 1);
                        else list.set(red.get(red.size()-1), -1);
                        rep.add(red.get(red.size()-1));
                        red.remove(red.size()-1);
                        adapter.notifyDataSetChanged();
                    }
                break;
            case R.id.pvsp_back:
                finish();
                break;
            
        }
        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvsp);
        anhxa();
        khoitaobanco();

        ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#fe6d94"));


        ((ActionBar) actionBar).setBackgroundDrawable(colorDrawable);
        
        layoutParams.height=layoutParams.width;
        btNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                px.setImageResource(R.drawable.px);
                po.setImageResource(R.drawable.poo);
                list.clear(); rep.clear(); red.clear();
                for (int i=0; i<19*19; i++) list.add(0);
                list.set(180, 1);
                rep.add(180);
                pwin.setText("");
                
                adapter = new AdapterGridViewPvsP(PvsPActivity.this, R.layout.activity_item, list, rep, red, pwin, btNewGame, px, po);
                grid.setAdapter(adapter);
                btNewGame.setEnabled(false);
            }
        });

    }

    private void khoitaobanco() {
        list = new ArrayList<>();
        for (int i=0; i<19*19; i++) list.add(0);
        rep = new ArrayList<>();
        red = new ArrayList<>();
        
        adapter = new AdapterGridViewPvsP(PvsPActivity.this, R.layout.activity_item, list, rep, red, pwin, btNewGame, px, po);
        grid.setAdapter(adapter);

    }

    private void anhxa() {
        grid = (GridView) findViewById(R.id.grid);
        pwin = (TextView) findViewById(R.id.pwin);
       
        btNewGame = (Button) findViewById(R.id.btNewGame);
        constraintLayout = (ConstraintLayout) findViewById(R.id.constrainLayout);
        layoutParams = (ConstraintLayout.LayoutParams) constraintLayout.getLayoutParams();
        px = (ImageView) findViewById(R.id.px);
        po = (ImageView) findViewById(R.id.po);
    }


}
