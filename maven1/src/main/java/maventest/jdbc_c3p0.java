package maventest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;

public class jdbc_c3p0 {
    private JdbcTemplate jdbcTemplate = null;
    private ApplicationContext context = null;

    //初始化连接池
    {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");
    }
    //测试是否连接数据库
@Test
    public  void testIsConnect() throws SQLException{
        String sql = "update bmt3 set QQ = 123456 where id = ?";
        int count = jdbcTemplate.update(sql, 10);
        System.out.println(count);
        //DataSource dataSource = context.getBean(DataSource.class);
        //System.out.println("连接成功"+dataSource.getConnection());
    }
}
