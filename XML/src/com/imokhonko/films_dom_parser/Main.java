package com.imokhonko.films_dom_parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        File films = new File("films_dom_parser.xml");

        FilmParserXml filmParserXml = new FilmParserXml(films);
        for (Film film : filmParserXml.parseFilms()) {
            System.out.println(film);
        }

    }

}
