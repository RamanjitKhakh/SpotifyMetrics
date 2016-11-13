package com.example.ramanjit.spotifymetrics;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by shua on 11/13/16.
 */

public interface SpotifyService {
    @GET("v1/me/top/artist");
    Call<ResponseBody> getTop(@Headers("Authorization") String OAuth);
}
