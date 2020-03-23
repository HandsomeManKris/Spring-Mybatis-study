package com.mybatisdays;

import com.mybatisdays.dao.StudentInterfaceDao;
import com.mybatisdays.domain.StudentInterfaceImplDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


//让测试运行于spring测试环境中
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")*/
public class DaoTest {
    StudentInterfaceDao dao = new StudentInterfaceImplDao();
    //根据姓名查询的单元测试
    @Test
    public void test0(){
        List<Map<String,Object>> list = dao.findStudents("国");
        for(Map<String,Object> l:list){
            System.out.println(l);
        }
    }
   @Test
    //批量插入
    public void test1() {
        List<Object[]> batchStudent = new ArrayList<>();
       batchStudent.add(new Object[]{null, "2019-07-09 10:10:10", "2019-08-09 11:11:11","深山普", 1234567, "无线能量科学家", 20190203, "香港理工大学", 1186, "能量传输称霸6G网", "称为优秀科学家", "布鲁诺", "随便申请"});
       batchStudent.add(new Object[]{null, "2019-07-09 10:10:10", "2019-08-09 11:11:11","国振刚", 3234567, "信号分离科学家", 20190110, "西北工业大学", 1286, "物联网称霸6G网", "称为优秀企业家", "布鲁诺和代为", "奖学金"});
       dao.insertStudents(batchStudent);

    }
    @Test
    //单条插入  并且获得返回ID
    public void test2(){
       Student student = new Student();
       student.setId(22);
       long createTime = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(createTime);
       student.setCreate_at(Timestamp.valueOf(sdf.format(date)));
       student.setUpdate_at(Timestamp.valueOf(sdf.format(date)));

       student.setName("郭傻逼");
       student.setQQ(2345642);
       student.setType_job("连环池化饭");
       /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");*/
        /*try{
            Date date = sdf.parse("2008-09-10 11:11:11");
            student.setDate(date.getTime());
        }catch(ParseException e ){System.out.println("系统有异常啦");
        }finally {
            System.out.println("必经之路");
        }*/

       student.setDate("20180101");
       student.setSchool("东京理工功大学");
       student.setNumber_online(1233);
       student.setDaily("早日成仙");
       student.setDream("法力无边");
       student.setBrother("贾乃亮");
       student.setWhere_know("朋友推荐");
       dao.insertStudent(student);
        System.out.println("插入成功" + "\n"  + "插入ID为"  + student.getId());

    }
    @Test
    //单条查询
    public void test3(){
        Map<String,Object> map = dao.selectStudent(15);
        System.out.println(map);
    }
    @Test
    //全部查询
    public void test4(){
       List< Map<String,Object>> list = dao.selectStudents();
       for(Map<String,Object> l:list){
           System.out.println(l);
       }
    }
    @Test
    //单条更新
    public void test5(){
       Student student = new Student();
       student.setName("郭聪明");
       student.setId(20);
       boolean a = dao.updateStudent(student);
       System.out.println("是否成功修改:" + a);
    }
    @Test
    //单条删除
    public void test6(){
        boolean a =  dao.deleteId(20);
        System.out.println("是否成功删除:" + a);
    }
    @Test
    //单条件模糊查询
    public void test7(){
        List<Map<String,Object>> list = dao.findStudents("国");
        for(Map<String,Object> l:list){
            System.out.println(l);
        }
    }
    @Test
    //多条件模糊查询
    public  void  test8(){
       Student student = new Student();
        student.setId(5);
        student.setName("国");
        List<Map<String,Object>> list = dao.mapFindStudents(student);
        for(Map<String,Object> l:list){
            System.out.println(l);
        }
    }
}
