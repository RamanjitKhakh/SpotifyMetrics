package com.example.ramanjit.spotifymetrics.JsonTypes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shua on 11/13/16.
 */

public class TrackItem implements ITopItem {
    private String href;
    private String id;
    private String name;
    private int popularity;
    private String type;
    private String uri;
    private Album album;
    private List<Artist> artists = new ArrayList<Artist>();
    private int discNumber;
    private int durationMs;
    private Boolean explicit;
    private ExternalIds externalIds;
    private Boolean isPlayable;
    private String previewUrl;
    private int trackNumber;

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

    public Album getAlbum() {
        return album;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public int getDiscNumber() {
        return discNumber;
    }

    public int getDurationMs() {
        return durationMs;
    }

    public Boolean getExplicit() {
        return explicit;
    }

    public ExternalIds getExternalIds() {
        return externalIds;
    }

    public Boolean getPlayable() {
        return isPlayable;
    }

    public String getPreviewUrl() {
        return previewUrl;
    }

    public int getTrackNumber() {
        return trackNumber;
    }
}
