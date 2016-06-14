package edu.galileo.android.androidchat.addcontact.ui;

/**
 * Created by Alex on 14-06-2016.
 */
public interface AddContactView {
    void showInput();
    void hideInput();
    void showProgress();
    void hideProgress();

    void contactAdded();
    void contactNotAdded();

}
