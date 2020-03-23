package com.springmybatismapper;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SMUserMain {


    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("SMApplicationContext.xml");

        StudentService userService = (StudentService) context.getBean("userService");

        long start = System.currentTimeMillis();
        for (int i = 1; i < 10; i++) {
            Student student = new Student();
            //student.setId();
            student.setCreate_at(System.currentTimeMillis());
            student.setUpdate_at(System.currentTimeMillis());
            student.setName("郭傻逼");
            student.setQQ(2345642);
            student.setType_job("连环池化饭");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date date = sdf.parse("2008-09-10 11:11:11");
                student.setDate(date.getTime());
            }catch(ParseException e ){System.out.println("系统有异常啦");
            }finally {
                System.out.println("必经之路");
            }

            //student.setDate("20180101");
            student.setSchool("东京理工功大学");
            student.setNumber_online(1233);
            student.setDaily("早日成仙");
            student.setDream("法力无边");
            student.setBrother("贾乃亮");
            student.setWhere_know("朋友推荐");
            userService.addStudent(student);
            System.out.println("第" + i  + "次插入");
            System.out.println("插入成功" + "\n"  + "插入ID为"  + student.getId());

        }

        long end = System.currentTimeMillis();
        System.out.println("插入共用时：" + (end - start) + "毫秒");
    }

}