package headapp.digitalexperiences.com.headapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Giovanny on 12/21/2015.
 *
 *
 * Escucha la oracion de tu siervo **/


public class Alarm extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

        Data datos = new Data(context);
        datos.retriveMensajes();
        Notificacion noti = new Notificacion(datos.prefijo()+" "+datos.NombreDueno(context)+" "
                +datos.sufijo(), datos.getMensaje(), context);
        noti.Notificador();
        System.out.println("Que los anhelos de tu corazon se hagan realidad");



    }
}
