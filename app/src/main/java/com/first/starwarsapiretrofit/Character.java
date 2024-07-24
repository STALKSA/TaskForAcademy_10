package com.first.starwarsapiretrofit;

import java.io.Serializable;

public class Character implements Serializable {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getHairColor() {
        return hair_color;
    }

    public void setHairColor(String hair_color) {
        this.hair_color = hair_color;
    }

    public String getSkinColor() {
        return skin_color;
    }

    public void setSkinColor(String skin_color) {
        this.skin_color = skin_color;
    }

    public String getEyeColor() {
        return eye_color;
    }

    public void setEyeColor(String eye_color) {
        this.eye_color = eye_color;
    }

    public String getBirthYear() {
        return birth_year;
    }

    public void setBirthYear(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
