package com.imokhonko;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathMain {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {

        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = documentBuilder.parse(new File("youtube.xml"));

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();

        XPathExpression expression = xPath.compile("/playlists/playlist/videos/video[duration > '200']/singers[count(singer) > 2]");

        NodeList nodes = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);

        for(int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);

            if(item.hasChildNodes()) {
                NodeList children = item.getChildNodes();
                for(int j = 0; j < children.getLength(); j++) {
                    Node childItem = children.item(j);
                    if(childItem.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(childItem.getTextContent());
                    }
                }
            }
        }

    }

}
