package headapp.digitalexperiences.com.headapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Giovanny on 10/26/2015.
 * Plegaria pidiendo la destrucción de enemigos traicioneros
 Al músico principal; en Neginot. Masquil de David.

 55  Escucha, oh Dios, mi oración,
 Y no te escondas de mi súplica.

 2
 Está atento, y respóndeme;
 Clamo en mi oración, y me conmuevo,

 3
 A causa de la voz del enemigo,
 Por la opresión del impío;
 Porque sobre mí echaron iniquidad,
 Y con furor me persiguen.

 4
 Mi corazón está dolorido dentro de mí,
 Y terrores de muerte sobre mí han caído.

 5
 Temor y temblor vinieron sobre mí,
 Y terror me ha cubierto.

 6
 Y dije: !!Quién me diese alas como de paloma!
 Volaría yo, y descansaría.

 7
 Ciertamente huiría lejos;
 Moraría en el desierto. Selah

 8
 Me apresuraría a escapar
 Del viento borrascoso, de la tempestad.

 9
 Destrúyelos, oh Señor; confunde la lengua de ellos;
 Porque he visto violencia y rencilla en la ciudad.

 10
 Día y noche la rodean sobre sus muros,
 E iniquidad y trabajo hay en medio de ella.

 11
 Maldad hay en medio de ella,
 Y el fraude y el engaño no se apartan de sus plazas.

 12
 Porque no me afrentó un enemigo,
 Lo cual habría soportado;
 Ni se alzó contra mí el que me aborrecía,
 Porque me hubiera ocultado de él;

 13
 Sino tú, hombre, al parecer íntimo mío,
 Mi guía, y mi familiar;

 14
 Que juntos comunicábamos dulcemente los secretos,
 Y andábamos en amistad en la casa de Dios.

 15
 Que la muerte les sorprenda;
 Desciendan vivos al Seol,
 Porque hay maldades en sus moradas, en medio de ellos.

 16
 En cuanto a mí, a Dios clamaré;
 Y Jehová me salvará.

 17
 Tarde y mañana y a mediodía oraré y clamaré,
 Y él oirá mi voz.

 18
 El redimirá en paz mi alma de la guerra contra mí,
 Aunque contra mí haya muchos.

 19
 Dios oirá, y los quebrantará luego,
 El que permanece desde la antig:uedad;
 Por cuanto no cambian,
 Ni temen a Dios. Selah

 20
 Extendió el inicuo sus manos contra los que estaban en paz con él;
 Violó su pacto.

 21
 Los dichos de su boca son más blandos que mantequilla,
 Pero guerra hay en su corazón;
 Suaviza sus palabras más que el aceite,
 Mas ellas son espadas desnudas.

 22
 Echa sobre Jehová tu carga, y él te sustentará;
 No dejará para siempre caído al justo.

 23
 Mas tú, oh Dios, harás descender aquéllos al pozo de perdición.
 Los hombres sanguinarios y engañadores no llegarán a la mitad de sus días;
 Pero yo en ti confiaré.
 */


public class ScreenState extends BroadcastReceiver {
	  
	private boolean screenOff;
	  
	    @Override
	    public void onReceive(Context context, Intent intent) { 
	    	
	        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
	            screenOff = true;
		       } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
	            screenOff = false; }
				Intent i = new Intent(context, BackgroundService.class);
				i.putExtra("screen_state", screenOff);
				context.startService(i);

		}
}
	    
	