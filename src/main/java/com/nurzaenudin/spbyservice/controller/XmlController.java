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
    private final Logger logger=LoggerFactory.getLogger(XmlController.class);
    
    
    @GetMapping("xml")
    @ResponseBody
    public String parseSpby(){
        Spbysakti spbysakti = null;
        
        try{
            String alamat = "Students.xml";
            File xmlFile= new File(alamat);
            System.out.println(xmlFile);
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            
            NodeList studentNodes = doc.getElementsByTagName("student");
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
            
            System.out.println(doc);
            
        
        }catch (Exception ex){
            logger.error(ex.getMessage());
        }
        return "Sukses";
    
    }
}
