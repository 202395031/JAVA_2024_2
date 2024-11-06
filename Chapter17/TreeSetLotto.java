/*
 * 작성일 : 2024년 11월 01일
 * 작성자 : 컴퓨터공학부 202395031 천승용
 */
import java.util.Random;
import java.util.TreeSet;

public class TreeSetLotto {
	public static void main(String[] args) {
		TreeSet<Integer> Lotto = new TreeSet<Integer>();
		while (Lotto.size() < 6) {			
			Random r = new Random();
			Lotto.add(r.nextInt(45) + 1);
			// int 변수에 (Math.random() * 45) + 1 도 됨
		}
		System.out.println("로또 번호 : " + Lotto);
	}

}
