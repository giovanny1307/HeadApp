package headapp.digitalexperiences.com.headapp;

import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ActionItemTarget;
import com.github.amlcurran.showcaseview.targets.ActionViewTarget;
import com.github.amlcurran.showcaseview.targets.PointTarget;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;

import headapp.digitalexperiences.com.headapp.notificationJob.MessageNotificationJob;
import headapp.digitalexperiences.com.headapp.notificationJob.NotificationJobCreator;
import headapp.digitalexperiences.com.headapp.provider.TaskProvider;
import headup.digitalexperiences.com.headup.R;

/**
 * Created by Giovanny on 10/26/2015.
 Esta Applicacion movil va dedicada a la Virgen Maria y a Dios nuestro señor.
 Que esta aplicacion le traiga dicha y alegria a las personas que la usen y muchas bendiciones para
 ellos y para su creador.

 Dios te salve, Reina y Madre de misericordia, vida, dulzura y esperanza nuestra; Dios te salve.
 A Ti llamamos los desterrados hijos de Eva; a Ti suspiramos, gimiendo y llorando, en este valle de lágrimas.
 Ea, pues, Señora, abogada nuestra, vuelve a nosotros esos tus ojos misericordiosos; y después de este destierro muéstranos a Jesús,
 fruto bendito de tu vientre. ¡Oh clementísima, oh piadosa, oh dulce siempre Virgen María!

 V.Ruega por nosotros, Santa Madre de Dios.
 R.Para que seamos dignos de alcanzar las promesas de Nuestro Señor Jesucristo.

 Oración
 Omnipotente y sempiterno Dios, que con la cooperación del Espíritu Santo, preparaste el cuerpo y el
 alma de la gloriosa Virgen y Madre María para que fuese merecedora de ser digna morada de tu Hijo;
 concédenos que, pues celebramos con alegría su conmemoración, por su piadosa intercesión seamos liberados
 de los males presentes y de la muerte eterna. Por el mismo Cristo nuestro Señor.

 R.Amén

 */
