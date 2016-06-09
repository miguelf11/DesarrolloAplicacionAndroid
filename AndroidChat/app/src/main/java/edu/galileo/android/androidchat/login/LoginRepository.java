package edu.galileo.android.androidchat.login;

/**
 * Created by Alex on 09-06-2016.
 */
public interface LoginRepository {
    /* interacción con Firebase */
    void signUp(String email, String password);
    void signIn(String email, String password);
    void checkSession();
}
