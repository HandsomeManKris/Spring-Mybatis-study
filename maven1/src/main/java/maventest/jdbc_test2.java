package maventest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbc_test2 {
    public static void main(String[] args) {
        // 初始化变量
        Connection c = null;
        Statement s = null;
        try {
            // 导入、注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("驱动注册成功");
            // 建立连接
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzy?serverTimezone=GMT&characterEncoding=utf8","root","@Fz19930905");
            System.out.println("连接数据库成功");
            // 创建执行sql语句的对象
            s = c.createStatement();
            // 定义sql语句
            String sql1 = "insert into bmt3 values(null," + "'小花'" + "," + 111 + ")";
           String sql2 = "update bmt3 set name = '小黑' where id = 9";
            String sql3 = "delete from bmt3 where id = 4";
             //执行sql语句
            s.execute(sql1);
            s.execute(sql2);
            s.execute(sql3);
            System.out.println("SQL执行成功");
        }catch (ClassNotFoundException e) {
            // 异常捕捉
            e.printStackTrace();
            System.out.println("捕捉类无法找到异常");
        }catch (SQLException e) {
            // 异常捕捉
            e.printStackTrace();
            System.out.println("捕捉sql异常");
        }finally{
            // 关闭资源
            if(s != null) {
                try {
                    s.close();
                    System.out.println("关闭statement");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("捕捉sql异常2");
                }
            }else{
                System.out.println("statement is null");
            }
            if(c != null) {
                try {
                    c.close();
                    System.out.println("关闭Connection");
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("捕捉sql异常3");
                }
            }else{
                System.out.println("Connection is null");
            }
        }
    }
}