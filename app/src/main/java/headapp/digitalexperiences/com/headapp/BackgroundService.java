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



    SecureRandom random = new SecureRandom();
    int numeroRandom = 0;
    long valorTiempo = 0;
    String value ="";
    SharedPreferences sp;
    long Time = 0;
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
        Time = TimerTimes();
        Counter2 =  new Contador(this,Time);



    }



    public long TimerTimes(){
        sp = PreferenceManager.getDefaultSharedPreferences(HeadAppApplication.getContext());
        value = sp.getString("LISTA", "1");

        if(value.equals("1")){

            long[] array = {420000,720000,900000,1020000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }
        else if(value.equals("2")) {

            long[] array = {1200000,1380000,1500000,1800000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }
        else if(value.equals("3")) {

            long[] array = {21980000,2280000,2400000,2640000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }else{
            return 3300000;
        }


    }








    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        if (intent != null) {
            boolean screenOn = intent.getBooleanExtra("screen_state", false);
            if (!screenOn) {
                Counter2.start();
            } else {
                Counter2.cancel();
                Counter2 =  new Contador(this,TimerTimes());



            }
        }
        return START_STICKY;
    }

    public void onDestroy() {
        super.onDestroy();
        Counter2.cancel();
        stopSelf();
    }


}