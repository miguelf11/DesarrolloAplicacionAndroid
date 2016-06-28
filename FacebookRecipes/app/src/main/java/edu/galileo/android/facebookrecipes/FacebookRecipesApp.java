package edu.galileo.android.facebookrecipes;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by Miguel on 27-06-2016.
 */
public class FacebookRecipesApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initFacebook();
        initDB();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        DBTearDown();
    }

    private void DBTearDown() {
        FlowManager.destroy();
    }

    private void initDB() {
        FlowManager.init(this);
    }

    private void initFacebook() {
        FacebookSdk.sdkInitialize(this);
    }
}
