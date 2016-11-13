package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public class Top {
    private List<TopItem> items = new ArrayList<TopItem>();

    public List<TopItem> getItems() {
        return items;
    }
}
