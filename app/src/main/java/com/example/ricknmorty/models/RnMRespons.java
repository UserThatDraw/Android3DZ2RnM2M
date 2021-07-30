package com.example.ricknmorty.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class RnMRespons<T> {
    @SerializedName("info")
    private Info info;
    @SerializedName("results")
    private ArrayList<T> results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public ArrayList<T> getResults() {
        return results;
    }

    public void setResults(ArrayList<T> results) {
        this.results = results;
    }
}
