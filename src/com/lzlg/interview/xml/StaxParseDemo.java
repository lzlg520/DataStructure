package com.lzlg.interview.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;

public class StaxParseDemo {
    public static void main(String[] args) {
        File xmlFile = new File("out\\production\\DataStructure\\com\\lzlg\\interview\\xml\\memo.xml");

        readXMLByStreamReader(xmlFile);
    }

    private static void readXMLByStreamReader(File file) {
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));

            while (reader.hasNext()) {
                int type = reader.next();

                switch (type) {
                    case XMLStreamReader.START_ELEMENT:
                        System.out.print("<" + reader.getName());
                        int attrCount = reader.getAttributeCount();
                        for (int i = 0; i < attrCount; i++) {
                            System.out.print(" " + reader.getAttributeName(i) + "=\"" +
                                    reader.getAttributeValue(i) + "\"");
                        }
                        System.out.print(">");
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        System.out.print(reader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        System.out.print("</" + reader.getName() + ">");
                        break;
                    default:
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
