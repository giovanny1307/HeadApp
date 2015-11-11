package headapp.digitalexperiences.com.headapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 *  Salmos 18Reina-Valera 1960 (RVR1960)

 18  Te amo, oh Jehová, fortaleza mía.

 2
 Jehová, roca mía y castillo mío, y mi libertador;
 Dios mío, fortaleza mía, en él confiaré;
 Mi escudo, y la fuerza de mi salvación, mi alto refugio.

 3
 Invocaré a Jehová, quien es digno de ser alabado,
 Y seré salvo de mis enemigos.

 4
 Me rodearon ligaduras de muerte,
 Y torrentes de perversidad me atemorizaron.

 5
 Ligaduras del Seol me rodearon,
 Me tendieron lazos de muerte.

 6
 En mi angustia invoqué a Jehová,
 Y clamé a mi Dios.
 El oyó mi voz desde su templo,
 Y mi clamor llegó delante de él, a sus oídos.

 7
 La tierra fue conmovida y tembló;
 Se conmovieron los cimientos de los montes,
 Y se estremecieron, porque se indignó él.

 8
 Humo subió de su nariz,
 Y de su boca fuego consumidor;
 Carbones fueron por él encendidos.

 9
 Inclinó los cielos, y descendió;
 Y había densas tinieblas debajo de sus pies.

 10
 Cabalgó sobre un querubín, y voló;
 Voló sobre las alas del viento.

 11
 Puso tinieblas por su escondedero, por cortina suya alrededor de sí;
 Oscuridad de aguas, nubes de los cielos.

 12
 Por el resplandor de su presencia, sus nubes pasaron;
 Granizo y carbones ardientes.

 13
 Tronó en los cielos Jehová,
 Y el Altísimo dio su voz;
 Granizo y carbones de fuego.

 14
 Envió sus saetas, y los dispersó;
 Lanzó relámpagos, y los destruyó.

 15
 Entonces aparecieron los abismos de las aguas,
 Y quedaron al descubierto los cimientos del mundo,
 A tu reprensión, oh Jehová,
 Por el soplo del aliento de tu nariz.

 16
 Envió desde lo alto; me tomó,
 Me sacó de las muchas aguas.

 17
 Me libró de mi poderoso enemigo,
 Y de los que me aborrecían; pues eran más fuertes que yo.

 18
 Me asaltaron en el día de mi quebranto,
 Mas Jehová fue mi apoyo.

 19
 Me sacó a lugar espacioso;
 Me libró, porque se agradó de mí.

 20
 Jehová me ha premiado conforme a mi justicia;
 Conforme a la limpieza de mis manos me ha recompensado.

 21
 Porque yo he guardado los caminos de Jehová,
 Y no me aparté impíamente de mi Dios.

 22
 Pues todos sus juicios estuvieron delante de mí,
 Y no me he apartado de sus estatutos.

 23
 Fui recto para con él, y me he guardado de mi maldad,

 24
 Por lo cual me ha recompensado Jehová conforme a mi justicia;
 Conforme a la limpieza de mis manos delante de su vista.

 25
 Con el misericordioso te mostrarás misericordioso,
 Y recto para con el hombre íntegro.

 26
 Limpio te mostrarás para con el limpio,
 Y severo serás para con el perverso.

 27
 Porque tú salvarás al pueblo afligido,
 Y humillarás los ojos altivos.

 28
 Tú encenderás mi lámpara;
 Jehová mi Dios alumbrará mis tinieblas.

 29
 Contigo desbarataré ejércitos,
 Y con mi Dios asaltaré muros.

 30
 En cuanto a Dios, perfecto es su camino,
 Y acrisolada la palabra de Jehová;
 Escudo es a todos los que en él esperan.

 31
 Porque ¿quién es Dios sino sólo Jehová?
 ¿Y qué roca hay fuera de nuestro Dios?

 32
 Dios es el que me ciñe de poder,
 Y quien hace perfecto mi camino;

 33
 Quien hace mis pies como de ciervas,
 Y me hace estar firme sobre mis alturas;

 34
 Quien adiestra mis manos para la batalla,
 Para entesar con mis brazos el arco de bronce.

 35
 Me diste asimismo el escudo de tu salvación;
 Tu diestra me sustentó,
 Y tu benignidad me ha engrandecido.

 36
 Ensanchaste mis pasos debajo de mí,
 Y mis pies no han resbalado.

 37
 Perseguí a mis enemigos, y los alcancé,
 Y no volví hasta acabarlos.

 38
 Los herí de modo que no se levantasen;
 Cayeron debajo de mis pies.

 39
 Pues me ceñiste de fuerzas para la pelea;
 Has humillado a mis enemigos debajo de mí.

 40
 Has hecho que mis enemigos me vuelvan las espaldas,
 Para que yo destruya a los que me aborrecen.

 41
 Clamaron, y no hubo quien salvase;
 Aun a Jehová, pero no los oyó.

 42
 Y los molí como polvo delante del viento;
 Los eché fuera como lodo de las calles.

 43
 Me has librado de las contiendas del pueblo;
 Me has hecho cabeza de las naciones;
 Pueblo que yo no conocía me sirvió.

 44
 Al oír de mí me obedecieron;
 Los hijos de extraños se sometieron a mí.

 45
 Los extraños se debilitaron
 Y salieron temblando de sus encierros.

 46
 Viva Jehová, y bendita sea mi roca,
 Y enaltecido sea el Dios de mi salvación;

 47
 El Dios que venga mis agravios,
 Y somete pueblos debajo de mí;

 48
 El que me libra de mis enemigos,
 Y aun me eleva sobre los que se levantan contra mí;
 Me libraste de varón violento.

 49
 Por tanto yo te confesaré entre las naciones, oh Jehová,
 Y cantaré a tu nombre.

 50
 Grandes triunfos da a su rey,
 Y hace misericordia a su ungido,
 A David y a su descendencia, para siempre.
 */
public class OnboardingFragment1 extends Fragment {

    ColoresMa color = new ColoresMa();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle s) {

        View v = inflater.inflate(R.layout.onboarding1, container, false);
        LinearLayout layout = (LinearLayout)v.findViewById(R.id.onboarding1);
        TextView txt = (TextView) v.findViewById(R.id.texto1);
        TextView txt2 = (TextView) v.findViewById(R.id.texto2);
        TextView txt3 = (TextView) v.findViewById(R.id.texto3);
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fonts/amatic.ttf");
        txt.setTypeface(font);
        txt.setText(R.string.textoOnBoarding1Title);
        txt.setTextColor(Color.WHITE);
        txt2.setTypeface(font);
        txt2.setTextColor(Color.WHITE);
        txt2.setText(R.string.bodyOnboarding1);
        txt3.setTypeface(font);
        txt3.setTextColor(Color.WHITE);
        txt3.setText(R.string.bodyOnboarding1_2);

        layout.setBackgroundColor(color.getColor());
        return v;

    }


}