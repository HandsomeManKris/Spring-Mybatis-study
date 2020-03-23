package com.springmybatismapper;

public interface SMUserMapper {

    public void  insertStudent(SMUser user);
    public void updateStudent(SMUser user);
    public void deleteStudent(int id);
    public SMUser selectStudent(int id);
}
