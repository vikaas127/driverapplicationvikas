package com.jaats.agrovehicledriver.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jaats.agrovehicledriver.R;

public class LanguageChoose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_choose);
    }

    public void HindiLang(View v){
        Intent i=new Intent(LanguageChoose.this,WelcomeActivity.class);
        startActivity(i);
    }

    public void EnglishLang(View v){
        Intent a=new Intent(LanguageChoose.this,WelcomeActivity.class);
        startActivity(a);
    }
}
