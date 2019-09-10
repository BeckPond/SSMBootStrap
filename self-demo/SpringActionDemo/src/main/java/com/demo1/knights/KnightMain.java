package com.demo1.knights;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class KnightMain {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("E:\\gitest\\self-demo\\SpringActionDemo\\src\\main\\resources\\knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
    }
}
