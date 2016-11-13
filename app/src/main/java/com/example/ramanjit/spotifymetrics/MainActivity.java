package com.example.ramanjit.spotifymetrics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.util.Properties;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private Properties props = new Properties();
    private String CLIENT_ID = "";
    private static final int REQUEST_CODE = 1138;
    private static final String REDIRECT_URI = "spotifymetrics://callback";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            props.load(getAssets().open("keystore.properties"));
        } catch (Exception e) {
        }
        CLIENT_ID = props.getProperty("CLIENT_ID");
        Log.d(MainActivity.class.getName(), "client key " + CLIENT_ID);
        setContentView(R.layout.activity_main);
    }

    public void loginSpotify(View view) {
        // Request code will be used to verify if result comes from the login activity. Can be set to any integer.
        AuthenticationRequest.Builder builder =
                new AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI);

        builder.setScopes(new String[]{"streaming", "user-top-read"});
        AuthenticationRequest request = builder.build();

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request);
    }

    public void retrofitSpotify() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .build();

        SpotifyService service = retrofit.create(SpotifyService.class);
        Call<ResponseBody> top = service.getTop("artist");
        Log.d(MainActivity.class.getName(), top.toString());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            AuthenticationResponse response = AuthenticationClient.getResponse(resultCode, intent);
            
            switch (response.getType()) {
                // Response was successful and contains auth token
                case TOKEN:
                    Log.d(MainActivity.class.getName(), "token received:"+response.getAccessToken());
                    //retrofitSpotify();
                    break;
                // Auth flow returned an error
                case ERROR:
                    // Handle error response
                    break;
                // Most likely auth flow was cancelled
                default:
                    // Handle other cases
            }
        }
    }



}
