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
 * Felicidad verdadera

 1 Feliz el hombre
 que no sigue el consejo de los malvados,
 ni va por el camino de los pecadores,
 ni hace causa común con los que se burlan de Dios,
 2
 sino que pone su amor en la ley del Señor
 y en ella medita noche y día.
 3
 Ese hombre es como un árbol
 plantado a la orilla de un río,
 que da su fruto a su tiempo
 y jamás se marchitan sus hojas.
 ¡Todo lo que hace, le sale bien!

 4
 Con los malvados no pasa lo mismo,
 pues son como paja que se lleva el viento.
 5
 Por eso los malvados caerán bajo el juicio de Dios
 y no tendrán parte en la comunidad de los justos.
 6
 El Señor cuida el camino de los justos,
 pero el camino de los malos lleva al desastre.
 */
public class BackgroundService extends Service {


    Contador Counter2;

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
        Counter2 = new Contador(this);

    }



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (intent != null) {
            boolean screenOn = intent.getBooleanExtra("screen_state", false);
            if (!screenOn) {
                Counter2.start();
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