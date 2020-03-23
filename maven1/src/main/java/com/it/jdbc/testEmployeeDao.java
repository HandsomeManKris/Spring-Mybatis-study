package com.it.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

public class testEmployeeDao {
    private ApplicationContext context = null;
    private JdbcTemplate jdbcTemplate;
    private  EmployeeDao employeeDao;
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
        employeeDao = (EmployeeDao) context.getBean("EmployeeDao");
    }
    @Test
    public void testsss() {
        System.out.println(employeeDao.get(1));
    }
}
