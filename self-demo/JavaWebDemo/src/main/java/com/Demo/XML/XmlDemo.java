package com.Demo.XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class XmlDemo {
    public static void main(String[] args) throws IOException {

        String path = XmlDemo.class.getClassLoader().getResource("Student.xml").getPath();
        Document dicument = Jsoup.parse(new File(path),"utf-8");
        Elements elements =dicument.getElementsByTag("name");
        System.out.println(elements.get(0));

    }

}
