package headapp.digitalexperiences.com.headapp;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.util.Log;

import java.security.SecureRandom;
import java.util.Random;

import headup.digitalexperiences.com.headup.R;


public class MensajesNotificacion {

    SecureRandom randommensaje = new SecureRandom();

    public String getMensaje() {
        String[] mensajes;
        mensajes = HeadUpApplication.getContext().getResources().getStringArray(R.array.mensajes_pantalla);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;

    }

    public String getMensaje2() {
        String[] mensajes;
        mensajes = HeadUpApplication.getContext().getResources().getStringArray(R.array.mensajes_pantalla2);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }
    public String getMensaje3() {
        String[] mensajes;
        mensajes = HeadUpApplication.getContext().getResources().getStringArray(R.array.mensajes_pantalla3);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }
    public String getMensaje4() {
        String[] mensajes;
        mensajes = HeadUpApplication.getContext().getResources().getStringArray(R.array.mensajes_pantalla4);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }

    public String NombreDueno(Context contexto){



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
        return parte1;

    }
}
