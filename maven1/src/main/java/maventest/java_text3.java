package maventest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class java_text3 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // try-with-resource语句，可自动关闭资源
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzy?serverTimezone=GMT&characterEncoding=utf8",
                        "root","a19930905");
                Statement s = c.createStatement();
        )
        {

                //以下是账号密码查询
                String name = "小红";
                 String password = "112";
                 String sql = "select * from bmt3 where name = '"+name+"' and QQ = '"+password+"'";
                 ResultSet rs = s.executeQuery(sql);
                  if (rs.next()){
                      System.out.println("账号密码正确");
                  }else{
                       System.out.println("账号密码错误");



            }
            //不一定要在这里关闭statement,因为statement关闭的时候ResultSet自动关闭
            //rs.close

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
