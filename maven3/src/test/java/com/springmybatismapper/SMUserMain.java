package com.springmybatismapper;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SMUserMain {


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("SMApplicationContext.xml");

        SMUserService userService = (SMUserService) context.getBean("userService");

        long start = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            SMUser user = new SMUser();
            user.setName("意大利队");
            user.setPassword(748748);
            userService.addStudent(user);
            System.out.println("第" + i  + "次插入");
        }
        SMUser user1 = new SMUser();
        user1.setName("美国队");
        user1.setPassword(886886);
        userService.addStudent(user1);
        System.out.println("第10000次插入");
        long end = System.currentTimeMillis();
        System.out.println("插入共用时：" + (end - start) + "毫秒");
    }

}