package headapp.digitalexperiences.com.headapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import headup.digitalexperiences.com.headup.R;


/**
 * Created by Giovanny on 10/26/2015.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView texto;
    public CardView cv;
    ColoresMa color = new ColoresMa();

    Context ctx;

    public ViewHolder (CardView itemView, Context mContex){

        super(itemView);

        ctx = mContex;
        Typefaces fontpath = new Typefaces(ctx);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);
        cv = itemView;
        cv.setRadius(10);
        cv.setCardElevation(4);
        cv.isClickable();

        cv.setUseCompatPadding(true);
        cv.setPadding(5, 5, 5, 5);
        texto = (TextView)itemView.findViewById(R.id.mensaje_para_ti);
        Typeface font = Typeface.createFromAsset(ctx.getAssets(), fontpath.font());
        texto.setTextSize(23);
        texto.setTypeface(font);
        texto.setBackgroundColor(00000000);

        if(sp.getBoolean("COLORCARDS",false)==false){
            cv.setCardBackgroundColor(ctx.getResources().getColor(R.color.colorFondoTarjetas));}
        else{cv.setCardBackgroundColor(color.getColor());}


        cv = (CardView)itemView.findViewById(R.id.cv);



    }


}
