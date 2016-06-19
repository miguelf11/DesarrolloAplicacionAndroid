package edu.galileo.android.twitterclient.api;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterApiClient;

/**
 * Created by Alex on 18-06-2016.
 */
public class CustomTwitterApiClient extends TwitterApiClient {
    public CustomTwitterApiClient(Session session) {
        super(session);
    }

    public TimelineService getTimelineService() {
        return getService(TimelineService.class);
    }

    
}
