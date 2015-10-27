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