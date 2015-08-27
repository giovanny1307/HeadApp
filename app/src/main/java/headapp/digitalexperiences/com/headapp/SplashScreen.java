package headapp.digitalexperiences.com.headapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import headup.digitalexperiences.com.headup.R;

public class SplashScreen extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        toolbar = (Toolbar) findViewById(R.id.app_bar);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreen.this, HeadUpMain.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, 1500); // Milliseconds for which splash screen is showed.

    }



}

