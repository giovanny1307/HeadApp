package headapp.digitalexperiences.com.headapp;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class ColoresMa {

    public String[] colores = {

            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray

    };

    public int getColor(){

        String color ="";
        Random randomgenerator = new Random();
        int randomnumber = randomgenerator.nextInt(colores.length);
        color = colores[randomnumber];
        int colorAsInt = Color.parseColor(color);
        return colorAsInt;

    }
}
