package headapp.digitalexperiences.com.headapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Giovanny on 10/26/2015.
 * Jehová es tu guardador
 Cántico gradual.

 121  Alzaré mis ojos a los montes;
 ¿De dónde vendrá mi socorro?

 2
 Mi socorro viene de Jehová,
 Que hizo los cielos y la tierra.

 3
 No dará tu pie al resbaladero,
 Ni se dormirá el que te guarda.

 4
 He aquí, no se adormecerá ni dormirá
 El que guarda a Israel.

 5
 Jehová es tu guardador;
 Jehová es tu sombra a tu mano derecha.

 6
 El sol no te fatigará de día,
 Ni la luna de noche.

 7
 Jehová te guardará de todo mal;
 El guardará tu alma.

 8
 Jehová guardará tu salida y tu entrada
 Desde ahora y para siempre.
 */
public class Typefaces {

    String value ="";
    Context contexto;

    public Typefaces (Context ctx){

        contexto = ctx;

    }

    public String font(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(contexto);
        value = sp.getString("TYPEFACES","3");
        int foo = Integer.parseInt(value);
        String fuente;
        switch (foo){

            case 1:  fuente = "fonts/amatic.ttf";
                break;
            case 2:  fuente = "fonts/bebas.ttf";
                break;
            case 3:  fuente = "fonts/capture_it.ttf";
                break;
            case 4:  fuente = "fonts/lobster.otf";
                break;
            case 5:  fuente = "fonts/ostrich.otf";
                break;
            case 6:  fuente = "fonts/starjedi.ttf";
                break;
            case 7:  fuente = "fonts/underwood_champion.ttf";
                break;
            default: fuente = "fonts/amatic.ttf";
                break;

        }

        return fuente;

    }
}
