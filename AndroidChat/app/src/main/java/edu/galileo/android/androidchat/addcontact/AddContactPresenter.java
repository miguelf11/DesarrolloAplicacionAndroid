package edu.galileo.android.androidchat.addcontact;

import edu.galileo.android.androidchat.addcontact.events.AddContactEvent;

/**
 * Created by Alex on 14-06-2016.
 */
public interface AddContactPresenter {
    void onShow();
    void onDestroy();

    void addContact(String email);
    void onEventMainThread(AddContactEvent event);
}
