package edu.galileo.android.twitterclient.images.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.twitterclient.images.ImagesPresenter;
import edu.galileo.android.twitterclient.images.ui.ImagesFragment;
import edu.galileo.android.twitterclient.lib.di.LibsModule;

/**
 * Created by Alex on 25-06-2016.
 */
@Singleton @Component(modules = {LibsModule.class,ImagesModule.class})
public interface ImagesComponent {
    /*
        especie de API de donde se va a usar esta inyección
     */
    void inject(ImagesFragment fragment);
    ImagesPresenter getPresenter();
}
