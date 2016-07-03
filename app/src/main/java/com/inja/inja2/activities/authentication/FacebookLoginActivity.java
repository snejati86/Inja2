package com.inja.inja2.activities.authentication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.inja.inja2.InjaApplication;
import com.inja.inja2.R;
import com.inja.inja2.activities.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sinasix on 6/23/16.
 */
public class FacebookLoginActivity extends Activity {

    @Inject
    CallbackManager callbackManager;

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }

    @BindView(R.id.login_button)
    LoginButton loginButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode,resultCode,data);
    }

    /**
     * Tag to identify.
     */
    private static final String TAG = FacebookLoginActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
        setContentView(R.layout.facebook_login_activitiy);
        ButterKnife.bind(this);
        InjaApplication.ComponentSingleton.getGraphComponent().inject(this);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                finish();
            }

            @Override
            public void onCancel() {
                // DO NOTHING
            }

            @Override
            public void onError(FacebookException error) {
                // DO NOTHING
            }
        });
        if ( isLoggedIn()){
            startActivity(new Intent(getBaseContext(),MainActivity.class));
            finish();
        }

    }

}
