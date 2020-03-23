package com.mybatisdays.domain;

import com.mybatisdays.Student;
import com.mybatisdays.dao.StudentInterfaceDao;
import javafx.beans.binding.ObjectExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentInterfaceImplDao implements StudentInterfaceDao {
    private JdbcTemplate jdbcTemplate = null;
    private ApplicationContext context = null;
    //初始化连接池
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

    }
    //单条插入
    @Override
    public  void insertStudent(Student student){
        String sql1 = "insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";

        jdbcTemplate.update(sql1,student.getId(),student.getCreate_at(),student.getUpdate_at(),student.getName(),student.getQQ(),
                student.getType_job(),student.getDate(),student.getSchool(),student.getNumber_online(),student.getDaily(),student.getDream(),
               student.getBrother(), student.getWhere_know());

    }
    @Override
    //多条插入
    public void insertStudents(List<Object[]> batchStudent){
        String sql2 = " insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.batchUpdate(sql2,(List<Object[]>) batchStudent);

    }
    @Override
    //单条更新
    /*public void updateStudent(Student student) {
        String sql3 = "update student set name = ? where id = ?";
        int i = jdbcTemplate.update(sql3, student.getName(), student.getId());
    }*/
    public boolean updateStudent(Student student){
        String sql3 = "update student set name = ? where id = ?";
        int i = jdbcTemplate.update(sql3,student.getName(),student.getId());
        if (i>0){
            return true;
        }else{
            return false;
        }

    }
    @Override
    //单条删除
    /*public void deleteId(int id){
        String sql4 = "delete from student where id = ?";
        jdbcTemplate.update(sql4,id);
    }*/
    public boolean deleteId(int id) {
        String sql4 = "delete from student where id = ?";
        int i =  jdbcTemplate.update(sql4, id);
        if (i>0){
            return true;
        }else{
            return false;
        }
    }
    @Override
    //单条查询
    public Map<String ,Object> selectStudent(int id){
        String sql5 = "select * from student where id = ?";
        Map<String ,Object>  map = jdbcTemplate.queryForMap(sql5,id);

        return map;
    }
    @Override
    //全部查询
   public List<Map<String,Object>> selectStudents(){
        String sql6 = "select * from student";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql6);
        return list;
    }
    @Override
    //单条件模糊查询
    public  List<Map<String,Object>> findStudents(String name){
        String sql7 = "select * from student where name like concat('%',?,'%')";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql7,name);
        return list;
    }
    @Override
    //多条件模糊查询
    public List<Map<String,Object>> mapFindStudents(Student student){
        String sql8 = "select * from student where id > ? and name like concat('%',?,'%')";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql8,student.getId(),student.getName());
        return list;
    }

}
