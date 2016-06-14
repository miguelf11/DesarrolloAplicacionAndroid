package edu.galileo.android.androidchat.chat;

import edu.galileo.android.androidchat.chat.events.ChatEvent;

/**
 * Created by Alex on 14-06-2016.
 */
public interface ChatPresenter {
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void sendMessage(String msg);
    void onEventMainThread(ChatEvent event);

}
