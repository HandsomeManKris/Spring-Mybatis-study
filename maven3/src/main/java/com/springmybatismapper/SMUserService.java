package com.springmybatismapper;

public   interface SMUserService {
    public void addStudent(SMUser user);
    public SMUser findStudent(int id);
    public void updateStudent(SMUser user);
    public void deleteStudent(int id);
}
