package com.example.ramanjit.spotifymetrics;

import com.example.ramanjit.spotifymetrics.JsonTypes.Top;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shua on 11/13/16.
 */

public interface SpotifyService {
    @GET("v1/me/top/{type}")
    Call<Top> getTop(@Path("type") String type);
}
