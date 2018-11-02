package com.imokhonko;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;

public class MainTwo {

    public static void main(String[] args) throws ParserConfigurationException, TransformerException, FileNotFoundException {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element rootElem = doc.createElement("users");
        Element user = doc.createElement("user");

        Element name = doc.createElement("name");
        Text nameValue = doc.createTextNode("Ivan");

        Element age = doc.createElement("age");
        Text ageValue = doc.createTextNode("Ivan");

        doc.appendChild(rootElem);

        // set user node to users
        rootElem.appendChild(user);
        user.setAttribute("id", "1");

        // set name and value to user node
        user.appendChild(name);
        name.appendChild(nameValue);

        // set age and value to user node
        user.appendChild(age);
        age.appendChild(ageValue);

        // create file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        StreamResult result = new StreamResult(new File("users.xml"));
        transformer.transform(source, result);

    }

}
