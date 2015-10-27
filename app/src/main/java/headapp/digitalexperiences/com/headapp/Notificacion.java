package headapp.digitalexperiences.com.headapp;



import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

import headup.digitalexperiences.com.headup.R;


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

