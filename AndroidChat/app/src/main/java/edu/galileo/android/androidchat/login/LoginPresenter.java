package edu.galileo.android.androidchat.login;

/**
 * Created by Alex on 09-06-2016.
 */
public interface LoginPresenter {
    /* presentador vinculado a la vista */
    void onDestroy();
    void checkForAunthenticatedUser();
    void validateLogin(String email,String password);
    void registerNewUser(String email, String password);


}
