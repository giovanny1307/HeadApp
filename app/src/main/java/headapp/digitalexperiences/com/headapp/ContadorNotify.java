package headapp.digitalexperiences.com.headapp;


import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.util.Log;

import headup.digitalexperiences.com.headup.R;

public class ContadorNotify extends CountDownTimer {

    MensajesNotificacion nombre = new MensajesNotificacion();



    private long inicio, notifyFirst, notifySecond, notifyThird;
    private Context context;
    MensajesNotificacion portador = new MensajesNotificacion();

    public ContadorNotify(long millisInFuture, long countDownInterval, long cancel, long first, long second, long thidr
                          , Context context) {
        super(millisInFuture, countDownInterval);
        inicio = cancel / 1000;
        notifyFirst = first / 1000;
        notifySecond = second / 1000;
        notifyThird = thidr / 1000;
        this.context = context;
    }

    @Override
    public void onFinish() {
        Log.d("SERVICE_ENDED", "++******* SERVICE ENDED **********++");
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //System.out.println("Seconds left: " + millisUntilFinished / 1000);
        if ((millisUntilFinished / 1000) == inicio) {
            onNotify("1");
        } else if ((millisUntilFinished / 1000) == notifyFirst) {
            onNotify("primermensaje");
        } else if ((millisUntilFinished / 1000) == notifySecond) {
            onNotify("segundomensaje");
        } else if ((millisUntilFinished / 1000) == notifyThird) {
            onNotify("tercermensaje");
        }
    }



    public void onNotify(String event) {
        if (event == "1") {
            Notificacion noti = new Notificacion(nombre.NombreDueno(HeadUpApplication.getContext()) , portador.getMensaje(), context);
            noti.Notificador();
        }
        else if (event == "primermensaje") {
            Notificacion noti = new Notificacion(HeadUpApplication.getContext().getResources().getString(R.string.titulonotificacion)  ,portador.getMensaje2(), context);
            noti.Notificador();
        } else if (event == "segundomensaje") {
            Notificacion noti = new Notificacion(HeadUpApplication.getContext().getResources().getString(R.string.titulonotificacion) , portador.getMensaje3(), context);
            noti.Notificador();
        } else if (event == "tercermensaje") {
            Notificacion noti = new Notificacion(HeadUpApplication.getContext().getResources().getString(R.string.titulonotificacion)  , portador.getMensaje4(), context);
            noti.Notificador();
        }
    }
}
