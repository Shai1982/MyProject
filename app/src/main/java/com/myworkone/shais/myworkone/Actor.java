package com.myworkone.shais.myworkone;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shais on 01/08/2018.
 */

public class Actor {
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("dob")
    private String dob;
    @SerializedName("country")
    private String country;
    @SerializedName("height")
    private String height;
    @SerializedName("spouse")
    private String spouse;
    @SerializedName("children")
    private String children;
    @SerializedName("image")
    private String image;

    public Actor(String name, String description, String dob, String country, String height, String spouse, String children, String image) {
        this.name = name;
        this.description = description;
        this.dob = dob;
        this.country = country;
        this.height = height;
        this.spouse = spouse;
        this.children = children;
        this.image = image;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
