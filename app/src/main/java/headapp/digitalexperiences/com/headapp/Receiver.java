package headapp.digitalexperiences.com.headapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
 @Override
 public void onReceive(Context context, Intent intent) {

  if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
   Intent serviceIntent = new Intent(context, service.class);
   context.startService(serviceIntent);

  }
 }

}
