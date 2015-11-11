package headapp.digitalexperiences.com.headapp;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Giovanny on 10/26/2015.
 * Glorifica mi alma al Señor
 y mi espíritu se llena de gozo,
 al contemplar la bondad de Dios mi Salvador.

 Porque ha puesto la mirada
 en la humilde sierva suya
 y ved aquí el motivo porque me tendrán por dichosa
 y feliz todas las generaciones.

 Pues ha hecho en mi favor
 cosas grandes y maravillosas,
 El, que es Todopoderoso
 y en su nombre infinitamente santo,
 cuya misericordia se extiende
 de generación en generación,
 a todos cuantos le temen.

 Extendió el brazo de su poder,
 disipo el orgullo de los soberbios,
 trastornando sus designios.

 Desposeyó a los poderosos
 y elevó a los humildes.

 A los necesitados los llenó de bienes
 y a los ricos los dejó sin cosa alguna.

 Exaltó a Israel su siervo acordándose de él
 por su gran misericordia y bondad.

 Así como lo había prometido
 a nuestro padre Abraham
 y a toda su descendencia
 por los siglos de los siglos.

 Amen.
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
