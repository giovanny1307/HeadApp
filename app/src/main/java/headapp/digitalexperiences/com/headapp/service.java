package headapp.digitalexperiences.com.headapp;


import android.app.ActivityManager;
import android.app.Service;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.IBinder;


import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.SyncStateContract;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class service extends Service {

    public static final String USAGE_STATS_SERVICE = "usagestats";

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new RecibeOnOff();
        registerReceiver(mReceiver, filter);


    }

    long tiempo = 60 * 60 * 1000;



    ContadorNotify Counter1 = new ContadorNotify(tiempo, 1000,  3570000,
            1800000,  900000, 3000,
           this);



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (intent != null) {
            boolean screenOn = intent.getBooleanExtra("screen_state", false);
            if (!screenOn) {
                Counter1.start();
            } else {
                Counter1.cancel();
            }
        }
        return START_STICKY;
    }



    public void onDestroy() {
        super.onDestroy();
    }
}