package com.example.ramanjit.spotifymetrics;

import com.example.ramanjit.spotifymetrics.JsonTypes.ITop;
import com.example.ramanjit.spotifymetrics.JsonTypes.TopArtist;
import com.example.ramanjit.spotifymetrics.JsonTypes.TopTrack;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by shua on 11/13/16.
 */

public interface SpotifyService {
    @GET("v1/me/top/artists")
    Call<TopArtist> getTopArtists();

    @GET("v1/me/top/tracks")
    Call<TopTrack> getTopTracks();
}
