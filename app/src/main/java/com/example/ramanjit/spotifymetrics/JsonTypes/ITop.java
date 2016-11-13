package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public interface ITop {
    List<? extends ITopItem> getItems();
}
