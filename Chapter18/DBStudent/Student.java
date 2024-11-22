package DBStudent;

// 학생 정보를 표현하기 위한 클래스
// 이 클래스는 데이터베이스의 학생 테이블과 매핑되어 데이터를 관리합니다.
public class Student {
    // 필드 선언 (컬럼 정보에 대응)
    private int Number;       // 학생의 연번
    private String Dept;      // 학생의 학과
    private int studentID;    // 학생의 학번
    private int Grade;        // 학생의 학년
    private String Name;      // 학생의 이름
    private String Phone;     // 학생의 연락처

    // Getter/Setter 메서드 (필드에 대한 접근 및 수정 메서드)

    // 연번 필드의 Getter
    public int getNumber() {
        return Number;
    }

    // 연번 필드의 Setter
    public void setNumber(int number) {
        Number = number;
    }

    // 학과 필드의 Getter
    public String getDept() {
        return Dept;
    }

    // 학과 필드의 Setter
    public void setDept(String dept) {
        Dept = dept;
    }

    // 학번 필드의 Getter
    public int getStudentID() {
        return studentID;
    }

    // 학번 필드의 Setter
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // 학년 필드의 Getter
    public int getGrade() {
        return Grade;
    }

    // 학년 필드의 Setter
    public void setGrade(int grade) {
        Grade = grade;
    }

    // 이름 필드의 Getter
    public String getName() {
        return Name;
    }

    // 이름 필드의 Setter
    public void setName(String name) {
        Name = name;
    }

    // 연락처 필드의 Getter
    public String getPhone() {
        return Phone;
    }

    // 연락처 필드의 Setter
    public void setPhone(String phone) {
        Phone = phone;
    }
}
