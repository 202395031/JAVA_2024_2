/*
 * 작성일 :  2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class exam01 extends JFrame implements ActionListener{
	JLabel jl = new JLabel("당신의 MBTI는 무엇인가요?");
	JTextArea jta = new JTextArea("MBTI를 선택하면 유형별 별명과 특징을 알려드립니다.");
	String[] MBTI = {
			"ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP",
			"ESTJ", "ESFJ", "ENFJ", "ENTJ", "ESTP", "ESFP", "ENFP", "ENTP",
	};
	JButton[] jb = new JButton[MBTI.length];
	public exam01() {
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(2, 1));
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1));
		jp1.add(jl);
		jp1.add(jta);
		jp2.setLayout(new GridLayout(4, 4, 10, 10));
		
		for (int i = 0; i < MBTI.length; i++) {
			jb[i] = new JButton(MBTI[i]);
			jb[i].addActionListener(this);
			jp2.add(jb[i]);
		}
		
		ct.add(jp1);
		ct.add(jp2);
		
		setTitle("Exam2023_01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 400);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		jta.setText(e.getActionCommand() + "를 선택하셨습니다.");
	}
}

public class exam2023_01 {

	public static void main(String[] args) {
		new exam01();
	}

}
