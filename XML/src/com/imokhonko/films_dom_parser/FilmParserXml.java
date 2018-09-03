package com.imokhonko.films_dom_parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FilmParserXml {

    File file = null;

    public FilmParserXml(File file) {
        this.file = file;
    }

    public List<Film> parseFilms() throws IOException, SAXException, ParserConfigurationException {

        List<Film> filmsList = new ArrayList<>();

        Document doc = getXml();

        NodeList films = doc.getElementsByTagName("film");

        for (int i = 0; i < films.getLength(); i++) {
            Node film = films.item(i);
            if(film.hasChildNodes()) {
                NodeList filmInfo = film.getChildNodes();

                String filmTitle = "";
                short filmYear = 0;
                List<Actor> filmActors = new ArrayList<>();

                for (int j = 0; j < filmInfo.getLength(); j++) {
                    Node infoItem = filmInfo.item(j);
                    if(infoItem.getNodeType() == Node.ELEMENT_NODE) {

                        switch (infoItem.getNodeName()) {

                            case "title" : {
                                filmTitle = infoItem.getTextContent().trim();
                                break;
                            }
                            case "year" : {
                                filmYear = Short.valueOf(infoItem.getTextContent().trim());
                                break;
                            }
                            case "actors" : {
                                NodeList actors = infoItem.getChildNodes();
                                for (int k = 0; k < actors.getLength(); k++) {
                                    Node actor = actors.item(k);
                                    if(actor.getNodeType() == Node.ELEMENT_NODE) {
                                        Element actorElem = (Element) actor;
                                        String actorName = actorElem.getTextContent().trim();
                                        filmActors.add(new Actor(actorName));
                                    }
                                }
                                break;
                            }

                        }

                    }
                }
                filmsList.add(new Film(filmTitle, filmYear, filmActors));
            }
        }

        return filmsList;

    }

    private Document getXml() throws ParserConfigurationException, IOException, SAXException {
        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder()
                .parse(file);

    }

}
