package DBStudent;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// MainStudent 클래스는 학생 정보를 관리하는 GUI 애플리케이션의 메인 클래스입니다.
public class MainStudent extends JFrame implements ActionListener {
    Container ct = getContentPane(); // 컨테이너 생성

    // 패널 생성
    JPanel p1 = new JPanel(); // 메시지 패널
    JPanel p2 = new JPanel(); // 레이블 패널
    JPanel p3 = new JPanel(); // 텍스트 필드 패널
    JPanel p4 = new JPanel(); // 버튼 패널
    JPanel p5 = new JPanel(); // 데이터 출력 패널

    // 메시지 출력을 위한 라벨
    JLabel msg1 = new JLabel(); // 메시지 라벨 생성

    // 레이블 생성
    JLabel l1 = new JLabel("   연   번   ");
    JLabel l2 = new JLabel("   학   과   ");
    JLabel l3 = new JLabel("   학   번   ");
    JLabel l4 = new JLabel("   학   년   ");
    JLabel l5 = new JLabel("   이   름   ");
    JLabel l6 = new JLabel("   연락처   ");

    // 입력 필드를 위한 텍스트 필드
    JTextField t1 = new JTextField(10);
    JTextField t2 = new JTextField(10);
    JTextField t3 = new JTextField(10);
    JTextField t4 = new JTextField(10);
    JTextField t5 = new JTextField(10);

    // 메뉴 버튼 생성
    JButton b1 = new JButton("   등  록    ");
    JButton b2 = new JButton("   조  회    ");
    JButton b3 = new JButton("   수  정    ");
    JButton b4 = new JButton("   삭  제    ");

    // 학생 관리 코드를 위한 콤보박스
    JComboBox cb;

    // 데이터 출력을 위한 텍스트 영역
    JTextArea ta;

    String msg = ""; // 메시지 초기화

    // 학생 목록 출력을 위한 ArrayList
    ArrayList<Student> datas = new ArrayList<Student>();

    // 데이터베이스 연동을 위한 DAO 클래스
    StudentDAO Sdao = new StudentDAO();

    // 학생 정보를 저장할 인스턴스
    Student student;

    // 메인 UI 실행 메서드
    public void startUI() {
        // 컨테이너 레이아웃 설정
        ct.setLayout(new BorderLayout());

        // 패널 레이아웃 설정
        p1.setLayout(new GridLayout(1, 1, 20, 2));
        p2.setLayout(new GridLayout(6, 1, 20, 2));
        p3.setLayout(new GridLayout(6, 1, 20, 2));
        p4.setLayout(new GridLayout(4, 1, 20, 2));
        p5.setLayout(new GridLayout(1, 1, 20, 2));

        // 메시지 라벨 초기화
        msg1.setText(msg + " 프로그램이 시작 되었습니다.!!");
        msg1.setEnabled(false);

        // 콤보박스 초기화
        cb = new JComboBox();

        // 데이터 출력 영역 스크롤 초기화
        ta = new JTextArea(20, 40);
        JScrollPane scroll = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // 각 패널에 컴포넌트 추가
        p1.add(msg1);

        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(l6);

        p3.add(cb);
        p3.add(t1);
        p3.add(t2);
        p3.add(t3);
        p3.add(t4);
        p3.add(t5);

        p4.add(b1);
        p4.add(b2);
        p4.add(b3);
        p4.add(b4);

        p5.add(scroll);

        // 버튼에 이벤트 리스너 등록
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        // 메인 프레임에 각 패널 배치
        ct.add(p1, BorderLayout.NORTH);
        ct.add(p2, BorderLayout.WEST);
        ct.add(p3, BorderLayout.CENTER);
        ct.add(p4, BorderLayout.EAST);
        ct.add(p5, BorderLayout.SOUTH);

        // 초기 데이터 출력
        refreshData();

        // UI 크기 조정 불가능 설정 및 보이기 설정
        setResizable(false);
        setVisible(true);
    }

