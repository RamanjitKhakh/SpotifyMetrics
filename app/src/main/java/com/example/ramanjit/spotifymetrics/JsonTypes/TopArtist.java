package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public class TopArtist implements ITop {
    private List<ArtistItem> items = new ArrayList<ArtistItem>();

    public List<ArtistItem> getItems() {
        return items;
    }
}
