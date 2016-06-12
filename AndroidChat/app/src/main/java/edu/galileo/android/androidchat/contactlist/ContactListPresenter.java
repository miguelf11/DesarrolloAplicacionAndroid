package edu.galileo.android.androidchat.contactlist;

import edu.galileo.android.androidchat.contactlist.events.ContactListEvent;

/**
 * Created by Alex on 12-06-2016.
 */
public interface ContactListPresenter {
    /* pausar y resumir conección con firebase */
    void onPause();
    void onResume();
    void onCreate();
    void onDestroy();

    void signOff();
    String getCurrentUserEmail();
    void removeContact(String email);

    /*maneja eventos recibidos */
    void onEventMainThread(ContactListEvent event);




}
