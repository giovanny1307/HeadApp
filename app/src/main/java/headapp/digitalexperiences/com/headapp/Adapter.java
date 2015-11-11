package headapp.digitalexperiences.com.headapp;

import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import headapp.digitalexperiences.com.headapp.provider.TaskProvider;
import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 * Ven divina voluntad a pensar en mi mente a mirar en mis ojos escuchar en mis oídos hablar en mi boca a palpitar en mi corazón a circular en mi sangre a obrar en mis manos a caminar en mis pies.
 */
public class Adapter extends RecyclerView.Adapter<ViewHolder>   {



    Cursor cursor;
    int mensajeColIndex;
    int idColIndex;
    private Context contexto;
    private int lastPosition = -1;
    long idDeleted;


    //constructor
    Adapter(Context context ){
        this.contexto = context;
        setHasStableIds(true);

    }

    public void swapCursor(Cursor c){
        cursor = c;
        if(cursor != null) {
            cursor.moveToLast();
            mensajeColIndex = cursor.getColumnIndex(TaskProvider.COL_MSG);
            idColIndex = cursor.getColumnIndex(TaskProvider.COL_ID);

        }

        notifyDataSetChanged();

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(

                R.layout.lista_tarjetas,parent,false) ;

        return new ViewHolder(v,contexto);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        final Context context = holder.texto.getContext();
        final long id = getItemId(position);

        cursor.moveToPosition(position);


        holder.texto.setText(cursor.getString(mensajeColIndex));
        holder.cv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return false;
            }
        });

    }

    public void deleteMensaje(Context context, long id) {

        idDeleted = id;

        context.getContentResolver().delete(ContentUris.withAppendedId(TaskProvider.CONTENT_URI, id)
                , null, null);

    }

    public void restore(Context context,long id){


    }



    public long getItemId(int position){
        cursor.moveToPosition(position);
        return cursor.getLong(idColIndex);
    }



    @Override
    public int getItemCount() {
        return cursor!= null ? cursor.getCount():0;
    }













}
