package com.imokhonko.tryingToRemember.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class ParserHandler extends DefaultHandler {

    private List<Playlist> playlists;

    // current node name
    private String currentElem = "";

    // current playlist
    private Playlist currentPlaylist;

    // current video
    private Video currentVideo;
    // current videos (for the playlist method that takes only list)
    private List<Video> currentPlaylistVideos;

    // current singers
    private List<String> currentSingers;

    ParserHandler(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    @Override
    public void startDocument() {
        System.out.println("parsing started.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        currentElem = qName;

        switch (currentElem) {
            // create new playlist
            case "playlist" : {
                currentPlaylist = new Playlist();
                int playlistId = Integer.valueOf(attributes.getValue("id"));
                currentPlaylist.setPlaylistId(playlistId);
            } break;

            // create list for the videos in the playlist
            case "videos" : {
                currentPlaylistVideos = new ArrayList<>();
            } break;

            // create new video and set id from attributes
            case "video" : {
                currentVideo = new Video();
                int videoId = Integer.valueOf(attributes.getValue("id"));
                currentVideo.setId(videoId);
            } break;

            // create new list of singers in the video/song
            case "singers" : {
                currentSingers = new ArrayList<>();
            } break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String value = new String(ch, start, length).trim();

        if(value.length() == 0)
            return;

        switch (currentElem) {
            // playlist name
            case "name" : {
                currentPlaylist.setName(value);
            } break;

            // video title
            case "title" : {
                currentVideo.setTitle(value);
            } break;

            // video duration
            case "duration" : {
                int videoDuration = Integer.valueOf(value);
                currentVideo.setDuration(videoDuration);
            } break;

            case "singer" : {
                currentSingers.add(value);
            } break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        switch (qName) {

            // adding singers to the video
            case "singers" : {
                currentVideo.setSingers(currentSingers);
                currentSingers = null;
            } break;

            // adding video to the playlist of videos
            case "video" : {
                currentPlaylistVideos.add(currentVideo);
                currentVideo = null;
            } break;

            // adding the list of videos to the playlist
            case "videos" : {
                currentPlaylist.setVideoList(currentPlaylistVideos);
                currentPlaylistVideos = null;
            } break;

            // adding list of videos to the playlist
            case "playlist" : {
                playlists.add(currentPlaylist);
                currentPlaylist = null;
            } break;
        }
    }

    @Override
    public void endDocument() {
        System.out.println("parsing ended.");
    }
}
