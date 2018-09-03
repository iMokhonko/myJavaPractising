package com.imokhonko.tryingToRemember.SAX;

import java.util.List;

public class Video {

    private int id;
    private String title;
    private int duration;
    private List<String> singers;

    public Video() { /*NOP*/ }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setSingers(List<String> singers) {
        this.singers = singers;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", singers=" + singers +
                '}';
    }
}
