package headapp.digitalexperiences.com.headapp;

import android.content.Context;
import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class Contador {

    private Context contexto;
    long time;
    Timer timer;
    TimerTask timerTask;
    final Handler handler = new Handler();

    public Contador(Context ctx, long tiempo) {
        this.contexto = ctx;
        time = tiempo;
    }

    public void start() {

        timer = new Timer();
        iniciaTimerTask();
        timer.schedule(timerTask, time, time);

    }

    public void iniciaTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        Data datos = new Data(contexto);
                        datos.retriveMensajes();
                        Notificacion noti = new Notificacion(datos.prefijo()+" "+datos.NombreDueno(contexto)+" " +datos.sufijo(), datos.getMensaje(), contexto);
                        noti.Notificador();
                        System.out.println("Que los anhelos de tu corazon se hagan realidad");

                    }
                });
            }
        };

    }

    public void stop() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

}
