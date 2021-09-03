package com.example.ricknmorty.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class RnMLocations {

    @PrimaryKey
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("type")
    public String type;

    @SerializedName("dimension")
    public String dimension;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RnMLocations that = (RnMLocations) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(dimension, that.dimension);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, dimension);
    }
}
