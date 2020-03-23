package com.it.Baomingtie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.it.jdbc.Employee;
import com.it.jdbc.Jdbc_test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class Jnshu_test {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;

    {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
    }
    /**
     * 测试批量更新操作
     * 最后一个参数是 Object[] 的 List 类型：因为修改一条记录需要一个 Object 数组，修改多条记录就需要一个 List 来存放多个数组。
     */
    @Test
    public void test1(){
        String sql = "insert into baomingtie2(id,name,QQ,type_job,date,school,number_online,daily,dream,brother,where_know) values(?,?,?,?,?,?,?,?,?,?,?)";
        List<Object[]> batchit = new ArrayList<>();
        batchit.add(new Object[] {null,"深山普",1234567,"无线能量科学家",20190203,"香港理工大学",1186,"能量传输称霸6G网","称为优秀科学家","布鲁诺","随便申请"});
        jdbcTemplate.batchUpdate(sql,batchit);
        batchit.add(new Object[] {null,"国振刚",3234567,"信号分离科学家",20190110,"西北工业大学",1286,"物联网称霸6G网","称为优秀企业家","布鲁诺和代为","奖学金"});
        jdbcTemplate.batchUpdate(sql,batchit);
    }
    //插入时间数据
   @Test
    public void test2(){
        String sql = "insert into baomingtie2(create_at,update_at) values(?,?)";
        List<Object[]> batchit = new ArrayList<>();
        batchit.add(new Object[] {"2019-09-09 10;10;10" ,"20190808"});
        batchit.add(new Object[] {"20191010","2019-07-07"});
        jdbcTemplate.batchUpdate(sql,batchit);
    }
    //查询id为2的集合，封装为Map
    @Test
    public void test3(){
        String sql="select * from baomingtie2 where id =?";
        Map<String,Object> map = jdbcTemplate.queryForMap(sql,2);
        System.out.println(map);
    }
    // 查询所有记录，将其封装为List集合
    // 将每条记录封账为一个Map集合，再将Map集合装载到List集合中
    @Test
    public void test4(){
        String sql = "select * from baomingtie2";
        List<Map<String,Object>> list = jdbcTemplate.queryForList(sql);
        for (Map<String ,Object> stringObjectMap:list){
            System.out.println(stringObjectMap);
        }
    }
    // 查询所有记录，自定义相同包的Jnshu类对象，封装为List集合
    // 其中jnshu和stu是自定义命名
    @Test
    public void test5(){
        String sql = "select * from baomingtie2";
        List<Jnshu> stu = jdbcTemplate.query(sql , new BeanPropertyRowMapper<Jnshu>(Jnshu.class));
        for (Jnshu jnshu:stu){
            System.out.println(jnshu);
        }
    }
    // 查询id为2的部分记录，封装为Map集合
    @Test
    public void test6() {
        String sql = "select name,school,type_job as \"工程师\" from baomingtie2 where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 2);
        System.out.println(map);
    }
    @Test
    // 查询所有记录，自定义不同包的Employee类对象，封装为List集合
    // 输出结果为Employee中的数据类型对象，id、lastname等
    public void test7() {
        String sql = "select * from baomingtie2";
        List<Employee> stu = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
        for( Employee jnshu : stu){
            System.out.println(jnshu);
        }
    }
    // 查询所有记录，自定义封装类型，封装为List集合
    // 可以自定义为方法测试的类对象，只是输出不知道是什么数据。。
    @Test
    public void test8() {
        String sql = "select * from baomingtie2 ";
        List<Jdbc_test> abc = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Jdbc_test>(Jdbc_test.class));
        for (Jdbc_test jnshu : abc) {
            System.out.println(jnshu);
        }
    }
    // 查询行数，使用基本类型对应的封装类，即引用类型
    @Test
    public void test9(){
        String sql = "select count(id) from baomingtie2";
        Long total = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(total);
    }
    @Test
    public void test10(){
        String sql = "select count(id) from baomingtie2";
        Integer total = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(total);
    }
    @Test
    public void test11(){
        String sql = "select count(id) from baomingtie2";
        int total = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(total);
    }
}
