package core.Utility.XML;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XMLRead {
    public static String readXML(String section, String tagName) {
        try {
            File fXmlFile = new File(System.getProperty("user.dir") + "/constantsData.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(section);
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    return eElement.getElementsByTagName(tagName).item(0).getTextContent();
                }
            }
        } catch (Exception e) {
            System.out.println("MESSAGE:" + e.getMessage());
        }
        return "";
    }
}
