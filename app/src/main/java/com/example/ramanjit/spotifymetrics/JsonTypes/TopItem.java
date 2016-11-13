package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by shua on 11/13/16.
 */

public class TopItem {
    private ExternalUrls externalUrls;
    private Followers followers;
    private List<String> genres = new ArrayList<String>();
    private String href;
    private String id;
    private List<Image> images = new ArrayList<Image>();
    private String name;
    private int popularity;
    private String type;
    private String uri;

    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    public Followers getFollowers() {
        return followers;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getHref() {
        return href;
    }

    public String getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
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
}
