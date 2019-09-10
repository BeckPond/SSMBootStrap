package com.Demo.XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;

public class xpath {
    public static void main(String[] args) {
        String path = XmlDemo.class.getClassLoader().getResource("Student.xml").getPath();
        Document dicument = Jsoup.parse(new File(path),"utf-8");
    }
}
