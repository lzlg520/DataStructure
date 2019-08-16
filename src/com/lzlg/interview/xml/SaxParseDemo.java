package com.lzlg.interview.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxParseDemo {
    public static void main(String[] args) {
        File xmlFile = new File("out\\production\\DataStructure\\com\\lzlg\\interview\\xml\\memo.xml");

        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(xmlFile, new MySaxListener());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MySaxListener extends DefaultHandler {

    private String content;

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = new String(ch, start, length);
    }

    /**
     * 当解析到元素的结束标签时触发
     *
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if ("name".equals(qName)) {
            System.out.println("姓名：" + content);
        } else if ("sex".equals(qName)) {
            System.out.println("性别：" + content);
        } else if ("date".equals(qName)) {
            System.out.println("日期：" + content);
        } else if ("address".equals(qName)) {
            System.out.println("居住地址：" + content);
        } else if ("telephone".equals(qName)) {
            System.out.println("电话号码：" + content);
        } else if ("email".equals(qName)) {
            System.out.println("电子邮件：" + content);
        } else if ("body".equals(qName)) {
            System.out.println("主题：" + content);
        }
    }

    /**
     * 当解析到元素的开始标签时触发
     *
     * @param uri
     * @param localName
     * @param qName
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("note".equals(qName)) {
            System.out.println("下面是一个关于SAX的解析方式：");
            System.out.println("\r\n找到一篇文章，所属分类：" + attributes.getValue("type") + "。");
        }
    }
}