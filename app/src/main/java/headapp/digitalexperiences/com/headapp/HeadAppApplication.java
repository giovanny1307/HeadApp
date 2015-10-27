package headapp.digitalexperiences.com.headapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by Giovanny on 10/26/2015.
 */
public class HeadAppApplication extends Application {




    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext(){
        return mContext;
    }




}
