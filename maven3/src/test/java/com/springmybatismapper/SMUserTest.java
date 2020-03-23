package com.springmybatismapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.Resources;

//让测试运行于spring测试环境中
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:SMApplicationContext.xml")
public class SMUserTest {
    //使用@Autowired 也可以，@Resource功能更加单一，只能取出bean
    @Resource
    private SMUserMapper userMapper;
    @Resource
    private SMUserService userService;
    {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("SMApplicationContext.xml");
        userMapper = (SMUserMapper)context.getBean("userMapper");
        userService = (SMUserService)context.getBean("userServiceImpl");*/
    }
    // 查
    /*@Test
    public void selectTest() {
        System.out.println(userMapper.selectStudent(5));
    }*/
    @Test
    public void selectTest() {
        System.out.println(userMapper.selectStudent(5));
    }
     //改
    @Test
    public void updateTest() {
        SMUser user = new SMUser();
        user.setName("中国队");
        user.setPassword(666);
        user.setId(5);
        userMapper.updateStudent(user);
    }
    // 删
    @Test
    public void deleteTest() {
        userMapper.deleteStudent(2);
    }
    //增
    @Test
    public void insertTest(){
        SMUser user = new SMUser(null,"李忠龙",15678);
        userMapper.insertStudent(user);
    }
    @Test
    //查
    public void selecttest1(){
        System.out.println(userService.findStudent(3));
    }
    @Test
    // 插
    public void insertTest01() {
        SMUser user = new SMUser();
        user.setName("中国队");
        user.setPassword(656);
        userService.addStudent(user);
    }
    // 改
    @Test
    public void updateTest01() {
        SMUser user = new SMUser();
        user.setName("中国队");
        user.setPassword(666);
        user.setId(8);
        userService.updateStudent(user);
    }
    // 删
    @Test
    public void deleteTest01() {
        userService.deleteStudent(4);
    }
}
