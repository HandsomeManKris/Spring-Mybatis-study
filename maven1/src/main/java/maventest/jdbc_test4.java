package maventest;
import java.sql.*;
public class jdbc_test4 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "insert into bmt3 values(?,?,?)";
        // try-with-resource语句，可自动关闭资源
        try (
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/xzy?serverTimezone=GMT&characterEncoding=utf8",
                        "root","a19930905");
               //使用 sql语句创建preparestatement
                PreparedStatement ps = c.prepareStatement(sql);
        )

        //以下是使用preparestatement
        {
            //设置参数
            ps.setInt(1,14);
            ps.setString(2,"UZI1");
            ps.setInt(3,2800);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
