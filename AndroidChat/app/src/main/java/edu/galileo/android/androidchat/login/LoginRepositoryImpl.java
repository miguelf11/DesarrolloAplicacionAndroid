package edu.galileo.android.androidchat.login;

import android.util.Log;

import com.firebase.client.Firebase;

import javax.security.auth.login.LoginException;

import de.greenrobot.event.EventBus;
import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.lib.GreenRobotEventBus;
import edu.galileo.android.androidchat.login.events.LoginEvent;

/**
 * Created by Alex on 10-06-2016.
 */
public class LoginRepositoryImpl implements LoginRepository {
    /*define los metodos del repositorio
        el repositorio es el que sabe que estamos trabajando
        con firebase  */

    private FirebaseHelper helper;

    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
    }

    @Override
    public void signUp(String email, String password) {
        postEvent(LoginEvent.onSignUpSuccess);
    }

    @Override
    public void signIn(String email, String password) {
        postEvent(LoginEvent.onSignInSuccess);
    }

    @Override
    public void checkSession() {
        postEvent(LoginEvent.onFailedToRecoverSession);
    }

    private void postEvent(int type,String errorMessage){
        LoginEvent loginEvent = new LoginEvent();
        loginEvent.setEventType(type);
        if(errorMessage != null){
            loginEvent.setErrorMessage(errorMessage);
        }
        edu.galileo.android.androidchat.lib.EventBus eventBus;
        eventBus = GreenRobotEventBus.getInstance();
        eventBus.post(loginEvent);
    }


    private void postEvent(int type){
        postEvent(type,null);
    }
}