public class HeadAppMain extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private Toolbar toolbar;
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private ImageButton mButton;
    private EditText mText;
    private Boolean estaEscribiendo = false;
    private SharedPreferences sp;
    private long mensajeId;
    private TextView blank;
    private String[] mensajes;
    private ContentResolver cr;
    private Cursor cursor;
    private Target T1;


    private int count = 0;
    private SecureRandom randommensaje = new SecureRandom();
    private SharedPreferences.OnSharedPreferenceChangeListener mListener =
            new SharedPreferences.OnSharedPreferenceChangeListener() {

                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    recreate();
                    Log.i("info", "A preference has been changed");
                }
            };

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View.OnClickListener clickListen;



        // Get the shared preferences
        SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Check if onboarding_complete is false
        if (!preferences.getBoolean("onboarding_complete", false)) {
            // Start the onboarding Activity
            Intent onboarding = new Intent(this, OnBoarding.class);
            startActivity(onboarding);

            // Close the main Activity
            finish();
            return;
        }

        // inicializar variables y layout
        setContentView(R.layout.activity_pantalla_de_entrada);


        BroadcastReceiver mReceiver = new Alarm();



        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("8BC8C6077565975641B15A9D60B1B2A4") // Always add a test device, you should not see your own ads or else Google Admob will block you! This is code for my specific nexus 5.
                .build();
        mAdView.loadAd(adRequest);


        blank = (TextView) findViewById(R.id.blankSlate);
        if(DatabaseEmpty()==true){
            blank.setVisibility(View.VISIBLE);
        }else{blank.setVisibility(View.GONE);}




        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setLogo(R.mipmap.ic_launcherhapp);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setTitle("");
        prefs = getSharedPreferences("headapp.digitalexperiences.com.headapp",MODE_PRIVATE);


        int firstUse = preferences.getInt("first_use", 0);
        if(firstUse <= 0) {
            // AutoStartAlarm
            //metodoPine();



        }


        final Animation animScale = AnimationUtils.loadAnimation(this, R.anim.animacionboton);

        getSupportLoaderManager().initLoader(0, null, this);
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        mButton = (ImageButton) findViewById(R.id.btn_send);
        mText = (EditText) findViewById(R.id.iputmensajes);

        mText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (typing() == true) {


                    mButton.setImageResource(R.mipmap.ic_sendb);
                    mButton.setAnimation(animScale);
                    mButton.startAnimation(animScale);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

                if (s.length() == 0) {
                    mButton.setAnimation(animScale);
                    mButton.startAnimation(animScale);
                    mButton.setImageResource(R.mipmap.ic_senda);
                    count = 0;
                }


            }
        });

        mText.setHint(hintText());
        mAdapter = new Adapter(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(llm);
        mRecyclerView.setAdapter(mAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(10, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return true;
            }

            @Override
            public void onSwiped(final RecyclerView.ViewHolder viewHolder, final int swipeDir) {
                //Remove swiped item from list and notify the RecyclerView
                final Long id = mAdapter.getItemId(viewHolder.getPosition());


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Yes button clicked
                                mAdapter.deleteMensaje(HeadAppMain.this, id);
                                if(DatabaseEmpty()==true){
                                    blank.setVisibility(TextView.VISIBLE);

                                }
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:

                                mAdapter.notifyItemChanged(viewHolder.getPosition());

                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(HeadAppMain.this);
                builder.setMessage(HeadAppMain.this.getString(R.string.quieres_eliminar)).setPositiveButton(HeadAppMain.this.getText(R.string.si), dialogClickListener)
                        .setNegativeButton(HeadAppMain.this.getText(R.string.no), dialogClickListener).setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        mAdapter.notifyItemChanged(viewHolder.getPosition());
                    }
                }).show();



            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View w) {



                String mensajePara_ti = mText.getText().toString();

                if (mensajePara_ti.matches("")) {
                    Toast.makeText(HeadAppMain.this, "introduce un mensaje valido",
                            Toast.LENGTH_SHORT).show();
                } else {
                    save();
                    if (DatabaseEmpty() == true) {
                        blank.setVisibility(View.VISIBLE);
                    } else {
                        blank.setVisibility(View.INVISIBLE);
                    }
                }
                mText.setText("");
            }
        });




        mText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                blank.setVisibility(View.GONE);
                return false;
            }
        });

        //metodoPine();

    }





    public boolean typing() {

        count++;
        if (mText.getText().toString() != "" && count == 1) {
            estaEscribiendo = true;
            return estaEscribiendo;
        }
        return false;


    }

    private void save() {

        String mensajeUser = mText.getText().toString();

        ContentValues values = new ContentValues();
        values.put(TaskProvider.COL_MSG, mensajeUser);

        Uri itemUri = getContentResolver().insert(TaskProvider.CONTENT_URI, values);
        mensajeId = ContentUris.parseId(itemUri);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pantalla_de_entrada, menu); //BOTONES DE MI TOOLBAR
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        //ACCIONE DE LOS BOTONES DE MI TOOLBAR
        int id = item.getItemId();

        if (id == R.id.share) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "https://play.google.com/store/apps/details?id=headup.digitalexperiences.com.headup";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getResources().getString(R.string.Comparte));
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, getResources().getString(R.string.Comparte2)));
        }
        if (id == R.id.ajustes) {
            startActivity(new Intent(this, Settings.class));
        }



        return super.onOptionsItemSelected(item);
    }



    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(HeadAppMain.this, TaskProvider.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    @Override
    protected void onResume() {
        super.onResume();
        GoneHint();
        T1 = new Target() {
            @Override
            public Point getPoint() {
                return new ViewTarget(toolbar.findViewById(R.id.ajustes)).getPoint();
            }
        };
        sp.registerOnSharedPreferenceChangeListener(mListener);
        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            new ShowcaseView.Builder(this)

                    .withMaterialShowcase()
                    .setTarget(T1)
                    .setStyle(R.style.CustomShowcaseTheme2)
                    .setContentTitle(R.string.personaliza_HeadApp)
                    .setContentText(R.string.personaliza_HeadApp2)
                    .hideOnTouchOutside()
                    .build();

            // using the following line to edit/commit prefs
            prefs.edit().putBoolean("firstrun", false).commit();
        }


    }

    @Override
    protected void onPause() {
        super.onPause();

        GoneHint();
        sp.registerOnSharedPreferenceChangeListener(mListener);
    }

    public String hintText() {
        String[] mensajes;
        mensajes = getResources().getStringArray(R.array.hints);
        int NumeroRandom = randommensaje.nextInt(mensajes.length);
        String mensaje = "";
        mensaje = mensajes[NumeroRandom];
        return mensaje;
    }


    public Boolean DatabaseEmpty() {


        mensajes = new String[]{TaskProvider.COL_MSG};
        cr = getContentResolver();
        cursor = cr.query(TaskProvider.CONTENT_URI, mensajes, null, null, null);
        if (cursor.getCount() == 0) {

            return true;
        }

        MessageNotificationJob.schedulePeriodic();

        return false;
    }

    public void GoneHint(){
        if( mText.isActivated()){
            blank.setVisibility(View.GONE);
        }
    }



    void metodoPine(){


        Date dt;
        Calendar calendario = Calendar.getInstance();


        calendario.set(calendario.HOUR_OF_DAY,9);
        calendario.set(calendario.MINUTE,0);
        calendario.set(calendario.SECOND,0);
        calendario.add(calendario.DAY_OF_YEAR, 1);

        dt = calendario.getTime();

        System.out.println("piñetime"+dt);

        Intent intent = new Intent(HeadAppMain.this, Alarm.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0,
                intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendario.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);


    }



}