    // 생성자: 기본 프레임 설정
    public MainStudent() {
        super("Student Information"); // 프레임 타이틀
        setLayout(new BorderLayout(20, 20));
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 닫기 버튼 동작
        setSize(700, 700); // 프레임 크기
    }

    // 입력 필드 초기화 메서드
    public void clearField() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
    }

    // 데이터 갱신 및 출력 메서드
    public void refreshData() {
        ta.setText("\n\n");
        clearField();

        // 데이터 헤더 추가
        ta.append("     연 번\t학 과\t\t학 번\t학 년\t이 름\t연락처\n");
        datas = Sdao.getAll(); // 데이터베이스에서 전체 데이터 가져오기

        // 콤보박스 갱신
        cb.setModel(new DefaultComboBoxModel(Sdao.getItems()));

        if (datas != null) {
            // ArrayList 데이터를 포맷에 맞춰 출력
            for (Student p : datas) {
                StringBuffer sb = new StringBuffer();
                sb.append("     " + p.getNumber() + "\t");
                sb.append(p.getDept() + "\t\t");
                sb.append(p.getStudentID() + "\t");
                sb.append(p.getGrade() + "\t");
                sb.append(p.getName() + "\t");
                sb.append(p.getPhone() + "\n");
                ta.append(sb.toString());
            }
        }
    }

    // 버튼 클릭 이벤트 처리
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        // 등록 버튼 동작
        if (obj == b1) {
            student = new Student();
            student.setDept(t1.getText());
            student.setStudentID(Integer.parseInt(t2.getText()));
            student.setGrade(Integer.parseInt(t3.getText()));
            student.setName(t4.getText());
            student.setPhone(t5.getText());

            if (Sdao.insertStudent(student)) {
                msg1.setText(msg + "학생을 등록했습니다.!!");
            } else {
                msg1.setText(msg + "학생 등록이 실패 했습니다.!!");
            }
            refreshData(); // 데이터 갱신
        }
        // 조회 버튼 동작
        else if (obj == b2) {
            // 콤보박스에서 선택된 연번 조회
            String s = (String) cb.getSelectedItem();
            if (!s.equals("연번선택")) {
                student = Sdao.selectStudent(Integer.parseInt(s));
                if (student != null) {
                    msg1.setText(msg + "학생 정보를 가져왔습니다.!!");
                    t1.setText(student.getDept());
                    t2.setText(String.valueOf(student.getStudentID()));
                    t3.setText(String.valueOf(student.getGrade()));
                    t4.setText(student.getName());
                    t5.setText(student.getPhone());
                } else {
                    msg1.setText(msg + "학생이 검색되지 않았습니다.!!");
                }
            } else {
                refreshData();
            }
        }
        // 수정 버튼 동작
        else if (obj == b3) {
            student = new Student();
            student.setDept(t1.getText());
            student.setStudentID(Integer.parseInt(t2.getText()));
            student.setGrade(Integer.parseInt(t3.getText()));
            student.setName(t4.getText());
            student.setPhone(t5.getText());
            student.setNumber(Integer.parseInt((String) cb.getSelectedItem()));
            if (Sdao.updatestudent(student)) {
                msg1.setText(msg + "학생 정보를 수정했습니다.!!");
            } else {
                msg1.setText(msg + "학생 정보 수정에 실패 했습니다.!!");
            }
            refreshData();
        }
        // 삭제 버튼 동작
        else if (obj == b4) {
            String s = (String) cb.getSelectedItem();

            if (s.equals("전체")) {
                msg1.setText(msg + "전체 삭제는 되지 않습니다.!!");
            } else {
                if (Sdao.deletestudent(Integer.parseInt(s))) {
                    msg1.setText(msg + "학생이 삭제되었습니다.!!");
                    clearField();
                } else {
                    msg1.setText(msg + "학생이 삭제되지 않았습니다.!!");
                }
            }
            refreshData();
        }
    }

    // 메인 메서드: 프로그램 실행 진입점
    public static void main(String[] args) {
        MainStudent pm = new MainStudent();
        pm.startUI(); // UI 초기화 및 실행
    }
}
