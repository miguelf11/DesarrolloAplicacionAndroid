package edu.galileo.android.androidchat.login;

import android.util.Log;

import com.firebase.client.Firebase;

import javax.security.auth.login.LoginException;

import edu.galileo.android.androidchat.domain.FirebaseHelper;

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
        //Log.e("LoginRepositoryImpl","signup");
        Log.e("LoginRepositoryImpl","signup");
    }

    @Override
    public void signIn(String email, String password) {
        //Log.e("LoginRepositoryImpl","signin");
        Log.e("LoginRepositoryImpl","signin");
    }

    @Override
    public void checkSession() {
        Log.e("LoginRepositoryImpl","check session");
    }
}
