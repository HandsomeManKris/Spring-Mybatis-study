package com.springmybatismapper;

public   interface StudentService {
    public void addStudent(Student user);
    public Student findStudent(int id);
    public boolean updateStudent(Student user);
    public boolean deleteStudent(int id);
}
