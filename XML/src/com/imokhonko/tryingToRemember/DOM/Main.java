package com.imokhonko.tryingToRemember.DOM;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        Document doc = getDoc(new File("youtube.xml"));

        List<Playlist> playlist = new ArrayList<>();
        parseDoc(playlist, doc);

        for (Playlist playlistItem : playlist) {
            System.out.println(playlistItem);
        }

    }

    private static Document getDoc(File file) throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file);
    }



    /*
    * this method is working
    * but it is not well structured
    * */
    private static void parseDoc(List<Playlist> playlistsList, Document doc) {
        // getting the playlist nodes
        NodeList playlists = doc.getElementsByTagName("playlist");

        // playlists
        for (int i = 0; i < playlists.getLength(); i++) {

            // current playlist
            Node playlistNode = playlists.item(i);

            // making instance for playlist item
            Playlist playlist = new Playlist();

            // creating a list of videos in current playlist
            List<Video> videos = new ArrayList<>();

            // playlist id (from attribute)
            playlist.setPlaylistId(Integer.valueOf(playlistNode.getAttributes().getNamedItem("id").getTextContent().trim()));

            if(playlistNode.getNodeType() == Node.ELEMENT_NODE) {

                if(playlistNode.hasChildNodes()) {
                    NodeList playlistNodes = playlistNode.getChildNodes();

                    // items in the playlist node
                    for (int j = 0; j < playlistNodes.getLength(); j++) {
                        Node playlistNodeItem = playlistNodes.item(j);

                        // this condition may be not used, without it everything will work
                        if(playlistNodeItem.getNodeType() == Node.ELEMENT_NODE) {

                            // checking the node names for the playlist
                            // and setting values for the fields in the playlist instance
                            switch (playlistNodeItem.getNodeName()) {

                                // getting the playlist name from node
                                case "name" : {
                                    // setting name for the playlist
                                    playlist.setName(playlistNodeItem.getTextContent().trim());
                                } break;

                                // getting the videos node where all videos are
                                case "videos" : {
                                  if(playlistNodeItem.hasChildNodes()) {
                                      NodeList videosList = playlistNodeItem.getChildNodes();

                                      // getting the particular video node in the videos
                                      for (int k = 0; k < videosList.getLength(); k++) {
                                          Node videoNode = videosList.item(k);

                                          // creating an instance for the current video
                                          Video video = new Video();

                                          if(videoNode.getNodeType() == Node.ELEMENT_NODE) {

                                              // setting id for the video
                                              video.setId(Integer.valueOf(videoNode.getAttributes().getNamedItem("id")
                                                      .getTextContent().trim()));

                                              if(videoNode.hasChildNodes()) {
                                                  NodeList videoInfo = videoNode.getChildNodes();
                                                  for (int l = 0; l < videoInfo.getLength(); l++) {
                                                      Node videoInfoItem = videoInfo.item(l);

                                                      // this condition may be not used, without it everything will work
                                                      if(videoInfoItem.getNodeType() == Node.ELEMENT_NODE) {

                                                          // checking the node name
                                                          // and setting the fields for the video instance
                                                          switch (videoInfoItem.getNodeName()) {
                                                              case "title" : {
                                                                  // setting title for video
                                                                  video.setTitle(videoInfoItem.getTextContent().trim());
                                                              } break;

                                                              case "duration": {
                                                                  // setting duration for the video
                                                                  video.setDuration(Integer.valueOf(videoInfoItem.getTextContent().trim()));
                                                              } break;

                                                              case "singers" : {
                                                                  // list of the singers in the video
                                                                  List<String> videoSingers = new ArrayList<>();

                                                                  if(videoInfoItem.hasChildNodes()) {
                                                                      NodeList singersList = videoInfoItem.getChildNodes();

                                                                      // setting singers
                                                                      setSingers(singersList, videoSingers);

                                                                      video.setSingers(videoSingers);
                                                                  }
                                                              } break;
                                                          }

                                                      }
                                                  }
                                              }
                                              // adding video to the videos list
                                              videos.add(video);
                                          }

                                      }

                                  }
                                } break;
                                
                            }

                        }

                        playlist.setVideoList(videos);

                    }

                    playlistsList.add(playlist);

                }
            }
        }
    }

    private static void setSingers(NodeList singersList, List<String> videoSingers) {
        for (int m = 0; m < singersList.getLength(); m++) {
            Node singerNode = singersList.item(m);
            // adding singer to singers list
            if(singerNode.getNodeType() == Node.ELEMENT_NODE) {
                videoSingers.add(singerNode.getTextContent().trim());
            }
        }
    }

}
