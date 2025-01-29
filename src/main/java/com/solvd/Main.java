package com.solvd;

import static com.solvd.ValidatorXML.validateXML;
import static com.solvd.XMLParser.parseXML;

public class Main {

    public static void main(String[] args) {

        String xmlPath = "src/main/resources/animals.xml";
        String xsdPath = "src/main/resources/animals.xsd";

        if (validateXML(xmlPath, xsdPath)) {
            System.out.println("XML is valid against the provided XSD schema.");
        } else {
            System.out.println("XML validation failed.");
        }
        parseXML(xmlPath);

    }


}
