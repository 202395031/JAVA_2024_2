package DBStudent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

// 데이터베이스에서 학생 정보를 관리하기 위한 DAO(Data Access Object) 클래스
public class StudentDAO {
    // 데이터베이스 연결 정보
    String jdbcUrl = "jdbc:mysql://localhost:3306/studentdb?";
    String id = "root"; // DB 사용자 ID
    String pw = "1234"; // DB 사용자 비밀번호
    
    Connection conn; // 데이터베이스 연결 객체
    PreparedStatement pstmt; // SQL 문 실행을 위한 객체
    ResultSet rs; // SQL 쿼리 결과를 저장하는 객체
    
    Vector<String> items = null; // 콤보박스 데이터를 저장하는 벡터
    String sql; // 실행할 SQL 쿼리를 저장

    // 데이터베이스 연결 메소드
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL 드라이버 로드
            conn = DriverManager.getConnection(jdbcUrl, id, pw); // 연결 설정
        } catch (Exception e) {
            e.printStackTrace(); // 에러 로그 출력
        }
    }

    // 데이터베이스 연결 종료 메소드
    public void closeDB() {
        try {
            if (pstmt != null) pstmt.close(); // PreparedStatement 종료
            if (conn != null) conn.close();  // Connection 종료
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 콤보박스의 학생 관리 번호 목록을 리턴하는 메소드
    public Vector<String> getItems() {
        return items;
    }

    // 전체 학생 목록을 가져오는 메소드
    public ArrayList<Student> getAll() {
        connectDB();
        sql = "select * from student"; // 학생 테이블 전체 조회 SQL 쿼리
        
        ArrayList<Student> datas = new ArrayList<>(); // 학생 데이터 저장 리스트 초기화
        items = new Vector<>(); // 콤보박스 데이터 초기화
        items.add("연변선택"); // 초기 항목 추가
        
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            // 검색 결과를 반복문으로 처리
            while (rs.next()) {
                Student s = new Student();
                s.setNumber(rs.getInt("number"));
                s.setDept(rs.getString("Dept"));
                s.setStudentID(rs.getInt("StudentID"));
                s.setGrade(rs.getInt("Grade"));
                s.setName(rs.getString("Name"));
                s.setPhone(rs.getString("Phone"));
                
                datas.add(s); // 리스트에 학생 정보 추가
                items.add(String.valueOf(rs.getInt("number"))); // 콤보박스 항목 추가
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeDB(); // 연결 종료
        }
        return datas;
    }

    // 새로운 학생을 등록하는 메소드
    public boolean insertStudent(Student student) {
        connectDB();
        sql = "insert into student(dept, studentID, grade, name, phone) values(?,?,?,?,?)";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getDept());
            pstmt.setInt(2, student.getStudentID());
            pstmt.setInt(3, student.getGrade());
            pstmt.setString(4, student.getName());
            pstmt.setString(5, student.getPhone());
            pstmt.executeUpdate(); // 쿼리 실행
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeDB();
        }
        return true;
    }

    // 선택된 학생의 정보를 가져오는 메소드
    public Student selectStudent(int number) {
        connectDB();
        sql = "select * from student where number=?";
        Student s = null;
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            rs = pstmt.executeQuery();
            
            if (rs.next()) { // 결과가 있는 경우
                s = new Student();
                s.setNumber(rs.getInt("number"));
                s.setDept(rs.getString("Dept"));
                s.setStudentID(rs.getInt("StudentID"));
                s.setGrade(rs.getInt("Grade"));
                s.setName(rs.getString("Name"));
                s.setPhone(rs.getString("Phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            closeDB();
        }
        return s;
    }

    // 학생 정보를 업데이트하는 메소드
    public boolean updatestudent(Student student) {
        connectDB();
        sql = "update student set dept=?, studentID=?, grade=?, name=?, phone=? where number=?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getDept());
            pstmt.setInt(2, student.getStudentID());
            pstmt.setInt(3, student.getGrade());
            pstmt.setString(4, student.getName());
            pstmt.setString(5, student.getPhone());
            pstmt.setInt(6, student.getNumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeDB();
        }
        return true;
    }

    // 학생 정보를 삭제하는 메소드
    public boolean deletestudent(int number) {
        connectDB();
        sql = "delete from student where number=?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeDB();
        }
        return true;
    }
}
