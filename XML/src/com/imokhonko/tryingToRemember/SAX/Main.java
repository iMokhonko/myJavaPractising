package com.imokhonko.tryingToRemember.SAX;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();

        List<Playlist> playlists = new ArrayList<>();

        ParserHandler parserHandler = new ParserHandler(playlists);
        saxParser.parse(new File("youtube.xml"), parserHandler);

        for (Playlist playlist : playlists) {
            System.out.println(playlist);
        }

    }

}
