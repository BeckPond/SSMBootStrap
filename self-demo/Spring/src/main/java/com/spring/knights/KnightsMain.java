package com.spring.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightsMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
    }
}
