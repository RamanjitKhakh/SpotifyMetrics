package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */
public class Album {
    private String albumType;
    private ExternalUrls externalUrls;
    private String href;
    private String id;
    private List<Image> images = new ArrayList<Image>();
    private String name;
    private String type;
    private String uri;

    public String getAlbumType() {
        return albumType;
    }

    public ExternalUrls getExternalUrls() {
        return externalUrls;
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

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }
}
