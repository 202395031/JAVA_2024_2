/*
 * 작성일 : 2024년 10월 30일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class Lotto extends JFrame implements ActionListener{
	// 로또 번호가 출력 될 라벨 생성
	private JLabel lotto_num = new JLabel();
	public Lotto() {
		Container ct = getContentPane();	// 컨테이너
		ct.setLayout(new FlowLayout());		// 레이아웃
		
		JButton lotto = new JButton("로또 번호 자동생성");	// 버튼
		
		ct.add(lotto);
		ct.add(lotto_num);
		
		// 버튼에 리스너 추가
		lotto.addActionListener(this);
		
		// 화면 출력
		setTitle("Lotto Number 생성기");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Random r = new Random();	// Random() 클래스 객체 생성
		int[] lnum = new int[6];	// 배열 생성.
		int temp;	// 같은 번호가 생성되었는지 확인을 하기 위한 변수 생성.
		int i = 0;
		
		a: while(i < 6) {
			temp = r.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (temp == lnum[j]) {
					continue a;
				}
			}
			lnum[i] = temp;	// temp값 배열에 저장
			i++;
		}
		Arrays.sort(lnum);
		lotto_num.setText("이번주 로또 번호 : " + Arrays.toString(lnum));
	}
}
public class LottoNumGUI {

	public static void main(String[] args) {
		new Lotto();
	}

}
