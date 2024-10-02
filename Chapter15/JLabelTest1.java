/*
 * 작성일 : 2024년 10월 02일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JLabel1 extends JFrame implements ActionListener{
	private JLabel result = new JLabel();
	public ImageIcon img1, img2;
	
	public JLabel1() {
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		JButton apple = new JButton("사과");
		JButton pear = new JButton("배");
		
		
		// 이미지 생성
		img1 = new ImageIcon("images\\apple.jpg");
		img2 = new ImageIcon("images\\pear.jpg");
		
		ct.add(apple);
		ct.add(pear);
		ct.add(result);
		
		apple.addActionListener(this);
		pear.addActionListener(this);
		
		setTitle("JLabel Test");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "사과") {
			result.setIcon(img1);
			result.setText(e.getActionCommand() + "입니다.");
		}
		if (e.getActionCommand() == "배") {
			result.setIcon(img2);
			result.setText(e.getActionCommand() + "입니다.");
		}
	}
}
public class JLabelTest1 {

	public static void main(String[] args) {
		new JLabel1();
	}

}
