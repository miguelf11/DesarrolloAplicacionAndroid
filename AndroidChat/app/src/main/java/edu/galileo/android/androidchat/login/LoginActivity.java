package edu.galileo.android.androidchat.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.galileo.android.androidchat.R;

public class LoginActivity extends AppCompatActivity {


    @Bind(R.id.editTxtEmail)
    EditText inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSignin)
    public void handleSignin(){
        //Log.e("AndroidChat",inputEmail.getText().toString());
    }

    @OnClick(R.id.btnSignup)
    public void handleSignup(){
    }
}
