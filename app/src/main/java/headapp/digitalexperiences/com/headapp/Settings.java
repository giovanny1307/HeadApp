package headapp.digitalexperiences.com.headapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.SwitchPreference;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 * Una herencia escogida
 Mictam de David.

 16  Guárdame, oh Dios, porque en ti he confiado.

 2
 Oh alma mía, dijiste a Jehová:
 Tú eres mi Señor;
 No hay para mí bien fuera de ti.

 3
 Para los santos que están en la tierra,
 Y para los íntegros, es toda mi complacencia.

 4
 Se multiplicarán los dolores de aquellos que sirven diligentes a otro dios.
 No ofreceré yo sus libaciones de sangre,
 Ni en mis labios tomaré sus nombres.

 5
 Jehová es la porción de mi herencia y de mi copa;
 Tú sustentas mi suerte.

 6
 Las cuerdas me cayeron en lugares deleitosos,
 Y es hermosa la heredad que me ha tocado.

 7
 Bendeciré a Jehová que me aconseja;
 Aun en las noches me enseña mi conciencia.

 8
 A Jehová he puesto siempre delante de mí;
 Porque está a mi diestra, no seré conmovido.

 9
 Se alegró por tanto mi corazón, y se gozó mi alma;
 Mi carne también reposará confiadamente;

 10
 Porque no dejarás mi alma en el Seol,
 Ni permitirás que tu santo vea corrupción.

 11
 Me mostrarás la senda de la vida;
 En tu presencia hay plenitud de gozo;
 Delicias a tu diestra para siempre.
 */
public class Settings extends PreferenceActivity {
    SwitchPreference pref1;
    SwitchPreference pref2;
    SwitchPreference pref3;
    Preference dialogPreference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        LinearLayout root = (LinearLayout) findViewById(android.R.id.list).getParent().getParent().getParent();
        Toolbar bar = (Toolbar) LayoutInflater.from(this).inflate(R.layout.settings_toolbar, root, false);
        root.addView(bar, 0); // insert at top
        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        addPreferencesFromResource(R.xml.preferences);

        dialogPreference =  getPreferenceScreen().findPreference("dialog_preference");
        dialogPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                // dialog code here
                AlertDialog.Builder builder = new AlertDialog.Builder(Settings.this);
                builder.setMessage(getString(R.string.fuentesfonts))
                        .setTitle(getString(R.string.creditos))
                        .setPositiveButton(android.R.string.ok, null);
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });

    }


}

