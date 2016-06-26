package edu.galileo.android.twitterclient.hashtags.di;

import android.content.Context;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Session;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import edu.galileo.android.twitterclient.api.CustomTwitterApiClient;
import edu.galileo.android.twitterclient.entities.Hashtag;
import edu.galileo.android.twitterclient.hashtags.HashtagsInteractor;
import edu.galileo.android.twitterclient.hashtags.HashtagsInteractorImpl;
import edu.galileo.android.twitterclient.hashtags.HashtagsPresenter;
import edu.galileo.android.twitterclient.hashtags.HashtagsPresenterImpl;
import edu.galileo.android.twitterclient.hashtags.HashtagsRepository;
import edu.galileo.android.twitterclient.hashtags.HashtagsRepositoryImpl;
import edu.galileo.android.twitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.twitterclient.hashtags.ui.adapters.HashtagsAdapter;
import edu.galileo.android.twitterclient.hashtags.ui.adapters.OnItemClickListener;
import edu.galileo.android.twitterclient.lib.base.EventBus;

/**
 * Created by Alex on 26-06-2016.
 */
@Module
public class HashtagsModule {

    private HashtagsView view;
    private OnItemClickListener clickListener;

    public HashtagsModule(HashtagsView view, OnItemClickListener clickListener) {
        this.view = view;
        this.clickListener = clickListener;
    }

    @Provides
    @Singleton
    List<Hashtag> providesItemList(){
        return new ArrayList<Hashtag>();
    }

    @Provides
    @Singleton
    OnItemClickListener providesOnItemClickListener(){
        return this.clickListener;
    }

    @Provides
    @Singleton
    HashtagsAdapter providesAdapter(List<Hashtag> dataset,
                                  OnItemClickListener clickListener){
        return new HashtagsAdapter(dataset,clickListener);
    }

    @Provides
    @Singleton
    HashtagsPresenter providesHashtagsPresenter(HashtagsView view,
                                                EventBus eventBus,
                                                HashtagsInteractor interactor){

        return new HashtagsPresenterImpl(view,eventBus,interactor);
    }


    @Provides
    @Singleton
    HashtagsInteractor providesHashtagsInteractor(HashtagsRepository repository){
        return new HashtagsInteractorImpl(repository);
    }

    @Provides
    @Singleton
    HashtagsRepository providesHashtagsRepository(EventBus eventBus, CustomTwitterApiClient client){
        return new HashtagsRepositoryImpl(eventBus,client);
    }

    @Provides
    @Singleton
    CustomTwitterApiClient providesCustomTwitterApiClient(Session session){
        return new CustomTwitterApiClient(session);
    }

    @Provides
    @Singleton
    Session providesTwitter(){
        return Twitter.getSessionManager().getActiveSession();
    }


}
