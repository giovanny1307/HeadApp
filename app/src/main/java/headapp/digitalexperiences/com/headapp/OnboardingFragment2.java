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
 *  Salmos 7Reina-Valera 1960 (RVR1960)

 7  Jehová Dios mío, en ti he confiado;
 Sálvame de todos los que me persiguen, y líbrame,

 2
 No sea que desgarren mi alma cual león,
 Y me destrocen sin que haya quien me libre.

 3
 Jehová Dios mío, si yo he hecho esto,
 Si hay en mis manos iniquidad;

 4
 Si he dado mal pago al que estaba en paz conmigo
 (Antes he libertado al que sin causa era mi enemigo),

 5
 Persiga el enemigo mi alma, y alcáncela;
 Huelle en tierra mi vida,
 Y mi honra ponga en el polvo. Selah

 6
 Levántate, oh Jehová, en tu ira;
 Alzate en contra de la furia de mis angustiadores,
 Y despierta en favor mío el juicio que mandaste.

 7
 Te rodeará congregación de pueblos,
 Y sobre ella vuélvete a sentar en alto.

 8
 Jehová juzgará a los pueblos;
 Júzgame, oh Jehová, conforme a mi justicia,
 Y conforme a mi integridad.

 9
 Fenezca ahora la maldad de los inicuos, mas establece tú al justo;
 Porque el Dios justo prueba la mente y el corazón.

 10
 Mi escudo está en Dios,
 Que salva a los rectos de corazón.

 11
 Dios es juez justo,
 Y Dios está airado contra el impío todos los días.

 12
 Si no se arrepiente, él afilará su espada;
 Armado tiene ya su arco, y lo ha preparado.

 13
 Asimismo ha preparado armas de muerte,
 Y ha labrado saetas ardientes.

 14
 He aquí, el impío concibió maldad,
 Se preñó de iniquidad,
 Y dio a luz engaño.

 15
 Pozo ha cavado, y lo ha ahondado;
 Y en el hoyo que hizo caerá.

 16
 Su iniquidad volverá sobre su cabeza,
 Y su agravio caerá sobre su propia coronilla.

 17
 Alabaré a Jehová conforme a su justicia,
 Y cantaré al nombre de Jehová el Altísimo.
 */
public class OnboardingFragment2 extends Fragment {

    ColoresMa color = new ColoresMa();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        View v = inflater.inflate(R.layout.onboarding2, container, false);
        RelativeLayout layout = (RelativeLayout)v.findViewById(R.id.onboarding2);
        TextView txt = (TextView) v.findViewById(R.id.textoboard2);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/amatic.ttf");
        txt.setTypeface(font);
        txt.setText(R.string.bodyOnboarding2);
        txt.setTextColor(Color.WHITE);
        layout.setBackgroundColor(color.getColor());
        return v;

    }

}