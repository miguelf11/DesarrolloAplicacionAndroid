package edu.galileo.android.twitterclient.hashtags.events;

import java.util.List;

import edu.galileo.android.twitterclient.entities.Hashtag;


/**
 * Created by Alex on 26-06-2016.
 */
public class HashtagsEvent {
    private String error;
    private List<Hashtag> hashtags;

    public List<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
