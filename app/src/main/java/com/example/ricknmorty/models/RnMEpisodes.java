package com.example.ricknmorty.models;

import com.google.gson.annotations.SerializedName;

public class RnMEpisodes {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("air_date")
    public String date;

    @SerializedName("episode")
    public String episode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

}
