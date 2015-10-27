package headapp.digitalexperiences.com.headapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class Typefaces {

    String value ="";
    Context contexto;

    public Typefaces (Context ctx){

        contexto = ctx;

    }

    public String font(){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(contexto);
        value = sp.getString("TYPEFACES","1");
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
            case 6:  fuente = "fonts/ostrich_regular.ttf";
                break;
            case 7:  fuente = "fonts/underwood_champion.ttf";
                break;
            default: fuente = "fonts/amatic.ttf";
                break;

        }

        return fuente;

    }
}
