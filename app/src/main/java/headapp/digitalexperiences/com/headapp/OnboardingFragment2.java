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