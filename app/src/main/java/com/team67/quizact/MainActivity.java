package com.team67.quizact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mulai(View v){
        Intent a = new Intent(this, Main2Activity.class);
        int salah = 0;
        int benar = 0;
        int soal = 0;
        a.putExtra("salah",salah);
        a.putExtra("benar",benar);
        a.putExtra("soal",soal);
        startActivity(a);
        MainActivity.this.finish();
    }
}
