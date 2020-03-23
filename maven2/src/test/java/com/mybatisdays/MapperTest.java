package com.mybatisdays;

import com.mybatisdays.dao.StudentInterfaceMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class MapperTest {
    //    使用工厂SqlSession生产对象
    SqlSession session;
    StudentInterfaceMapper studentMapper;
    @Before
    public void before() throws IOException {
        System.out.println("before......获取session");
        // 读取配置文件
        InputStream iS = Resources.getResourceAsStream("mybatisConfig.xml");
        // 通过SqlSessionFactoryBuilder创建SqlSessionFactory会话工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(iS);
        session = sessionFactory.openSession();
    }
    @After
    public void after(){
        session.close();
        System.out.println("after......连接关闭");
    }
    @Test
    public void test01(){
        //添加一条信息
        //      使用SqlSession创建dao接口的代理对象
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        long createTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(createTime);
        Student student1 = new Student(null,Timestamp.valueOf(sdf.format(date)),
                Timestamp.valueOf(sdf.format(date)), "中国队",666666,
                "JAVA工程师", "2019-07-12",    "NBA职业技术学院",8888,
                "看到洛杉矶凌晨四点的太阳","世界杯冠军","无","央视");
        Student student2 = new Student( null,Timestamp.valueOf(sdf.format(date)),Timestamp.valueOf(sdf.format(date)),"美国队",123456,"乒乓球",
                "2019-09-09","氰化物倒楼技术学院",1324,"每天进步一点","活在当下","孙悟空","" +
                "58同城");
        studentMapper.insertStudent(student1);
        System.out.println("插入成功" + "\n"  + "插入ID为"  + student1.getId());
        studentMapper.insertStudent(student2);
        System.out.println("插入成功" + "\n"  + "插入ID为"  + student2.getId());
        session.commit();
    }
    @Test
    public  void test02(){
        //通过ID精确查询一条信息
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        Student stu = studentMapper.selectStudent(12);
        System.out.println(stu);
        session.commit();
    }
    @Test
    public  void test03(){
        //更新一条信息
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        Student stu = new Student();
        stu.setName("沈善普");
        stu.setType_job("加学科");
        stu.setId(3);
        studentMapper.updateStudent(stu);
        session.commit();
    }
    @Test
    public void test04(){
        //删除一条数据
        studentMapper = session.getMapper( StudentInterfaceMapper.class);
        studentMapper.deleteId(3);
        session.commit();
    }
    @Test
    public void test05(){
        //模糊查询，通过姓名查询单元测试
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        List<Student> stu = studentMapper.findStudents("国");
        for(Student l:stu){
            System.out.println(l);
        }
        session.commit();

    }
    @Test
    public  void test06(){
        //全部查询
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        List<Student> stu = studentMapper.selectStudents();
        for(Student l:stu){
            System.out.println(l);
        }
        session.commit();

    }
    @Test
    public void test07(){
        //多条查询成功
        studentMapper = session.getMapper(StudentInterfaceMapper.class);
        Student stu = new Student();
        stu.setId(4);
        stu.setName("国");
        List<Student> l = studentMapper.mapFindStudents(stu);
        for(Student L:l){
            System.out.println(L);
        }
        session.commit();




    }
}
