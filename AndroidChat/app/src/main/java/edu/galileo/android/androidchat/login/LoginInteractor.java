package edu.galileo.android.androidchat.login;

/**
 * Created by Alex on 09-06-2016.
 */
public interface LoginInteractor {
    void checkSession();
    void doSignUp(String email, String password);
    void doSignIn(String email, String password);
}
