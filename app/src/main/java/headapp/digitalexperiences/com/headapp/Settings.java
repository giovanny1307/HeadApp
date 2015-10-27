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

