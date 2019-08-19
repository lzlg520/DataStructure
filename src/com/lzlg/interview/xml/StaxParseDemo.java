package com.lzlg.interview.xml;

import javax.xml.stream.*;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.util.StreamReaderDelegate;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class StaxParseDemo {
    public static void main(String[] args) {
        File xmlFile = new File("out\\production\\DataStructure\\com\\lzlg\\interview\\xml\\memo.xml");

//        readXMLByStreamReader(xmlFile);

//        readXMLByEventReader(xmlFile);

//        readXMLByEventReaderWithFilter(xmlFile);

        readXMLByStreamReaderDelegate(xmlFile);
    }

    private static XMLInputFactory factory = XMLInputFactory.newInstance();

    private static void readXMLByStreamReader(File file) {
        try {

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

    private static void readXMLByEventReader(File file) {
        try {
            XMLEventReader reader = factory.createXMLEventReader(new FileInputStream(file));

            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();

                if (event.isStartElement()) {
                    System.out.print("<" + event.asStartElement().getName());
                    Iterator<Attribute> attributeIterator = event.asStartElement().getAttributes();

                    while (attributeIterator.hasNext()) {
                        Attribute attribute = attributeIterator.next();
                        System.out.print(" " + attribute.getName() + "=\"" + attribute.getValue() + "\"");
                    }
                    System.out.print(">");
                } else if (event.isCharacters()) {
                    System.out.print(event.asCharacters().getData());
                } else if (event.isEndElement()) {
                    System.out.print("</" + event.asEndElement().getName() + ">");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 过滤到只有note标签
     *
     * @param file
     */
    private static void readXMLByEventReaderWithFilter(File file) {
        try {
            XMLEventReader r = factory.createXMLEventReader(new FileInputStream(file));

            XMLEventReader reader = factory.createFilteredReader(r, e -> {
                if (e.isStartElement()) {
                    String name = e.asStartElement().getName() + "";
                    return "note".equals(name);
                }
                return false;
            });


            while (reader.hasNext()) {
                XMLEvent event = reader.nextEvent();

                if (event.isStartElement()) {
                    System.out.print("<" + event.asStartElement().getName());
                    Iterator<Attribute> attributeIterator = event.asStartElement().getAttributes();

                    while (attributeIterator.hasNext()) {
                        Attribute attribute = attributeIterator.next();
                        System.out.print(" " + attribute.getName() + "=\"" + attribute.getValue() + "\"");
                    }
                    System.out.print(">");
                } else if (event.isCharacters()) {
                    System.out.print(event.asCharacters().getData());
                } else if (event.isEndElement()) {
                    System.out.print("</" + event.asEndElement().getName() + ">");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 过滤内容，只留标签
     *
     * @param file
     */
    private static void readXMLByStreamReaderDelegate(File file) {
        try {

            XMLStreamReader r = factory.createXMLStreamReader(new FileInputStream(file));

            XMLStreamReader reader = new StreamReaderDelegate(r) {
                @Override
                public int next() throws XMLStreamException {
                    while (true) {
                        if (super.hasNext()) {
                            int type = super.next();
                            if (type == XMLStreamReader.START_ELEMENT) {
                                return type;
                            } else if (type == XMLStreamReader.END_ELEMENT) {
                                return type;
                            } else {
                                continue;
                            }
                        } else {
                            return XMLStreamReader.END_DOCUMENT;
                        }
                    }
                }
            };

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
