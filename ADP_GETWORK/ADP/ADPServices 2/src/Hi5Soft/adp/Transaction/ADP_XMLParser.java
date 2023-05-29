/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hi5Soft.adp.Transaction;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author saravanan
 */
public class ADP_XMLParser {

    HashMap<String, String> mMap;
    ArrayList< HashMap<String, String>> aAlist;

    public ADP_XMLParser() {

    }

    public void testParser() {
        try {

            File fXmlFile = new File("D:\\test1.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("vendorWorks");

            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;

                        // address 
                    Node persionAddressNode = eElement.getNextSibling();
                    Element pElement = (Element) nNode;
                    mMap = new HashMap<String, String>();
                    aAlist = new ArrayList< HashMap<String, String>>();
                    NodeList nInnerList = pElement.getElementsByTagName("productAttributes");
                    for (int temp1 = 0; temp1 < nInnerList.getLength(); temp1++) {
                        Node nInerNode = nInnerList.item(temp1);
                        if (nInerNode.getNodeType() == Node.ELEMENT_NODE) {

                            Element eInerElement = (Element) nInerNode;
                            
                            // attribute
                            HashMap<String, String> tempMap = new HashMap<String, String>();
                            tempMap.put("name", eInerElement.getElementsByTagName("name").item(0).getTextContent());
                            tempMap.put("value", eInerElement.getElementsByTagName("value").item(0).getTextContent());
                            aAlist.add(tempMap);

                            System.out.println("First Name : " + eInerElement.getElementsByTagName("name").item(0).getTextContent());
                        }

                    }

//<personIdentifier>
                    //System.out.println("Staff id : " + eElement.getAttribute("id"));
                    //  Node.ENTITY_NODE
                    int cnt = 0;

                    mMap.put("batchDate", eElement.getElementsByTagName("batchDate").item(0).getTextContent());
                    mMap.put("addressLine1", pElement.getElementsByTagName("addressLine1").item(0).getTextContent());
                    mMap.put("addressLine2", pElement.getElementsByTagName("addressLine1").item(0).getTextContent());
                    mMap.put("city", pElement.getElementsByTagName("city").item(0).getTextContent());
                    mMap.put("state", pElement.getElementsByTagName("state").item(0).getTextContent());
                    mMap.put("zipCode", pElement.getElementsByTagName("zipCode").item(0).getTextContent());

                    // persion Info
                    mMap.put("dateOfBirth", pElement.getElementsByTagName("dateOfBirth").item(0).getTextContent());
                    mMap.put("firstName", pElement.getElementsByTagName("firstName").item(0).getTextContent());
                  //  mMap.put("gender", pElement.getElementsByTagName("gender").item(0).getTextContent());
                    mMap.put("lastName", pElement.getElementsByTagName("lastName").item(0).getTextContent());
                    mMap.put("middleName", pElement.getElementsByTagName("middleName").item(0).getTextContent());
                    mMap.put("race", pElement.getElementsByTagName("race").item(0).getTextContent());
                    mMap.put("ssn", pElement.getElementsByTagName("ssn").item(0).getTextContent());

                    // product name
                    mMap.put("productName", pElement.getElementsByTagName("productName").item(0).getTextContent());
                    mMap.put("productGroup", pElement.getElementsByTagName("productGroup").item(0).getTextContent());
                    mMap.put("sassRefString", pElement.getElementsByTagName("sassRefString").item(0).getTextContent());

                    System.out.println("First Name : " + eElement.getElementsByTagName("batchDate").item(0).getTextContent());
                    System.out.println("Last Name : " + pElement.getElementsByTagName("addressLine1").item(0).getTextContent());
			//System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
                    //System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

                }
                DataBaseHandler d= new DataBaseHandler();
                d.statrtDataBaseHandler(mMap, aAlist);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

}
