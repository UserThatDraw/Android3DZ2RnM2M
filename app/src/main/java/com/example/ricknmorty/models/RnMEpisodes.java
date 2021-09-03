package com.example.ricknmorty.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class RnMEpisodes {

    @PrimaryKey
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RnMEpisodes that = (RnMEpisodes) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(date, that.date) && Objects.equals(episode, that.episode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date, episode);
    }
}
