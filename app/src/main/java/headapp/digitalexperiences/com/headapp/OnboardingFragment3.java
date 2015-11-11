package headapp.digitalexperiences.com.headapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 * Jehová es mi luz y mi salvación
 Salmo de David.

 27  Jehová es mi luz y mi salvación; ¿de quién temeré?
 Jehová es la fortaleza de mi vida; ¿de quién he de atemorizarme?

 2
 Cuando se juntaron contra mí los malignos, mis angustiadores y mis enemigos,
 Para comer mis carnes, ellos tropezaron y cayeron.

 3
 Aunque un ejército acampe contra mí,
 No temerá mi corazón;
 Aunque contra mí se levante guerra,
 Yo estaré confiado.

 4
 Una cosa he demandado a Jehová, ésta buscaré;
 Que esté yo en la casa de Jehová todos los días de mi vida,
 Para contemplar la hermosura de Jehová, y para inquirir en su templo.

 5
 Porque él me esconderá en su tabernáculo en el día del mal;
 Me ocultará en lo reservado de su morada;
 Sobre una roca me pondrá en alto.

 6
 Luego levantará mi cabeza sobre mis enemigos que me rodean,
 Y yo sacrificaré en su tabernáculo sacrificios de júbilo;
 Cantaré y entonaré alabanzas a Jehová.

 7
 Oye, oh Jehová, mi voz con que a ti clamo;
 Ten misericordia de mí, y respóndeme.

 8
 Mi corazón ha dicho de ti: Buscad mi rostro.
 Tu rostro buscaré, oh Jehová;

 9
 No escondas tu rostro de mí.
 No apartes con ira a tu siervo;
 Mi ayuda has sido.
 No me dejes ni me desampares, Dios de mi salvación.

 10
 Aunque mi padre y mi madre me dejaran,
 Con todo, Jehová me recogerá.

 11
 Enséñame, oh Jehová, tu camino,
 Y guíame por senda de rectitud
 A causa de mis enemigos.

 12
 No me entregues a la voluntad de mis enemigos;
 Porque se han levantado contra mí testigos falsos, y los que respiran crueldad.

 13
 Hubiera yo desmayado, si no creyese que veré la bondad de Jehová
 En la tierra de los vivientes.

 14
 Aguarda a Jehová;
 Esfuérzate, y aliéntese tu corazón;
 Sí, espera a Jehová.
 */
public class OnboardingFragment3  extends Fragment {
    ColoresMa color = new ColoresMa();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        View v = inflater.inflate(R.layout.onboarding3, container, false);
        RelativeLayout layout = (RelativeLayout)v.findViewById(R.id.onboarding3);
        TextView txt = (TextView) v.findViewById(R.id.textoboard3);

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/amatic.ttf");
        txt.setTypeface(font);
        txt.setTextColor(Color.WHITE);
        txt.setText(R.string.bodyOnboarding3);
        layout.setBackgroundColor(color.getColor());
        return v;

    }
}
