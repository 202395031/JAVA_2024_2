import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EventRegist {
    Scanner scanner = new Scanner(System.in);
    String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    String jdbcUrl = "jdbc:mysql://localhost:3306/dbevent?";
    Connection conn;
    String id = "root";      
    String pw = "1234";      
    PreparedStatement pstmt;
    ResultSet rs;

    public EventRegist() {
        System.out.println("## 이벤트 등록을 위해 이름과 이메일을 입력하세요.");
        System.out.print("이름 : ");
        String uname = scanner.nextLine();
        System.out.print("이메일 : ");
        String email = scanner.nextLine();

        connectDB();
        registUser(uname, email);
        printList();
        closeDB();
    }

    public void connectDB() {
        try {
            Class.forName(jdbcDriver);
            conn = DriverManager.getConnection(jdbcUrl, id, pw);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registUser(String uname, String email) {
        String sql = "insert into event values(?,?)";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, uname);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printList() {
        System.out.println("# 등록자 명단");
        String sql = "select * from event";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("uname") + "\t" + rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closeDB(){
        try {
            if (pstmt != null) pstmt.close();
            if (rs != null) rs.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EventRegist er = new EventRegist();
    }
}
