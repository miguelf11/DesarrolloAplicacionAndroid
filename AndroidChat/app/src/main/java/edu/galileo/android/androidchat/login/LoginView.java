package edu.galileo.android.androidchat.login;

/**
 * Created by Alex on 09-06-2016.
 */
public interface LoginView {
    void enableInputs();
    void disableInputs();
    void showProgress();
    void hideProgress();

    void handleSignUp();
    void handleSignIn();

    void navigateToMainScreen();
    void loginError(String error);

    void newUserSuccess();
    void NewUserError(String error);

}
