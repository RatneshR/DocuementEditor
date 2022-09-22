package com.example.android.openoffice1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.example.android.openoffice1.activity.Main2Activity;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Dell on 29-08-2017.
 */

public class SplashScreen extends Activity {

    /**
     * The thread to process splash screen events
     */
    private Thread mSplashThread;
    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);   // Splash screen view
        setContentView(R.layout.splash);
     //   StartAnimations();

       // final ImageView splashImageView = (ImageView) findViewById(R.id.imageView);
       // splashImageView.setBackgroundResource(R.drawable.opologo);

       Timer timer=new Timer();
        timer.schedule(new MyTask(), 2500);
    }




    class MyTask extends TimerTask{
        @Override
        public void run(){
            Intent intent=new Intent(SplashScreen.this,Main2Activity.class);
            finish();
            startActivity(intent);
        }
    }
}
