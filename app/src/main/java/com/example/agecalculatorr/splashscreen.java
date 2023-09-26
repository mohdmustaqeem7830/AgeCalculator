package com.example.agecalculatorr;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {

    TextView txtone;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(getResources().getColor(R.color.white));

        txtone  = findViewById(R.id.txtone);
        Intent home = new Intent(splashscreen.this,MainActivity.class);
        Animation anm = AnimationUtils.loadAnimation(this,R.anim.scale);
        txtone.startAnimation(anm);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(home);
                finish();
            }
        },3000);
    }
}