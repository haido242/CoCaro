package com.example.administrator.cocaro;

        import android.app.Activity;
        import android.app.Dialog;
        import android.content.Context;
        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.ImageButton;
        import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton pvsp, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar;
        actionBar = getSupportActionBar();


        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#fe6d94"));


        ((ActionBar) actionBar).setBackgroundDrawable(colorDrawable);
//        getActionBar().hide();
        AnhXa();

        pvsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentPvsP = new Intent(MainActivity.this, PvsPActivity.class);
                startActivity(intentPvsP);
            }
        });



        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    private void AnhXa() {
        pvsp    = (ImageButton) findViewById(R.id.pvsp);
        exit    = (ImageButton) findViewById(R.id.exit);
    }
}
