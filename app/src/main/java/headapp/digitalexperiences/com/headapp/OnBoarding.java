package headapp.digitalexperiences.com.headapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonFlat;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 * La dicha del perdón
 Salmo de David. Masquil.

 32  Bienaventurado aquel cuya transgresión ha sido perdonada, y cubierto su pecado.

 2
 Bienaventurado el hombre a quien Jehová no culpa de iniquidad,
 Y en cuyo espíritu no hay engaño.

 3
 Mientras callé, se envejecieron mis huesos
 En mi gemir todo el día.

 4
 Porque de día y de noche se agravó sobre mí tu mano;
 Se volvió mi verdor en sequedades de verano. Selah

 5
 Mi pecado te declaré, y no encubrí mi iniquidad.
 Dije: Confesaré mis transgresiones a Jehová;
 Y tú perdonaste la maldad de mi pecado. Selah

 6
 Por esto orará a ti todo santo en el tiempo en que puedas ser hallado;
 Ciertamente en la inundación de muchas aguas no llegarán éstas a él.

 7
 Tú eres mi refugio; me guardarás de la angustia;
 Con cánticos de liberación me rodearás. Selah

 8
 Te haré entender, y te enseñaré el camino en que debes andar;
 Sobre ti fijaré mis ojos.

 9
 No seáis como el caballo, o como el mulo, sin entendimiento,
 Que han de ser sujetados con cabestro y con freno,
 Porque si no, no se acercan a ti.

 10
 Muchos dolores habrá para el impío;
 Mas al que espera en Jehová, le rodea la misericordia.

 11
 Alegraos en Jehová y gozaos, justos;
 Y cantad con júbilo todos vosotros los rectos de corazón.
 */
public class OnBoarding extends FragmentActivity {


    private ViewPager pager;
    private SmartTabLayout indicator;
    private ButtonFlat skip;
    private ButtonFlat next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity);

        pager = (ViewPager)findViewById(R.id.pager);
        indicator = (SmartTabLayout)findViewById(R.id.indicator);
        skip = (ButtonFlat)findViewById(R.id.skip);
        next = (ButtonFlat)findViewById(R.id.next);
        next.setVisibility(View.INVISIBLE);



        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 0 : return new OnboardingFragment1();
                    case 1 : return new OnboardingFragment2();
                    case 2 : return new OnboardingFragment3();
                    default: return null;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        };
        pager.setAdapter(adapter);
        indicator.setViewPager(pager);

        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 2) {
                    skip.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);
                }else if(position==1 | position==0){
                    skip.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pager.getCurrentItem()==2)
                    finishOnboarding();
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishOnboarding();
            }
        });

    }

    private void finishOnboarding() {
        // Get the shared preferences
        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, HeadAppMain.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();
    }
}
