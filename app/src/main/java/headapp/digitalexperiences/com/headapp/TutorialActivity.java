package headapp.digitalexperiences.com.headapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import headup.digitalexperiences.com.headup.R;


public class TutorialActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private Button readTutorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.tutorial_activity);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        readTutorial = (Button) findViewById(R.id.read_tutorial_button);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("Head Up Tutorial");
        }

        SharedPreferences.Editor editor = getSharedPreferences(HeadUpMain.modePreferences, MODE_PRIVATE).edit();
        editor.putInt("first_use", 1);
        editor.commit();

        readTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = getSharedPreferences(HeadUpMain.modePreferences, MODE_PRIVATE).edit();
                editor.putInt("first_use", 1);
                editor.commit();

                Intent intent = new Intent(TutorialActivity.this, HeadUpMain.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);

            }
        });


    }
}
