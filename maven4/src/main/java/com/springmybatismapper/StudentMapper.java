package com.springmybatismapper;

public interface StudentMapper {

    public void  insertStudent(Student user);
    public void updateStudent(Student user);
    public void deleteStudent(int id);
    public Student selectStudent(int id);
}
