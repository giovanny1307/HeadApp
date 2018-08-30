package headapp.digitalexperiences.com.headapp.notificationJob;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.evernote.android.job.JobRequest;

import java.util.concurrent.TimeUnit;

import headapp.digitalexperiences.com.headapp.Data;
import headapp.digitalexperiences.com.headapp.HeadAppMain;
import headapp.digitalexperiences.com.headapp.Notificacion;

public class MessageNotificationJob extends Job {

    public static final String TAG = "Notification sending job";


    @NonNull
    @Override
    protected Result onRunJob(@NonNull Params params) {

        PendingIntent pi = PendingIntent.getActivity(getContext(), 0,
                new Intent(getContext(), HeadAppMain.class), 0);

        Context context = getContext();

        Data datos = new Data(context);
        datos.retriveMensajes();
        Notificacion noti = new Notificacion(datos.prefijo()+" "+datos.NombreDueno(context)+" "
                +datos.sufijo(), datos.getMensaje(), context);
        noti.Notificador();

        return Result.SUCCESS;
    }

    public  static void schedulePeriodic() {
        new JobRequest.Builder(MessageNotificationJob.TAG)
                .setPeriodic(TimeUnit.MINUTES.toMillis(15), TimeUnit.MINUTES.toMillis(5))
                .setUpdateCurrent(true)
                .build()
                .schedule();
    }
}
