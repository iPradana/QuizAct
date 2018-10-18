package com.team67.quizact;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    String p1="1 + 1 = ?";
    String p2="1 - 1 = ?";
    String p3="1 x 1 = ?";
    String p4="1 / 1 = ?";
    String p5="Warna apakah ini?";
    String j1="2";
    String j2="0";
    String j3="1";
    String j4="~";
    String j5="Kuning";
    String j6="Biru";
    String j7="Hijau";
    String j8="Merah";
    int soal,benar,salah;
    int x=0;
    String p = null;
    String j = null;
    String jx = null;
    TextView txtp = null;
    Button btnA,btnB,btnC,btnD,btnPress,btnx;
    ArrayList<String> jawaban = new ArrayList<String>();
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtp = (TextView) findViewById(R.id.txtpertanyaan);
        extras = getIntent().getExtras();
        soal = extras.getInt("soal");
        switch(soal){
            case 0 : x=1; p=p1; j=j1; break;
            case 1 : x=2; p=p2; j=j2; break;
            case 2 : x=3; p=p3; j=j3; break;
            case 3 : x=4; p=p4; j=j3; break;
            case 4 : x=5; p=p5; j=j5; txtp.setTextColor(Color.YELLOW);  break;
            case 5 : x=6; p=p5; j=j6; txtp.setTextColor(Color.BLUE); break;
            case 6 : x=7; p=p5; j=j7; txtp.setTextColor(Color.GREEN);  break;
            case 7 : x=8; p=p5; j=j8; txtp.setTextColor(Color.RED);  break;
            case 8 : x=9; p=p5; j=j8; txtp.setTextColor(Color.WHITE);  break;
        }

        if(x<9) {
            txtp.setText(p);
            Random rnd = new Random();

            if(x<5){
                jawaban.add(j1);
                jawaban.add(j2);
                jawaban.add(j3);
                jawaban.add(j4);
            }else if(x>4 && x<9){
                jawaban.add(j5);
                jawaban.add(j6);
                jawaban.add(j7);
                jawaban.add(j8);
            }

            int randomer = 0;
            for(int i=0; i<4; i++){
                randomer = rnd.nextInt(jawaban.size());
                String hasilRandom = jawaban.get(randomer);
                jawaban.remove(randomer);
                switch(i){
                    case 0: btnA = (Button) findViewById(R.id.btnA); btnA.setText(hasilRandom); break;
                    case 1: btnB = (Button) findViewById(R.id.btnB); btnB.setText(hasilRandom); break;
                    case 2: btnC = (Button) findViewById(R.id.btnC); btnC.setText(hasilRandom); break;
                    case 3: btnD = (Button) findViewById(R.id.btnD); btnD.setText(hasilRandom); break;
                }
            }
        }else{
            Intent a = new Intent(this,Main3Activity.class);
            benar = extras.getInt("benar");
            salah = extras.getInt("salah");
            a.putExtra("benar",benar);
            a.putExtra("salah",salah);
            startActivity(a);
            Main2Activity.this.finish();
        }
    }

    public void btnSubmit(View view){
        btnx = (Button) findViewById(view.getId());
        jx = btnx.getText().toString();

        benar = extras.getInt("benar");
        salah = extras.getInt("salah");

        if(jx.equalsIgnoreCase(j)){
            benar++;
            btnPress = (Button) findViewById(view.getId());
            btnPress.setBackgroundColor(Color.GREEN);
        }else{
            salah++;
            btnPress = (Button) findViewById(view.getId());
            btnPress.setBackgroundColor(Color.RED);
        }

        Intent a = new Intent(this,Main2Activity.class);
        a.putExtra("soal",x);
        a.putExtra("benar",benar);
        a.putExtra("salah",salah);
        startActivity(a);
        Main2Activity.this.finish();
    }
}
