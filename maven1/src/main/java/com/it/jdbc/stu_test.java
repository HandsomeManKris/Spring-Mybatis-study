package com.it.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class stu_test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
        student t = (student) context.getBean("t");
        System.out.println(t.getName());
        System.out.println(t.getSt().getName());

    }
}
