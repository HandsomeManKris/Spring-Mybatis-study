package com.springmybatismapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMUserServiceImpl implements SMUserService {
    @Autowired
    private SqlSessionTemplate sqlSession;
    @Override
    public void addStudent(SMUser user){
        sqlSession.insert("com.springmybatismapper.SMUserMapper.insertStudent",user);

    }
    @Override
    public SMUser findStudent(int id){
        SMUser user = sqlSession.selectOne("com.springmybatismapper.SMUserMapper.selectStudent",id);
        return user;
    }
    @Override
    public void updateStudent(SMUser user){
        sqlSession.update("com.springmybatismapper.SMUserMapper.updateStudent",user);
    }
    @Override
    public void deleteStudent(int id){
        sqlSession.delete("com.springmybatismapper.SMUserMapper.deleteStudent",id);
    }
}
