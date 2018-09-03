package com.imokhonko.tryingToRemember.DOM;

import java.util.List;

public class Playlist {

    private int playlistId;
    private String name;
    private List<Video> videoList;

    public Playlist() {/*NOP*/}

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "playlistId=" + playlistId +
                ", name='" + name + '\'' +
                ", videoList=" + videoList +
                '}';
    }
}
