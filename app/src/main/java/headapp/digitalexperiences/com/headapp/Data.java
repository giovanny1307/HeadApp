package headapp.digitalexperiences.com.headapp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;

import java.security.SecureRandom;
import java.util.ArrayList;

import headapp.digitalexperiences.com.headapp.provider.TaskProvider;
import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 * pero los que confían en el Señor tendrán siempre nuevas fuerzas y podrán volar como las águilas; podrán correr sin cansarse y caminar sin fatigarse
 *isaias 40:31
 *
 */
public class Data {

    public ArrayList<String> lista = new ArrayList<String>();
    public String[] MensajeUsuario;
    public String name;

    private Context ctx;

    public Data (Context base){
        this.ctx = base;
    }

    public String[] retriveMensajes(){
        lista.clear();
        String[] mensajes = new String[]{TaskProvider.COL_MSG};
        ContentResolver cr = ctx.getContentResolver();

        Cursor cursor = cr.query(TaskProvider.CONTENT_URI, mensajes, null, null, null);

        cursor.moveToFirst();


        while (cursor.isAfterLast()== false) {

            String mensaje = cursor.getString(1);
            lista.add(mensaje);
            cursor.moveToNext();

            String[] ArrayMensajes = new String[lista.size()];
            ArrayMensajes = lista.toArray(ArrayMensajes);
            MensajeUsuario = ArrayMensajes;

        }

        return MensajeUsuario;

    }

    SecureRandom randommensaje = new SecureRandom();

    public String getMensaje() {
        if(MensajeUsuario!=null){

            int NumeroRandom = randommensaje.nextInt(MensajeUsuario.length);
            String mensaje = "";
            mensaje = MensajeUsuario[NumeroRandom];

            return mensaje;}else{

            String[] mensajes;
            mensajes = ctx.getResources().getStringArray(R.array.mensajes_precargados);
            int NumeroRandom = randommensaje.nextInt(mensajes.length);
            String mensaje = "";
            mensaje = mensajes[NumeroRandom];
            return mensaje;
        }

    }

    public String NombreDueno(Context contexto){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ctx);

        name = sp.getString("NOMBRE","");

        if(name.length()==0){

            final String[] projection = new String[]
                    { ContactsContract.Profile.DISPLAY_NAME };
            String name = " ";
            String division[];
            String parte1 = " ";

            final Uri dataUri = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, ContactsContract.Contacts.Data.CONTENT_DIRECTORY);
            final ContentResolver contentResolver = contexto.getContentResolver();
            final Cursor c = contentResolver.query(dataUri, projection, null, null, null);

            try
            {
                if (c.moveToFirst())
                {
                    name = c.getString(c.getColumnIndex(ContactsContract.Profile.DISPLAY_NAME));
                    division = name.split(" ");
                    parte1 = division[0];
                }
            }
            finally
            {
                c.close();
            }
            System.out.println(name);

            return parte1;}

        else

        {return name;}

    }



    public String prefijo(){

        String[] mensajes;
        mensajes = ctx.getResources().getStringArray(R.array.prefijos);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }

    public String sufijo(){

        String[] mensajes;
        mensajes = ctx.getResources().getStringArray(R.array.sufijos);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }


}