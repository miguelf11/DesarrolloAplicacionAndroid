package edu.galileo.android.androidchat;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Alex on 09-06-2016.
 */
public class AndroidChatApplication extends Application{



    @Override
    public void onCreate(){
        super.onCreate();
        setupFirebase();
    }

    private void setupFirebase() {
        Firebase.setAndroidContext(this);

        /*soporte para características offline */
        Firebase.getDefaultConfig().setPersistenceEnabled(true);
    }



}
