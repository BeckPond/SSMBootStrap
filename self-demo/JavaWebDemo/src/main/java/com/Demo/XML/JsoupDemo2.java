package com.Demo.XML;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        String path = XmlDemo.class.getClassLoader().getResource("Student.xml").getPath();
        Document dicument = Jsoup.parse(new File(path),"utf-8");
//        System.out.println(dicument);

        //selector
        Elements elements = dicument.select("name");
        System.out.println(elements);
        Elements elements1 = dicument.select("student[number=\"001hao\"]>age");
        System.out.println(elements1);

    }
}
