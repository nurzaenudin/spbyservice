/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.spbyservice.controller;

import com.nurzaenudin.spbyservice.entity.Spbysakti;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
//            String alamat = "Students.xml";
//            File xmlFile = new File(alamat);
//            System.out.println(xmlFile);
//
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document doc = builder.parse(xmlFile);
//            System.out.println(doc);
//
//            NodeList studentNodes = doc.getElementsByTagName("student");
//            System.out.println( "ini adalah student " + studentNodes.item(0));
//            for (int i = 0; i < studentNodes.getLength(); i++) {
//                Node studentNode = studentNodes.item(i);
//                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
//                    Element studentElement = (Element) studentNode;
//                    String studentId = studentElement.getElementsByTagName("id").item(0).getTextContent();
//                    String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
//                    System.out.println("Student Id = " + studentId);
//                    System.out.println("Student Name = " + studentName);
//                }
//            }

            String alamat2 = "01644.jrpxml";
            File xmlFile2 = new File(alamat2);
            System.out.println(xmlFile2);

            DocumentBuilderFactory factory2 = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder2 = factory2.newDocumentBuilder();
            Document doc2 = builder2.parse(xmlFile2);
            System.out.println(doc2);

            NodeList textNodes = doc2.getElementsByTagName("text");
            System.out.println("ini adalah text " + textNodes);
            List spbyText = new ArrayList();
            for (int i = 0; i < textNodes.getLength(); i++) {
//                System.out.println("+++++++");
                Node textNode = textNodes.item(i);
                if (textNode.getNodeType() == Node.ELEMENT_NODE) {
                    NodeList textContentNodes = textNode.getChildNodes();
                    int jmlText = textContentNodes.getLength();

                    for (int j = 0; j < jmlText; j++) {
                        if (textContentNodes.item(j).getNodeName() == "textContent") {
                            System.out.println(i + " : " + textContentNodes.item(j).getTextContent());
                            spbyText.add(textContentNodes.item(j).getTextContent());

                        }

                    }

//                    System.out.println("=========" + textElement.getTextContent());
//                    String textContent = textElement.getElementsByTagName("textcontent");
////                    String studentName = studentElement.getElementsByTagName("name").item(0).getTextContent();
////                    System.out.println("Student Id = " + studentId);
//                    System.out.println("Text content = " + textContent);
                }
            }
            System.out.println("ini spbyText: " + spbyText);
            int jmlSPBYText=spbyText.size();
            System.out.println("jumlah isi list: " + jmlSPBYText);
            
            String nomorMemo = spbyText.get(4).toString();
            String tanggalMemo = spbyText.get(3).toString();
            String nilaiBersih = spbyText.get(12).toString();
//                        String akunPPH= spbyText.get(44).toString();
//                        String nilaiPPH= spbyText.get(43).toString();
//                        String akunPPN= spbyText.get(46).toString();
//                        String nilaiPPN= spbyText.get(45).toString();
            String jumlahPengeluaran = spbyText.get(jmlSPBYText - 17).toString();
            String jumlahPotongan = spbyText.get(jmlSPBYText - 18).toString();
            String nipPPK = spbyText.get(jmlSPBYText - 13).toString();
            String PPK = spbyText.get(jmlSPBYText - 12).toString();
            String supplier = spbyText.get(jmlSPBYText - 3).toString();
            String npwpSupplier = spbyText.get(jmlSPBYText - 4).toString();
            String alamatSupplier = spbyText.get(jmlSPBYText - 5).toString();
            String provinsi = spbyText.get(jmlSPBYText - 1).toString();
            String kota = spbyText.get(jmlSPBYText - 2).toString();
                        
            System.out.println("nomorMemo: " + nomorMemo);
            System.out.println("tanggalMemo: " + tanggalMemo);
            System.out.println("nilaiBersih: " + nilaiBersih);
            
            System.out.println("ppk: "+PPK);
            System.out.println("nipPPK: " + nipPPK);
            
            System.out.println("jumlah Pengeluaran: " + jumlahPengeluaran);
            System.out.println("jumlah Potongan: "+ jumlahPotongan);
            
            System.out.println("npwpsupplier: "+ npwpSupplier);
            System.out.println("supplier: "+ supplier);
            System.out.println("alamat supplier: " + alamatSupplier);
            System.out.println("provinsi: " + provinsi);
            System.out.println("kota: "+ kota);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return "Sukses";

    }
}
