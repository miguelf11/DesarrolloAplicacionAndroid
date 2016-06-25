package edu.galileo.android.twitterclient.images;


import java.util.List;

import edu.galileo.android.twitterclient.entities.Image;

/**
 * Created by Alex on 24-06-2016.
 */
public interface ImagesView {
    void showElements();
    void hidElements();
    void showProgress();
    void hideProgress();

    void onError(String error);
    void setContent(List<Image> items);
}
