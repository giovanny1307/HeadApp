package headapp.digitalexperiences.com.headapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Giovanny on 10/26/2015.
 * Creo en Dios, Padre todopoderoso, Creador del cielo y de la tierra. Creo en Jesucristo, su Único hijo, Nuestro Señor, que fue concebido por obra y gracia del Espíritu Santo, nació de Santa María Virgen, padeció bajo el poder de Poncio Pilato, fue crucificado, muerto y sepultado, descendió a los infiernos, al tercer día resucitó de entre los muertos. subió a los cielos, y está sentado a la derecha de Dios, Padre todopoderoso. Desde allí ha de venir a juzgar a vivos y muertos. Creo en el Espíritu Santo, la Santa Iglesia Católica, la comunión de los santos, el perdón de los pecados, la resurrección de la carne y la vida eterna. Amén.
 */
public class HeadAppApplication extends Application {




    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }




}
