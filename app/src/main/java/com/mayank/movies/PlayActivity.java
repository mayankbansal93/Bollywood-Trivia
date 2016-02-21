package com.mayank.movies;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.provider.CalendarContract;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {
    LinearLayout ll1,ll5,ll6;
    String movie_name;
    int level_no;
    int game_score;
    Boolean disable_button;
    Boolean fill_vowel;
    Display d;
    String movie[];
    SharedPreferences sp;
    ArrayList<TextView> textview = new ArrayList<TextView>();
    ArrayList<TextView> textview2 = new ArrayList<TextView>();
    Button hint;
    Toolbar toolbar;
    AlertDialog.Builder adb;
    AlertDialog ad;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        toolbar = (Toolbar) findViewById(R.id.play_toolbar);

        setSupportActionBar(toolbar);

        TypedValue tv = new TypedValue();
        int height=0;
        if (getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)){
            height = TypedValue.complexToDimensionPixelSize(tv.data, getResources().getDisplayMetrics());
        }

        Intent i1=getIntent();
        level_no = i1.getIntExtra("level_no",0);

        movie_name=Movie.name[level_no-1];

        ImageView iv;

        RelativeLayout.LayoutParams rlp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,height/3);
        rlp.addRule(RelativeLayout.CENTER_IN_PARENT);
        rlp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        iv=(ImageView)findViewById(R.id.score_image);
        iv.setImageResource(R.drawable.coin);
        iv.setLayoutParams(rlp);

        sp=getSharedPreferences("level",MODE_PRIVATE);

        game_score=sp.getInt("game_score",10);
        disable_button=sp.getBoolean("disable_button",true);
        fill_vowel=sp.getBoolean("fill_vowel",true);

        TextView tv2=(TextView)findViewById(R.id.game_score);
        RelativeLayout.LayoutParams rlp1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rlp1.addRule(RelativeLayout.CENTER_IN_PARENT);
        rlp1.addRule(RelativeLayout.RIGHT_OF, R.id.score_image);
        tv2.setLayoutParams(rlp1);
        tv2.setText(Integer.toString(game_score));

        Button b1=(Button)findViewById(R.id.game_title);
        b1.setText("LEVEL " + level_no);

        hint=(Button)findViewById(R.id.game_hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onHintClick();
            }
        });

        iv=(ImageView)findViewById(R.id.iv1);
        iv.setImageResource(Movie.image_id[level_no - 1][0]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lf = LayoutInflater.from(PlayActivity.this);
                View view = lf.inflate(R.layout.dialog, null);
                adb = new AlertDialog.Builder(PlayActivity.this);
                adb.setView(view);
                ImageView image = (ImageView) view.findViewById(R.id.image_dialog);
                image.setImageResource(Movie.image_id[level_no - 1][0]);
                ad = adb.create();
                ad.show();
            }
        });

        iv=(ImageView)findViewById(R.id.iv2);
        iv.setImageResource(Movie.image_id[level_no-1][1]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lf = LayoutInflater.from(PlayActivity.this);
                View view = lf.inflate(R.layout.dialog, null);
                adb = new AlertDialog.Builder(PlayActivity.this);
                adb.setView(view);
                ImageView image = (ImageView) view.findViewById(R.id.image_dialog);
                image.setImageResource(Movie.image_id[level_no - 1][1]);
                ad = adb.create();
                ad.show();
            }
        });

        iv=(ImageView)findViewById(R.id.iv3);
        iv.setImageResource(Movie.image_id[level_no-1][2]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lf = LayoutInflater.from(PlayActivity.this);
                View view = lf.inflate(R.layout.dialog, null);
                adb = new AlertDialog.Builder(PlayActivity.this);
                adb.setView(view);
                ImageView image = (ImageView) view.findViewById(R.id.image_dialog);
                image.setImageResource(Movie.image_id[level_no - 1][2]);
                ad = adb.create();
                ad.show();
            }
        });

        iv=(ImageView)findViewById(R.id.iv4);
        iv.setImageResource(Movie.image_id[level_no-1][3]);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater lf = LayoutInflater.from(PlayActivity.this);
                View view = lf.inflate(R.layout.dialog, null);
                adb = new AlertDialog.Builder(PlayActivity.this);
                adb.setView(view);
                ImageView image = (ImageView) view.findViewById(R.id.image_dialog);
                image.setImageResource(Movie.image_id[level_no - 1][3]);
                ad = adb.create();
                ad.show();
            }
        });

        ll1=(LinearLayout)findViewById(R.id.ll2);
        ll5=(LinearLayout)findViewById(R.id.ll6);
        ll6=(LinearLayout)findViewById(R.id.ll7);

        Point p1=new Point();
        d=getWindowManager().getDefaultDisplay();
        d.getSize(p1);
        RelativeLayout.LayoutParams lp1=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp1.addRule(RelativeLayout.BELOW,R.id.ll1);
        lp1.topMargin=((p1.y*120)/1920);
        ll1.setLayoutParams(lp1);

        movie= movie_name.split(" ");

        TextView tv1=new TextView(this);
        tv1.setText(" ");

        if(movie.length==1){
            for(int i=0;i<movie[0].length();i++) {
                createTextView(ll1);
            }
        }else if(movie.length==2){
            for(int i=0;i<movie[0].length();i++){
                createTextView(ll1);
            }
            textview.add(tv1);
            if(movie[0].length()+movie[1].length()<=10){
                createBlankSpace(ll1);
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll1);
                }
            }else{
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll5);
                }
            }
        }else if(movie.length==3){
            for(int i=0;i<movie[0].length();i++){
                createTextView(ll1);
            }
            textview.add(tv1);
            if(movie[0].length()+movie[1].length()<=10){
                createBlankSpace(ll1);
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll1);
                }
                textview.add(tv1);
                for(int i=0;i<movie[2].length();i++){
                    createTextView(ll5);
                }
            }else{
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll5);
                }
                textview.add(tv1);
                if(movie[1].length()+movie[2].length()<=10){
                    createBlankSpace(ll5);
                    for(int i=0;i<movie[2].length();i++){
                        createTextView(ll5);
                    }
                }else{
                    for(int i=0;i<movie[2].length();i++){
                        createTextView(ll6);
                    }
                }
            }
        }else if(movie.length==4){
            for(int i=0;i<movie[0].length();i++){
                createTextView(ll1);
            }
            textview.add(tv1);
            if(movie[0].length()+movie[1].length()<=10){
                createBlankSpace(ll1);
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll1);
                }
                textview.add(tv1);
                for(int i=0;i<movie[2].length();i++){
                    createTextView(ll5);
                }
                textview.add(tv1);
                if(movie[2].length()+movie[3].length()<=10){
                    createBlankSpace(ll5);
                    for(int i=0;i<movie[3].length();i++){
                        createTextView(ll5);
                    }
                }else{
                    for(int i=0;i<movie[3].length();i++){
                        createTextView(ll6);
                    }
                }
            }else{
                for(int i=0;i<movie[1].length();i++){
                    createTextView(ll5);
                }
                textview.add(tv1);
                if(movie[1].length()+movie[2].length()<=10){
                    createBlankSpace(ll5);
                    for(int i=0;i<movie[2].length();i++){
                        createTextView(ll5);
                    }
                    textview.add(tv1);
                    for(int i=0;i<movie[3].length();i++){
                        createTextView(ll6);
                    }
                }else{
                    for(int i=0;i<movie[2].length();i++){
                        createTextView(ll6);
                    }
                    textview.add(tv1);
                    createBlankSpace(ll6);
                    for(int i=0;i<movie[3].length();i++){
                        createTextView(ll6);
                    }
                }
            }
        }

        String arr[]={"Z","X","C","V","B","N","M"};
        createButton((LinearLayout)findViewById(R.id.ll3),arr);

        String arr2[]={"A","S","D","F","G","H","J","K","L"};
        createButton((LinearLayout)findViewById(R.id.ll4),arr2);

        String arr3[]={"Q","W","E","R","T","Y","U","I","O","P"};
        createButton((LinearLayout)findViewById(R.id.ll5),arr3);

        if(!disable_button){
            disableButtons();
        }

        if(!fill_vowel){
            fillVowels();
        }

    }

    public void addText(String text){
        for(int i=0;i<movie_name.length();i++){
            if(textview.get(i).getText().toString().equals("")){
                textview.get(i).setText(text);
                boolean c= check();
                if(c){
                    adb=new AlertDialog.Builder(this);
                    adb.setMessage("LEVEL COMPLETED");
                    adb.setCancelable(false);
                    adb.setPositiveButton("NEXT LEVEL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                            level_no++;
                            game_score += 10;
                            disable_button = true;
                            fill_vowel = true;
                            SharedPreferences.Editor editor = sp.edit();
                            if (level_no > Movie.name.length) {
                                editor.putInt("level_no", 1);
                                editor.putInt("game_score", 10);
                                editor.putBoolean("disable_button", true);
                                editor.putBoolean("fill_vowel", true);
                                editor.commit();
                                Intent i2 = new Intent(PlayActivity.this, FinalActivity.class);
                                i2.putExtra("game_score", game_score);
                                startActivity(i2);
                            } else {
                                editor.putInt("level_no", level_no);
                                editor.putInt("game_score", game_score);
                                editor.putBoolean("disable_button", disable_button);
                                editor.putBoolean("fill_vowel", fill_vowel);
                                editor.commit();
                                Intent i2 = new Intent(PlayActivity.this, PlayActivity2.class);
                                i2.putExtra("level_no", level_no);
                                startActivity(i2);
                            }
                        }
                    });
                    ad=adb.create();
                    ad.show();
                }
                break;
            }
        }
    }

    public boolean check(){
        int count=0;
        for(int i=0;i<movie_name.length();i++){
            if(textview.get(i).getText().toString().compareTo("")==0){
                return false;
            }else{
                if(textview.get(i).getText().toString().compareTo(movie_name.substring(i,i+1))==0){
                    count++;
                }
            }
        }
        if(count==movie_name.length()){
            return true;
        }
        int percentage=(int)(((count-movie.length+1)/(double)(movie_name.length()-movie.length+1))*100);
        if(percentage>50){
            CoordinatorLayout coord=(CoordinatorLayout)findViewById(R.id.coordinator);
            Snackbar snackbar = Snackbar.make(coord,Integer.toString(percentage)+"% Matched",Snackbar.LENGTH_SHORT);
            snackbar.show();
        }
        return false;
    }

    public void createBlankSpace(LinearLayout ll){
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        lp.setMargins(4, 4, 4, 4);
        tv.setLayoutParams(lp);
        tv.setWidth(30);
        tv.setHeight(80);
        ll.addView(tv);
    }

    public void createTextView(LinearLayout ll){
        final TextView tv = new TextView(this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv.setLayoutParams(lp);
        tv.setTextColor(Color.WHITE);
        tv.setGravity(Gravity.CENTER);
        Point p=new Point();
        d=getWindowManager().getDefaultDisplay();
        d.getSize(p);
        lp.setMargins((4 * p.x) / 1080, (4*p.x)/1080,(4*p.x)/1080,(4*p.x)/1080);
        tv.setWidth((p.x * 80) / 1080);
        tv.setHeight((p.y * 80) / 1920);
        tv.setBackgroundResource(R.drawable.btn_black);
        tv.setTextSize((p.x * 20) / 1080);
        tv.setText("");
        textview.add(tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("");
            }
        });
        ll.addView(tv);
    }

    public void createButton(LinearLayout ll,String arr[]){
        for(int i=0;i<arr.length;i++){
            final TextView tv1=new TextView(this);
            Point p=new Point();
            d=getWindowManager().getDefaultDisplay();
            d.getSize(p);
            LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(((p.x * 90) / 1080),((p.y * 120) / 1920));
            tv1.setText(arr[i]);
            tv1.setTypeface(null, Typeface.BOLD);
            lp.setMargins((4*p.x)/1080, (4*p.x)/1080, (4*p.x)/1080, (4*p.x)/1080);
            tv1.setGravity(Gravity.CENTER);
            tv1.setTextSize((p.x * 21) / 1080);
            tv1.setTextColor(Color.WHITE);
            tv1.setBackgroundResource(R.drawable.btn_black);
            tv1.setLayoutParams(lp);
            textview2.add(tv1);
            ll.addView(tv1);
            tv1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addText(tv1.getText().toString());
                }
            });
        }
    }

    public void disableButtons(){
        int array[]=new int[26];
        for(int i=0;i<movie_name.length();i++){
            if(movie_name.charAt(i)!=' ') {
                array[movie_name.charAt(i) - 65]++;
            }
        }
        for(int i=0;i<textview2.size();i++) {
            if (array[textview2.get(i).getText().toString().charAt(0) - 65] == 0) {
                textview2.get(i).setOnClickListener(null);
                textview2.get(i).setText("");
            }
        }
        if(disable_button) {
            game_score -= 30;
            disable_button = false;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("game_score", game_score);
            editor.putBoolean("disable_button", false);
            editor.commit();
            TextView tv = (TextView) findViewById(R.id.game_score);
            tv.setText(Integer.toString(game_score));
        }
    }

    public void fillVowels(){
        for(int i=0;i<movie_name.length();i++){
            if(movie_name.charAt(i)=='A' || movie_name.charAt(i)=='E' || movie_name.charAt(i)=='I' || movie_name.charAt(i)=='O' || movie_name.charAt(i)=='U'){
                textview.get(i).setText(movie_name.substring(i, i + 1));
                textview.get(i).setOnClickListener(null);
            }
        }
        if(fill_vowel) {
            game_score -= 30;
            fill_vowel = false;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("game_score", game_score);
            editor.putBoolean("fill_vowel", false);
            editor.commit();
            TextView tv = (TextView) findViewById(R.id.game_score);
            tv.setText(Integer.toString(game_score));
        }
    }

    public void onHintClick(){
        LayoutInflater lf = LayoutInflater.from(PlayActivity.this);
        View view = lf.inflate(R.layout.hint_dialog, null);
        adb = new AlertDialog.Builder(PlayActivity.this);
        adb.setView(view);

        Point p=new Point();
        d=getWindowManager().getDefaultDisplay();
        d.getSize(p);

        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(p.y * 50)/1920);
        ImageView iv=(ImageView)view.findViewById(R.id.hint_iv1);
        iv.setLayoutParams(lp);

        lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(p.y * 50)/1920);
        iv=(ImageView)view.findViewById(R.id.hint_iv2);
        iv.setLayoutParams(lp);

        TextView tv2=(TextView)view.findViewById(R.id.hint_tv1);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (disable_button && game_score >= 30) {
                    disableButtons();
                    ad.dismiss();
                } else {
                    if (game_score < 30 && disable_button) {
                        ad.dismiss();
                        adb = new AlertDialog.Builder(PlayActivity.this);
                        adb.setMessage("You don't have enough credits. But don't worry, your friends will help you in solving this level. :)");
                        ad = adb.create();
                        ad.show();
                    } else{
                        ad.dismiss();
                        adb = new AlertDialog.Builder(PlayActivity.this);
                        adb.setMessage("Already Removed. :)");
                        ad = adb.create();
                        ad.show();
                    }
                }
            }
        });

        tv2=(TextView)view.findViewById(R.id.hint_tv3);
        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fill_vowel && game_score >= 30) {
                    fillVowels();
                    ad.dismiss();
                } else {
                    if (game_score < 30 && fill_vowel) {
                        ad.dismiss();
                        adb = new AlertDialog.Builder(PlayActivity.this);
                        adb.setMessage("You don't have enough credits. But don't worry, your friends will help you in solving this level. :)");
                        ad = adb.create();
                        ad.show();
                    }else{
                        ad.dismiss();
                        adb = new AlertDialog.Builder(PlayActivity.this);
                        adb.setMessage("Already Filled. :)");
                        ad = adb.create();
                        ad.show();
                    }
                }
            }
        });
        ad = adb.create();
        ad.show();
    }

    @Override
    public void onBackPressed() {
        LayoutInflater lf = LayoutInflater.from(this);
        View view = lf.inflate(R.layout.backpress_dialog, null);
        adb = new AlertDialog.Builder(this);
        adb.setView(view);

        TextView tv=(TextView)view.findViewById(R.id.tv);
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
