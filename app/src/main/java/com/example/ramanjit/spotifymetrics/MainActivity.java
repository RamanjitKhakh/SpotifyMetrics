package com.example.ramanjit.spotifymetrics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    private Properties props = new Properties();
    private String CLIENT_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            props.load(getAssets().open("keystore.properties"));
        } catch (Exception e) {
        }
        Log.d(MainActivity.class.getName(), CLIENT_ID);
        setContentView(R.layout.activity_main);
    }

    public void loginSpotify(View view) {
        // Request code will be used to verify if result comes from the login activity. Can be set to any integer.
        final int REQUEST_CODE = 1337;
        final String REDIRECT_URI = "spotifymetrics://callback";

        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);

        builder.setScopes(new String[]{"streaming"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);
    }
}
