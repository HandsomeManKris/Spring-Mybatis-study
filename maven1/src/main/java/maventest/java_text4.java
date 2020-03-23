package maventest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class java_text4 {
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

            //以下是查询表中数据量
            String sql = "select count(*) from bmt3";
            ResultSet rs = s.executeQuery(sql);
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            System.out.println("表中总共有:" + total+" 条数据");

            //不一定要在这里关闭statement,因为statement关闭的时候ResultSet自动关闭
            //rs.close

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}