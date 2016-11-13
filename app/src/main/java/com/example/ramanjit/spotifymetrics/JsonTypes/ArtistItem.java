package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public class ArtistItem implements ITopItem {
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private String name;
    private int popularity;
    private String type;
    private String uri;
    private Followers followers;
    private List<String> genres = new ArrayList<String>();
    private List<Image> images = new ArrayList<Image>();

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopularity() {
        return popularity;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public Followers getFollowers() { return followers; }

    public List<String> getGenres() { return genres; }
    public List<Image> getImages() { return images; }
}
