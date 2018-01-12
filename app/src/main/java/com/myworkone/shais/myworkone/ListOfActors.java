package com.myworkone.shais.myworkone;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by shais on 01/08/2018.
 */

public class ListOfActors {
    @SerializedName("actors")
    private List<Actor> actors;

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
