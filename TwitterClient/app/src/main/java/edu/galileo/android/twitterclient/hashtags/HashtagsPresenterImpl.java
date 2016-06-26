package edu.galileo.android.twitterclient.hashtags;

import edu.galileo.android.twitterclient.hashtags.ui.HashtagsView;
import edu.galileo.android.twitterclient.hashtags.events.HashtagsEvent;
import edu.galileo.android.twitterclient.lib.base.EventBus;

/**
 * Created by Alex on 25-06-2016.
 */
public class HashtagsPresenterImpl implements HashtagsPresenter{

    private HashtagsView view;
    private EventBus eventBus;
    private HashtagsInteractor interactor;

    public HashtagsPresenterImpl(HashtagsView view,
                                 EventBus eventBus,
                                 HashtagsInteractor interactor) {
        this.view = view;
        this.interactor = interactor;
        this.eventBus = eventBus;
    }

    @Override
    public void onResume() {
        eventBus.register(this);
    }

    @Override
    public void onPause() {
        eventBus.unregister(this);
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void getHashtagTweets() {
        if (view != null){
            view.hideImages();
            view.showProgress();
        }
        interactor.execute();
    }

    @Override
    public void onEventMainThread(HashtagsEvent event) {
        String errorMsg = event.getError();
        if (view != null){
            view.showImages();
            view.hideProgress();
            if (errorMsg != null){
                view.onError(errorMsg);
            }else {
                view.setContent(event.getHashtags());
            }
        }
    }


}
