package edu.galileo.android.twitterclient.images;

import edu.galileo.android.twitterclient.images.events.ImagesEvent;

/**
 * Created by Alex on 24-06-2016.
 */
public interface ImagesPresenter {
    void onResume();
    void onPause();
    void OnDestroy();
    void getImageTweets();
    void onEventMainThread(ImagesEvent event);
}
