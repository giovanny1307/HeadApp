package headapp.digitalexperiences.com.headapp;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.plus.Account;

import java.util.Random;

import headup.digitalexperiences.com.headup.R;


public class HeadUpMain extends AppCompatActivity {

    private Toolbar toolbar;
    public TextView ca00;



    public static String modePreferences = "Mode_Preferences";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_up_main);




        SharedPreferences prefs = getSharedPreferences(this.modePreferences, MODE_PRIVATE);
        int firstUse = prefs.getInt("first_use", 0);

        if(firstUse <= 0) {
            // Go to Tutorial Activity
            Intent intent = new Intent(HeadUpMain.this, TutorialActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        /*
         * This is for Action Bar, we use toolbar now in these latest Android Versions, this is based on Androids Material Design.
         * Your previous app might not have this so dont get confused. If you are confused, feel free to ask me on skype.
         */
        toolbar = (Toolbar) findViewById(R.id.app_bar);


        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setTitle("Head Up");
        }

        // Setting up your own variables.
        ca00 = (TextView) findViewById(R.id.textView2);
        String randomText = updateText();
        ca00.setText(randomText);


        if (isMyServiceRunning(service.class) == false) {
            Intent serviceIntent = new Intent(HeadUpMain.this, service.class);
            startService(serviceIntent);
        }



        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("8BC8C6077565975641B15A9D60B1B2A4") // Always add a test device, you should not see your own ads or else Google Admob will block you! This is code for my specific nexus 5.
                .build();
        mAdView.loadAd(adRequest);





    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }



    public String updateText() {

        String[] mensajes = getResources().getStringArray(R.array.mensajes_pantalla5);
        String mensaje = "";
        Random random1 = new Random();
        int NumeroRandom = random1.nextInt(mensajes.length);
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_head_up_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=headup.digitalexperiences.com.headup";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share HeadUp App");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share With Friends!"));
        }

        if(id == R.id.action_info) {

            AlertDialog.Builder builder = new AlertDialog.Builder(HeadUpMain.this);
            builder.setMessage(R.string.app_info_message_two)
                    .setTitle(R.string.app_info_title)
                    .setPositiveButton(android.R.string.ok, null);
            AlertDialog dialog = builder.create();
            dialog.show();

        }
        return super.onOptionsItemSelected(item);
    }


}
