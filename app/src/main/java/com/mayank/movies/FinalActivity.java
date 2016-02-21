package com.mayank.movies;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FinalActivity extends AppCompatActivity {

    int game_score;
    Display d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        Intent i1=getIntent();
        game_score=i1.getIntExtra("game_score",10);

        Point p1=new Point();
        d=getWindowManager().getDefaultDisplay();
        d.getSize(p1);

        ImageView iv=(ImageView)findViewById(R.id.iv1);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(p1.y * 100)/1920);
        lp.weight=45;
        iv.setLayoutParams(lp);

        TextView t1=(TextView)findViewById(R.id.tv1);
        t1.setText("YOUR SCORE IS "+Integer.toString(game_score));
    }
}
