package edu.galileo.android.androidchat.login;

import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by Alex on 09-06-2016.
 */
public interface LoginPresenter {
    /* presentador vinculado a la vista */
    void onCreate();
    void onDestroy();
    void checkForAunthenticatedUser();
    void validateLogin(String email,String password);
    void registerNewUser(String email, String password);
    void onEventMainThread(LoginEvent event);

}
