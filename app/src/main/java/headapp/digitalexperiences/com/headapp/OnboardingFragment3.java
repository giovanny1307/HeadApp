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
