package com.inja.inja2.model;

/**
 * Created by sinasix on 6/21/16.
 */
public class InjaSpot {
    private long lat;
    private long lon;

    public InjaSpot(String n, int i) {
        this.name = n;
        this.score = i;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLon() {
        return lon;
    }

    public void setLon(long lon) {
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    private String name;
    private int score;
    private long uid;
}
