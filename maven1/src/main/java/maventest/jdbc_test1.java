package maventest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class jdbc_test1 {
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
            String sql = "select * from bmt3 where id = 4";
            //执行查询语句，并把结果返回ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString(2);
                int QQ = rs.getInt("QQ");
                System.out.println(rs.getInt(1) + "- - - " + rs.getString(2) + "- - -" + rs.getInt(3) );
            //以下是账号密码查询
           //String name = "小红";
           // String password = "111";
           // String sql = "select * from bmt3 where name = '"+name+"' and QQ = '"+password+"'";
           // ResultSet rs = s.executeQuery(sql);
          //  if (rs.next()){
          //      System.out.println("账号密码正确");
          //  }else{
         //       System.out.println("账号密码错误");
          //  }


            }
            //不一定要在这里关闭statement,因为statement关闭的时候ResultSet自动关闭
            //rs.close

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}