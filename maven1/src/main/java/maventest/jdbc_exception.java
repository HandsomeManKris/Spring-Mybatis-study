package maventest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class jdbc_exception {
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
            String sql = "insert into bmt3 values(null," + "'怎么回事，小老弟'" + "," + 12 + ")";
            int count = s.executeUpdate(sql);
            System.out.println("更新的行数："+ count + "行");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
