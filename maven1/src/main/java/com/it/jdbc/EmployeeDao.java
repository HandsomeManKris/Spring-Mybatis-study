package com.it.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("EmployeeDao")
public class EmployeeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Employee get(Integer id){
        String sql = "Select id ,last_name lastName, email from employees where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>( Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper,id);
        return employee;
    }
}
