package maventest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
public class jdbc_test5 {
    private JdbcTemplate jdbcTemplate = null;
    private ApplicationContext context = null;

    //初始化连接池
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }
    @Test
    public void testUpdate(){
        String sql = "update bmt3 set QQ = 123456 where id = ?";
        int count = jdbcTemplate.update(sql, 11);
        System.out.println(count);
    }
    @Test
    public  void testInsert(){
        String sql1 = "insert into bmt3(id,name,QQ) values(?,?,?) ";
        int count  = jdbcTemplate.update(sql1,15,"小明",2345678);
        System.out.println(count);
    }
    @Test
    public  void testDelete(){
        String sql2 = "delete from bmt3 where name= ?";
        int count = jdbcTemplate.update(sql2,"小虎");
        System.out.println(count);
    }
    @Test
    public void testbatchUpdate(){
        String sql3 = "insert into bmt3 values(?,?,?)";
        jdbcTemplate.update(sql3,null,"狼行",768987);
        jdbcTemplate.update(sql3,null,"麻辣香锅",2345690);
        System.out.println("插入成功");
    }
}
