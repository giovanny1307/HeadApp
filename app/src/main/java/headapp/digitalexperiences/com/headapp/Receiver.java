package headapp.digitalexperiences.com.headapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Giovanny on 10/26/2015.
 *  Salmos 23Reina-Valera 1960 (RVR1960)
 Jehová es mi pastor
 Salmo de David.

 23  Jehová es mi pastor; nada me faltará.

 2
 En lugares de delicados pastos me hará descansar;
 Junto a aguas de reposo me pastoreará.

 3
 Confortará mi alma;
 Me guiará por sendas de justicia por amor de su nombre.

 4
 Aunque ande en valle de sombra de muerte,
 No temeré mal alguno, porque tú estarás conmigo;
 Tu vara y tu cayado me infundirán aliento.

 5
 Aderezas mesa delante de mí en presencia de mis angustiadores;
 Unges mi cabeza con aceite; mi copa está rebosando.

 6
 Ciertamente el bien y la misericordia me seguirán todos los días de mi vida,
 Y en la casa de Jehová moraré por largos días.
 */

public class Receiver extends BroadcastReceiver {
 @Override
 public void onReceive(Context context, Intent intent) {

  if (intent.getAction().equalsIgnoreCase(Intent.ACTION_BOOT_COMPLETED)) {
   Intent serviceIntent = new Intent(context, BackgroundService.class);
   context.startService(serviceIntent);

  }
 }

}
