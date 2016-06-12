package edu.galileo.android.androidchat.contactlist;

/**
 * Created by Alex on 12-06-2016.
 */
public interface ContactListInteractor {
    void subscribe();
    void unsubscribe();
    void destroyListener();
    void removeContact(String email);
}
