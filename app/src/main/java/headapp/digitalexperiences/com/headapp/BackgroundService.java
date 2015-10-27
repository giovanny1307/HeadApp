package headapp.digitalexperiences.com.headapp;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;

import java.security.SecureRandom;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class BackgroundService extends Service {

    String value = "";
    Contador Counter2;
    long tiempo = 60*1000;
    SecureRandom random = new SecureRandom();
    int numeroRandom = 0;
    long valorTiempo = 0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;}

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenState();
        registerReceiver(mReceiver, filter);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        value = sp.getString("LISTA","1");
        Counter2 = new Contador(this,TimerTimes()*tiempo);

    }

    public long TimerTimes(){

        if(value.equals("1")){

            long[] array = {5,7,9};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];
            return valorTiempo;
        }
        else if(value.equals("2")) {

            long[] array = {12,17,20};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];
            return valorTiempo;
        }
        else if(value.equals("3")) {

            long[] array = {25,33,40};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];
            return valorTiempo;
        }else{
            return 20;
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (intent != null) {
            boolean screenOn = intent.getBooleanExtra("screen_state", false);
            if (!screenOn) {
                Counter2.start();
                System.out.println("Se definieron "+TimerTimes()+" minutos");
            } else {
                Counter2.stop();
            }
        }
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        Counter2.stop();
        stopSelf();
    }


}