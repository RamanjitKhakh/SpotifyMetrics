package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public class TopTrack implements ITop {
    private List<TrackItem> items = new ArrayList<TrackItem>();

    public List<TrackItem> getItems() {
        return items;
    }
}
