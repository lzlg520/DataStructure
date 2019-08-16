package com.lzlg.interview.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DomParseDemo {
    public static void main(String[] args) {
        File xmlFile = new File("out\\production\\DataStructure\\com\\lzlg\\interview\\xml\\memo.xml");

        DocumentBuilder builder;
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {
            builder = builderFactory.newDocumentBuilder();

            Document document = builder.parse(xmlFile);

            Element root = document.getDocumentElement();

            System.out.println("根元素：" + root.getNodeName());

            NodeList childNodes = root.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node node = childNodes.item(i);
                if ("note".equals(node.getNodeName())) {
                    System.out.println("\r\n找到一篇日记，所属分类：" +
                            node.getAttributes().getNamedItem("type").getNodeValue() + "。");

                    NodeList nodeDetail = node.getChildNodes();

                    for (int j = 0; j < nodeDetail.getLength(); j++) {
                        Node detail = nodeDetail.item(j);

                        if ("name".equals(detail.getNodeName())) {
                            System.out.println("姓名：" + detail.getTextContent());
                        } else if ("sex".equals(detail.getNodeName())) {
                            System.out.println("性别：" + detail.getTextContent());
                        } else if ("date".equals(detail.getNodeName())) {
                            System.out.println("日期：" + detail.getTextContent());
                        } else if ("address".equals(detail.getNodeName())) {
                            System.out.println("居住地址：" + detail.getTextContent());
                        } else if ("telephone".equals(detail.getNodeName())) {
                            System.out.println("电话号码：" + detail.getTextContent());
                        } else if ("email".equals(detail.getNodeName())) {
                            System.out.println("E-mail：" + detail.getTextContent());
                        } else if ("body".equals(detail.getNodeName())) {
                            System.out.println("主题：" + detail.getTextContent());
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
