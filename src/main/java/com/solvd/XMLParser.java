package com.solvd;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLParser {
    public static void parseXML(String filePath) {
        try {

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filePath));
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());


            NodeList animalList = document.getElementsByTagName("Animal");

            for (int i = 0; i < animalList.getLength(); i++) {
                Node animalNode = animalList.item(i);

                if (animalNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element animalElement = (Element) animalNode;

                    System.out.println("\n--- Animal ---");
                    System.out.println("ID: " + getTagValue("Id", animalElement));
                    System.out.println("Name: " + getTagValue("Name", animalElement));
                    System.out.println("Color: " + getTagValue("Color", animalElement));
                    System.out.println("Age: " + getTagValue("Age", animalElement));


                    if (animalElement.getElementsByTagName("Cat").getLength() > 0) {
                        Element catElement = (Element) animalElement.getElementsByTagName("Cat").item(0);
                        System.out.println("Cat Breed: " + getTagValue("Breed", catElement));
                    }


                    if (animalElement.getElementsByTagName("Health").getLength() > 0) {
                        Element healthElement = (Element) animalElement.getElementsByTagName("Health").item(0);
                        System.out.println("Health Status: " + getTagValue("HealthStatus", healthElement));
                        System.out.println("Check-Up Date: " + getTagValue("CheckUpDate", healthElement));
                    }


                    if (animalElement.getElementsByTagName("Diet").getLength() > 0) {
                        Element dietElement = (Element) animalElement.getElementsByTagName("Diet").item(0);
                        System.out.println("Feeding Schedule: " + getTagValue("FeedingSchedule", dietElement));
                    }


                    if (animalElement.getElementsByTagName("Owner").getLength() > 0) {
                        Element ownerElement = (Element) animalElement.getElementsByTagName("Owner").item(0);
                        System.out.println("Owner Name: " + getTagValue("Name", ownerElement));
                        System.out.println("Contact Info: " + getTagValue("ContactInfo", ownerElement));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "N/A";
    }
}
