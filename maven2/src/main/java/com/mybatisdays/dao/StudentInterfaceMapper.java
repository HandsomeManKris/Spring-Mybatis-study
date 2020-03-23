package com.mybatisdays.dao;
import com.mybatisdays.Student;
import java.util.List;
import java.util.Map;
public interface StudentInterfaceMapper {
    public List<Student> findStudents(String name);
    public List<Student> mapFindStudents(Student student);
    public void  insertStudent(Student student);
    public void updateStudent(Student student);
    public void deleteId(int id);
    public Student selectStudent(int id);
    public List<Student> selectStudents();
  //  public void insertStudents(List<Object> student);
}