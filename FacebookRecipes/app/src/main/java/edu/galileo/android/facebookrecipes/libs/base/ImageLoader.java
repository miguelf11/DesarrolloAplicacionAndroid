package edu.galileo.android.facebookrecipes.libs.base;

import android.widget.ImageView;

/**
 * Created by Alex on 18-06-2016.
 */
public interface ImageLoader {
    void load(ImageView imageView, String URL);
    void setOnFinishedImageLoadingListener(Object listener);
}
