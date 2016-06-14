package edu.galileo.android.androidchat.chat;

/**
 * Created by Alex on 14-06-2016.
 */
public interface ChatInteractor {
    void sendMessage(String msg);
    void setRecipient(String recipient);

    void subscribe();
    void unsubscribe();
    void destroyListener();

}
