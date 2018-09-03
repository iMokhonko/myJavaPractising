package com.imokhonko.sax;


import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        List<ScheduleItem> sheduleItems = new ArrayList<>();

        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        XmlHandler xmlHandler = new XmlHandler(sheduleItems);
        saxParser.parse(new File("sax.xml"), xmlHandler);

        for (ScheduleItem sheduleItem : sheduleItems) {
            System.out.println(sheduleItem);
        }

    }

}
