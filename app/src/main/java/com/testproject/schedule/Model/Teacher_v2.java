package com.testproject.schedule.Model;

public class Teacher_v2 {

    private String short_name;
    private String name;
    private String position;
    private String imageUrl;

    public Teacher_v2(String short_name, String name, String position, String imageUrl) {
        this.short_name = short_name;
        this.name = name;
        this.position = position;
        this.imageUrl = imageUrl;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
