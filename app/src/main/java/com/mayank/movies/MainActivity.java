package com.mayank.movies;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    Button b1;
    SharedPreferences sp;
    TextView tv;
    AlertDialog.Builder adb;
    AlertDialog ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp=getSharedPreferences("level",MODE_PRIVATE);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .build();
        mAdView.loadAd(adRequest);

        tv=(TextView)findViewById(R.id.tv2);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lf = LayoutInflater.from(MainActivity.this);
                View view = lf.inflate(R.layout.backpress_dialog, null);
                adb = new AlertDialog.Builder(MainActivity.this);
                adb.setView(view);

                tv=(TextView)view.findViewById(R.id.tv);
                tv.setText("Do you really want to start again?");

                Button b=(Button)view.findViewById(R.id.b1);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor editor=sp.edit();
                        editor.putInt("level_no",1);
                        editor.putInt("game_score",10);
                        editor.putBoolean("disable_button",true);
                        editor.putBoolean("fill_vowel",true);
                        editor.commit();
                        Intent i=new Intent(MainActivity.this,PlayActivity.class);
                        i.putExtra("level_no",sp.getInt("level_no",1));
                        startActivity(i);
                        ad.dismiss();   
                    }
                });

                b=(Button)view.findViewById(R.id.b2);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ad.dismiss();
                    }
                });

                adb.setCancelable(false);
                ad=adb.create();
                ad.show();
            }
        });

        b1=(Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,PlayActivity.class);
                i.putExtra("level_no",sp.getInt("level_no",1));
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv = (TextView)findViewById(R.id.tv);
        tv.setText("LEVEL " + sp.getInt("level_no", 1));
    }

    @Override
    public void onBackPressed() {
        LayoutInflater lf = LayoutInflater.from(this);
        View view = lf.inflate(R.layout.backpress_dialog, null);
        adb = new AlertDialog.Builder(this);
        adb.setView(view);

        tv=(TextView)view.findViewById(R.id.tv);
        tv.setText("Do you really want to quit?");

        Button b=(Button)view.findViewById(R.id.b1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        b=(Button)view.findViewById(R.id.b2);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ad.dismiss();
            }
        });
        adb.setCancelable(false);
        ad=adb.create();
        ad.show();
    }
}
