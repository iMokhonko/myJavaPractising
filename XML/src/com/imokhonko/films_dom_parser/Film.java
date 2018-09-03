package com.imokhonko.films_dom_parser;

import java.util.List;

public class Film {

    private final String title;
    private final short year;
    private final List<Actor> actors;

    public Film(String title, short year, List<Actor> actors) {
        this.title = title;
        this.year = year;
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public short getYear() {
        return year;
    }

    public List<Actor> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", actors=" + actors +
                '}';
    }
}
