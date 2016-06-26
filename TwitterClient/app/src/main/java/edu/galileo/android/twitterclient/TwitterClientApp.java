package edu.galileo.android.twitterclient;

import android.app.Application;
import android.support.v4.app.Fragment;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import edu.galileo.android.twitterclient.images.di.DaggerImagesComponent;
import edu.galileo.android.twitterclient.images.di.ImagesComponent;
import edu.galileo.android.twitterclient.images.di.ImagesModule;
import edu.galileo.android.twitterclient.images.ui.ImagesView;
import edu.galileo.android.twitterclient.images.ui.adapters.OnItemClickListener;
import edu.galileo.android.twitterclient.lib.di.LibsModule;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Alex on 18-06-2016.
 */
public class TwitterClientApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initFabric();
    }

    private void initFabric() {
        TwitterAuthConfig authConfig = new TwitterAuthConfig(BuildConfig.TWITTER_KEY,
                BuildConfig.TWITTER_SECRET);
        Fabric.with(this,new Twitter(authConfig));
    }

    public ImagesComponent getImagesComponent(Fragment fragment, ImagesView view, OnItemClickListener clickListener){
        return DaggerImagesComponent
                .builder()
                .libsModule(new LibsModule(fragment))
                .imagesModule(new ImagesModule(view,clickListener))
                .build();



    }
}
