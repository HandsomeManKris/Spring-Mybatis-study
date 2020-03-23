package com.mybatisdays.dao;
import com.mybatisdays.Student;
import java.util.List;
import java.util.Map;

public interface StudentInterfaceDao {
    public List<Map<String,Object>> findStudents(String name);
    public List<Map<String,Object>> mapFindStudents(Student student);
    public void  insertStudent(Student student);
    //public void updateStudent(Student student);
    public boolean updateStudent(Student student);
    //public void deleteId(int id);
    public boolean deleteId(int id);
    public Map<String,Object> selectStudent(int id);
    public List<Map<String,Object>> selectStudents();
    public void insertStudents(List<Object[]> student);
}