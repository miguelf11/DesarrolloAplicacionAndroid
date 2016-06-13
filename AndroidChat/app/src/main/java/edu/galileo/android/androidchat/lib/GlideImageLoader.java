package edu.galileo.android.androidchat.lib;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Alex on 12-06-2016.
 */
public class GlideImageLoader implements ImageLoader {

    private RequestManager requestManager;

    public GlideImageLoader(Context context) {
        this.requestManager = Glide.with(context);
    }

    @Override
    public void load(CircleImageView imgAvatar, String url) {
        requestManager.load(url).into(imgAvatar);
    }


}
