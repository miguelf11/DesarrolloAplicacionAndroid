package edu.galileo.android.twitterclient.hashtags.di;

import javax.inject.Singleton;

import dagger.Component;
import edu.galileo.android.twitterclient.hashtags.ui.HashtagsFragment;
import edu.galileo.android.twitterclient.lib.di.LibsModule;

/**
 * Created by Miguel on 26-06-2016.
 */
@Singleton @Component(modules = {LibsModule.class,HashtagsModule.class})
public interface HashtagsComponent {
    /*
    especie de API de donde se va a usar esta inyección
 */
    void inject(HashtagsFragment fragment);
}
