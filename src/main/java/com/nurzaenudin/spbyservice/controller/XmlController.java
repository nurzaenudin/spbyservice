/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.entity.Spbysakti;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nurzaenudin
 */
@Controller
public class XmlController {

    private final Logger logger = LoggerFactory.getLogger(XmlController.class);

    @GetMapping("xml")
    @ResponseBody
    public String parseSpby() {
        Spbysakti spbysakti = null;

        try {
            String alamat = "Students.xml";
            File xmlFile = new File(alamat);
            System.out.println(xmlFile);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            System.out.println(doc);

            NodeList studentNodes = doc.getElementsByTagName("student");
            System.out.println( "ini adalah student " + studentNodes.item(0));
            for (int i = 0; i < studentNodes.getLength(); i++) {
                Node studentNode = studentNodes.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    String studentId = studentElement.getElementsByTagName("id").item(0).getTextContent();
                    String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    System.out.println("Student Id = " + studentId);
                    System.out.println("Student Name = " + studentName);
                }
            }

            String alamat2 = "04101.jrpxml";
            File xmlFile2 = new File(alamat2);
            System.out.println(xmlFile2);

            DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder2 = factory.newDocumentBuilder();
            Document doc2 = builder.parse(xmlFile2);
            System.out.println(doc2);

            NodeList textNodes = doc2.getElementsByTagName("text");
            System.out.println("ini adalah text " + textNodes); 
            for (int i = 0; i < textNodes.getLength(); i++) {
//                System.out.println("+++++++");
                Node textNode = textNodes.item(i);
                if (textNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList textContentNodes = textNode.getChildNodes();
                    for (int j = 0; j < textContentNodes.getLength(); j++) {
                        if (textContentNodes.item(j).getNodeName()=="textContent"){
                            System.out.println(i + " : " + textContentNodes.item(j).getTextContent());
                        }
                        
                       
                        
                    }
                    
//                    System.out.println("=========" + textElement.getTextContent());
//                    String textContent = textElement.getElementsByTagName("textcontent");
////                    String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
////                    System.out.println("Student Id = " + studentId);
//                    System.out.println("Text content = " + textContent);
                }
            }
            

            

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return "Sukses";

    }
}
