package com.example.ramanjit.spotifymetrics;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.ramanjit.spotifymetrics.JsonTypes.Top;
import com.example.ramanjit.spotifymetrics.JsonTypes.TopItem;
import com.spotify.sdk.android.authentication.AuthenticationClient;
import com.spotify.sdk.android.authentication.AuthenticationRequest;
import com.spotify.sdk.android.authentication.AuthenticationResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Properties props = new Properties();
    private String CLIENT_ID = "";
    private List<TopItem> topItemList = new ArrayList<TopItem>();
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

    public void retrofitSpotify(final String OAuth) {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Accept", "appliation/json")
                        .header("Authorization", "Bearer " + OAuth)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        SpotifyService service = retrofit.create(SpotifyService.class);
        Call<Top> top = service.getTop("artists");

        top.enqueue(new Callback<Top>() {
            @Override
            public void onResponse(Call<Top> call, Response<Top> response) {
                try {
                    for (TopItem i : response.body().getItems()) {
                        Log.d(MainActivity.class.getName(), i.getName());
                    }
                } catch (Exception e) {
                    Log.d(MainActivity.class.getName(), "uh oh");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Top> call, Throwable t) {
            }
        });
    }

    public void logoutSpotify(View view) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://accounts.spotify.com"));
        startActivity(browserIntent);
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
                    retrofitSpotify(response.getAccessToken());
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
