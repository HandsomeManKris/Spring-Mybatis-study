package com.springmybatismapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


//让测试运行于spring测试环境中
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:SMApplicationContext.xml")
public class StudentTest {
    //使用@Autowired 也可以，@Resource功能更加单一，只能取出bean

   // @Resource
    private StudentService userService;
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("SMApplicationContext.xml");
        //userMapper = (StudentMapper)context.getBean("userMapper");
        userService = (StudentService)context.getBean("userService");
    }



    @Test
    //查
    public void selecttest1(){
        System.out.println(userService.findStudent(24));
    }
    @Test
    // 插
    public void insertTest01() {
        Student student = new Student();
        //student.setId();
        student.setCreate_at(System.currentTimeMillis());
        student.setUpdate_at(System.currentTimeMillis());
        student.setName("刘聪明");
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
        System.out.println("插入成功" + "\n"  + "插入ID为"  + student.getId());
    }
    // 改
    @Test
    public void updateTest01() {
        Student student = new Student();
        student.setName("郭聪明");
        student.setId(25);
        boolean a =  userService.updateStudent(student);
        System.out.println("是否成功修改:" + a);
    }
    // 删
    @Test
    public void deleteTest01() {
        boolean a = userService.deleteStudent(23);
        System.out.println("是否成功删除:" + a);
    }
}
