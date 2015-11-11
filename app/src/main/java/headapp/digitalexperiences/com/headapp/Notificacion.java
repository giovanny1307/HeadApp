package headapp.digitalexperiences.com.headapp;



import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 *
 * Salmo de David.

 103  Bendice, alma mía, a Jehová,
 Y bendiga todo mi ser su santo nombre.

 2
 Bendice, alma mía, a Jehová,
 Y no olvides ninguno de sus beneficios.

 3
 El es quien perdona todas tus iniquidades,
 El que sana todas tus dolencias;

 4
 El que rescata del hoyo tu vida,
 El que te corona de favores y misericordias;

 5
 El que sacia de bien tu boca
 De modo que te rejuvenezcas como el águila.

 6
 Jehová es el que hace justicia
 Y derecho a todos los que padecen violencia.

 7
 Sus caminos notificó a Moisés,
 Y a los hijos de Israel sus obras.

 8
 Misericordioso y clemente es Jehová;
 Lento para la ira, y grande en misericordia.

 9
 No contenderá para siempre,
 Ni para siempre guardará el enojo.

 10
 No ha hecho con nosotros conforme a nuestras iniquidades,
 Ni nos ha pagado conforme a nuestros pecados.

 11
 Porque como la altura de los cielos sobre la tierra,
 Engrandeció su misericordia sobre los que le temen.

 12
 Cuanto está lejos el oriente del occidente,
 Hizo alejar de nosotros nuestras rebeliones.

 13
 Como el padre se compadece de los hijos,
 Se compadece Jehová de los que le temen.

 14
 Porque él conoce nuestra condición;
 Se acuerda de que somos polvo.

 15
 El hombre, como la hierba son sus días;
 Florece como la flor del campo,

 16
 Que pasó el viento por ella, y pereció,
 Y su lugar no la conocerá más.

 17
 Mas la misericordia de Jehová es desde la eternidad y hasta la eternidad sobre los que le temen,
 Y su justicia sobre los hijos de los hijos;

 18
 Sobre los que guardan su pacto,
 Y los que se acuerdan de sus mandamientos para ponerlos por obra.

 19
 Jehová estableció en los cielos su trono,
 Y su reino domina sobre todos.

 20
 Bendecid a Jehová, vosotros sus ángeles,
 Poderosos en fortaleza, que ejecutáis su palabra,
 Obedeciendo a la voz de su precepto.

 21
 Bendecid a Jehová, vosotros todos sus ejércitos,
 Ministros suyos, que hacéis su voluntad.

 22
 Bendecid a Jehová, vosotras todas sus obras,
 En todos los lugares de su señorío.
 Bendice, alma mía, a Jehová.
 */


public class Notificacion {

	private Context context;
	private String title, msg ;
	private ColoresMa coloresOnboarding = new ColoresMa();

	public Notificacion(String titulo , String mensaje, Context ctx) {
		this.context = ctx;
		title = titulo;
		msg = mensaje;
	}

	public void Notificador(){

		NotificationCompat.BigTextStyle notiStyle = new NotificationCompat.BigTextStyle();
		notiStyle.setBigContentTitle(title);
		notiStyle.bigText(msg);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
				.setContentTitle(title)
				.setContentText(msg)
				.setColor(coloresOnboarding.getColor())
				.setCategory(NotificationCompat.CATEGORY_MESSAGE)
				.setPriority(NotificationCompat.PRIORITY_HIGH)
				.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
				.setSmallIcon(R.mipmap.ic_launchersmall)
				.setAutoCancel(true)
				.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcherlarge))
				.setStyle(notiStyle);
		Intent resultIntent = new Intent(context, HeadAppMain.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
		mBuilder.setContentIntent(pendingIntent);
		NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		int mId=1;
		mBuilder.setAutoCancel(true);
		//mBuilder.getNotification().flags |= Notification.FLAG_AUTO_CANCEL;
		mNotificationManager.notify(mId, mBuilder.build());

	}

}

