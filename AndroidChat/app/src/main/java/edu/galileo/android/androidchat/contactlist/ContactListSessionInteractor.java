package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Alex on 12-06-2016.
 */
public interface ContactListSessionInteractor {
    void signOff();
    String getCurrentUserEmail();
    void changeConnectionStatus(boolean online);
}
