/*
 * 작성일 :  2024년 10월 16일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class exam02 extends JFrame implements ActionListener{
	JLabel jl1 = new JLabel("길이를 입력하고, 도형의 버튼을 클릭하세요.");
	JLabel jl2 = new JLabel("결과");
	JTextField jtf;
	JTextArea jta;
	String[] name = {"원", "삼각형", "사각형", "리셋"};
	JButton[] jb = new JButton[name.length];
	public exam02() {
		Container ct = getContentPane();
		BorderLayout bl = new BorderLayout();
		ct.setLayout(bl);
		
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(2, 1, 10, 10));
		jtf = new JTextField();
		jp1.add(jl1);
		jp1.add(jtf);
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15));
		for (int i = 0; i < name.length; i++) {
			jb[i] = new JButton(name[i]);
			jb[i].addActionListener(this);
			jp2.add(jb[i]);
		}
		
		JPanel jp3 = new JPanel();
		jp3.setLayout(new GridLayout(2, 1, 0, 5));
		jta = new JTextArea(2, 1);
		jp3.add(jl2);
		jp3.add(jta);
		
		ct.add(jp1, BorderLayout.NORTH);
		ct.add(jp2, BorderLayout.CENTER);
		ct.add(jp3, BorderLayout.SOUTH);
		
		setTitle("Exam2023_02");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand();
		String num = jtf.getText();
		try {			
			int getnum = Integer.parseInt(num);
			double result;
			if (s == "원") {
				result = getnum * getnum * 3.14;
				jta.setText("원의 넓이 : " + num + " * " + num + " * " + "3.14 = " + result);
			}
			else if (s == "삼각형") {
				result = getnum * getnum / 2;
				jta.setText("삼각형의 넓이 : " + num + " * " + num + " / " + "2 = " + result);
			}
			else if (s == "사각형") {
				result = getnum * getnum;
				jta.setText("사각형의 넓이 : " + num + " * " + num + " = " + result);
			}
			else {
				jta.setText("");
				jtf.setText("");
			}
		}
		catch (Exception e2) {
			jta.setText("길이(숫자)를 입력하셔야 합니다.");
		}
	}
}
public class exam2023_02 {

	public static void main(String[] args) {
		new exam02();
	}

}
