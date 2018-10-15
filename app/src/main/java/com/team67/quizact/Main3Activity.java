package com.team67.quizact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Bundle extras;
    int benar=0;
    int salah=0;
    int skor=0;
    TextView txtSkor,txtBenar,txtSalah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        extras = getIntent().getExtras();
        benar = extras.getInt("benar");
        salah = extras.getInt("salah");
        skor = benar*100/8;
        txtSkor = (TextView) findViewById(R.id.txtSkor);
        txtBenar = (TextView) findViewById(R.id.txtBenar);
        txtSalah = (TextView) findViewById(R.id.txtSalah);
        txtSkor.setText(Integer.toString(skor));
        txtBenar.setText(Integer.toString(benar));
        txtSalah.setText(Integer.toString(salah));
    }

    public void kembali(View v){
        Intent a = new Intent(this, MainActivity.class);
        startActivity(a);
        Main3Activity.this.finish();
    }
}
