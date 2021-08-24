package com.example.splashscreenwithanimationandsound;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    MediaPlayer music;
    Animation topanim, botanim;
    ImageView image1;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        topanim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        botanim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image1 = findViewById(R.id.image_1);
        text1 = findViewById(R.id.text_1);

        image1.setAnimation(topanim);
        text1.setAnimation(botanim);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    music = MediaPlayer.create(SplashActivity.this, R.raw.startup_tone);
                    music.start();
                    sleep(5000);
                }catch (Exception e){
                    Toast.makeText(SplashActivity.this, e.getMessage(),Toast.LENGTH_LONG).show();
                }finally {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        thread.start();

    }

}