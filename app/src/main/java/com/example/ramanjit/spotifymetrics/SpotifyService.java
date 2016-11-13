package com.example.ramanjit.spotifymetrics;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shua on 11/13/16.
 */

public interface SpotifyService {
    @GET("v1/me/top/{type}")
    Call<ResponseBody> getTop(@Path("type") String type);
}
