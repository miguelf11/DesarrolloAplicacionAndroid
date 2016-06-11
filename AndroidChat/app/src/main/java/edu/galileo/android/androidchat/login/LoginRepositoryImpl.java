package edu.galileo.android.androidchat.login;

import android.util.Log;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

import javax.security.auth.login.LoginException;

import de.greenrobot.event.EventBus;
import edu.galileo.android.androidchat.domain.FirebaseHelper;
import edu.galileo.android.androidchat.entities.User;
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
    private Firebase dataReference;
    private Firebase myUserReference;


    public LoginRepositoryImpl() {
        this.helper = FirebaseHelper.getInstance();
        this.dataReference = helper.getDataReference();
        this.myUserReference = helper.getMyUserReference();

    }

    @Override
    public void signUp(final String email, final String password) {
        dataReference.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> stringObjectMap) {
                postEvent(LoginEvent.onSignUpSuccess);
                signIn(email, password);
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignUpError, firebaseError.getMessage());
            }
        });

    }

    @Override
    public void signIn(String email, String password) {
        dataReference.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                myUserReference = helper.getMyUserReference();
                myUserReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User currentUser = dataSnapshot.getValue(User.class);
                        if(currentUser == null){
                            String email = helper.getAuthUserEmail();
                            if(email != null){
                                currentUser = new User();
                                myUserReference.setValue(currentUser);
                            }
                        }
                        helper.changeUserConnectionStatus(User.ONLINE);
                        postEvent(LoginEvent.onSignInSuccess);
                    }

                    @Override
                    public void onCancelled(FirebaseError firebaseError) {}
                });

            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                postEvent(LoginEvent.onSignInError,firebaseError.getMessage());
            }
        });

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
