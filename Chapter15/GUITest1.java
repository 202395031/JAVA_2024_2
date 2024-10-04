/*
 * 작성일 :  2024년 10월 02일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class GUI1 extends JFrame implements ActionListener{
	// 속성으로 텍스트 에어리어와 텍스트 필드를 선언.
	// 이벤트 처리에서 사용해야 하기에 생성자 밖에 속성으로 선언.
	// 글 내용을 입력하고, 버튼을 누르면 파일로 생성되어야 함.
	private JTextField f_name;
	private JTextArea contents;
	public GUI1() {
		// 컨테이너 생성
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		
		// 버튼 등을 생성
		f_name = new JTextField("파일 이름을 입력하세요.", 20);
		JButton jb = new JButton("파일 저장하기");
		contents = new JTextArea("내용을 입력하세요.", 10, 20);
		
		// 버튼에 리스너 넣기
		jb.addActionListener(this);
		
		// 컨포넌트에 추가
		ct.add(f_name);
		ct.add(contents);
		ct.add(jb);
		
		// 기본 설정
		setTitle("GUI Test");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			String s = f_name.getText();
			FileOutputStream fos = new FileOutputStream(s);	
			DataOutputStream dos = new DataOutputStream(fos);
			
			// 텍스트 에어리어의 내용을 파일로 
			dos.writeUTF(contents.getText());
			fos.close();
			
			System.out.println(s + "파일을 생성하였습니다.");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
public class GUITest1 {

	public static void main(String[] args) {
		new GUI1();
	}

}
