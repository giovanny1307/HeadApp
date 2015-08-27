package headapp.digitalexperiences.com.headapp;

/**
 * Created by Giovanny on 7/3/2015.
 */

        import android.app.Application;
        import android.content.Context;


public class HeadUpApplication extends Application {

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