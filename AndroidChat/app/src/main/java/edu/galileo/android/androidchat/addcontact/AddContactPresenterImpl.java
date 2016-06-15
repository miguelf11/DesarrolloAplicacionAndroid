package edu.galileo.android.androidchat.addcontact;

import edu.galileo.android.androidchat.addcontact.AddContactPresenter;
import edu.galileo.android.androidchat.addcontact.events.AddContactEvent;
import edu.galileo.android.androidchat.addcontact.ui.AddContactView;

/**
 * Created by Alex on 14-06-2016.
 */
public class AddContactPresenterImpl implements AddContactPresenter {

    private AddContactView view;

    public AddContactPresenterImpl(AddContactView view) {
        this.view = view;
    }

    @Override
    public void onShow() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void addContact(String email) {

    }

    @Override
    public void onEventMainThread(AddContactEvent event) {

    }
}
