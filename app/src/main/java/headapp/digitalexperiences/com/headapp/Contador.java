package headapp.digitalexperiences.com.headapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;

import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Giovanny on 10/26/2015.
 *
 * * Maria reina celestial y señora de todo lo creado, a quien Dios concedió la plenitud del poder sobre
 * todos los demonios y sobre toda fuerza tenebrosa, con el corazón oprimido te entregó todo mi ser.
 * inmaculada concepción, rompe en mi toda tentación.
 * corredentora con Cristo, purificame de todo vestigio de pecado.
 * Terror de los demonios, te suplicó ejercer tu poder atemorizante sobre toda fuerza tenebrosa que me amenaza.

 Más poderosa tu Señora, yo te suplico, ordena a los demonios que me atormentan, me desaniman,
 me inquietan en espíritu, me quitan toda paz de corazon, me paralizan en las trampas del miedo,
 del temor y de todo estado de ánimo sombrío y que me conducen al pecado y al vicio, que se postren
 a tus pies para ser castigados y humillados por ti.

 Ordenarles alabar y glorificar Tu poder sobre ellos y que arrodillados a tus pies confiesen que Tú eres su señora.

 Para mi completa liberación me consagró a Ti completamente, incondicionalmente y eternamente y proclamó
 con todos los Ángeles y santos tu ilimitado y avasallador poder sobre todos los demonios y sobre todos sus planes e intrigas.

 * Maria poderosa Señora de las almas protegeme.
 * Maria, poderosa Señora de las almas, liberame.
 * Maria, poderosa Señora de las almas gobierna sobre mi y mi vida.
 * Maria, poderosa Señora de las almas, gobierna sobre toda fuerza tenebrosa.

 Durante la gestación de esta oración MARIA dijo: " A toda alma que con amor sincero y en la más profunda
 confianza me consagre esta oración de liberación, le primero la liberación del poder de Satanás.
 A toda alma que diariamente me la consagre, le primero un crecimiento rápido en todas las virtudes,
 pues yo encontrar complacencia en someter los demonios al pleno efecto de Mi poder en el camino por la vida de esa alma."

 */
public class Contador {

    private Context contexto;
    String value ="";
    SecureRandom random = new SecureRandom();
    int numeroRandom = 0;
    long valorTiempo = 0;
    private Handler handler = new Handler();


    public Contador(Context ctx) {
        this.contexto = ctx;


    }

    public long TimerTimes(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(contexto);
        value = sp.getString("LISTA","2");

        if(value.equals("1")){

            long[] array = {1020000,1380000,1500000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }
        else if(value.equals("2")) {

            long[] array = {1800000,1980000,2200000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }
        else if(value.equals("3")) {

            long[] array = {2820000,3180000,4200000};
            numeroRandom = random.nextInt(array.length);
            valorTiempo = array[numeroRandom];

            return valorTiempo;
        }else{
            return 20;
        }


    }


    public void start() {
        handler.postDelayed(runnable, TimerTimes());

    }

    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Data datos = new Data(contexto);
            datos.retriveMensajes();
            Notificacion noti = new Notificacion(datos.prefijo()+" "+datos.NombreDueno(contexto)+" "
                    +datos.sufijo(), datos.getMensaje(), contexto);
            noti.Notificador();
            System.out.println("Que los anhelos de tu corazon se hagan realidad");
            System.out.println("Se definieron " + valorTiempo/(60*1000) + " minutos");
            handler.postDelayed(this,TimerTimes());
        }
    };


    public void stop() {
       handler.removeCallbacks(runnable);
    }




}
