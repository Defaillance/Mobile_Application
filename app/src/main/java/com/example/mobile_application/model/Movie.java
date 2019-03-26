package com.example.mobile_application.model;

public class Movie {
    private String title;
    private String director;
    private Integer release_date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }
    public Integer getRelease_date() {
        return release_date;
    }
    public void setRelease_date(Integer release_date){
        this.release_date = release_date;
    }
}
