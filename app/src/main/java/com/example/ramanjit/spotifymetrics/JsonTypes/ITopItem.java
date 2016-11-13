package com.example.ramanjit.spotifymetrics.JsonTypes;

/**
 * Created by shua on 11/13/16.
 */

public interface ITopItem {
    String getHref();
    String getId();
    String getName();
    int getPopularity();
    String getType();
    String getUri();
}
