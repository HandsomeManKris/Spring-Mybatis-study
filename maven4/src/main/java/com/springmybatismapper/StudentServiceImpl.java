package com.springmybatismapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public void addStudent(Student user){
        sqlSession.insert("com.springmybatismapper.StudentMapper.insertStudent",user);

    }
    @Override
    public Student findStudent(int id){
        Student user = sqlSession.selectOne("com.springmybatismapper.StudentMapper.selectStudent",id);
        Date date = new Date(user.getCreate_at());
        Date date1 = new Date(user.getUpdate_at());
        Date date2 = new Date(user.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreateAtStr(sdf.format(date));
        user.setUpdateAtStr(sdf.format(date1));
        user.setDateStr(sdf.format(date2));
        return user;
    }
    @Override
    public boolean updateStudent(Student user) {
        int i = sqlSession.update("com.springmybatismapper.StudentMapper.updateStudent", user);
        if (i > 0) {
            return true;
        } else {
            return false;
        }
    }
        @Override
        public boolean deleteStudent ( int id){
            int i = sqlSession.delete("com.springmybatismapper.StudentMapper.deleteStudent", id);
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        }
    }