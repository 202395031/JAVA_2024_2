abstract class Figure1 {
	abstract void draw();
}

interface Shape1 {
	public void computeArea(double a, double b);
}

class Triangle3 extends Figure1 implements Shape1 {
	void draw() {
		System.out.println("삼각형을 그리는 기능");	// 메소드 오버라이딩
	}
	
	public void computeArea(double a, double h) {
		System.out.println("삼각형의 넓이 : " + (a * h / 2));	// 메소드 오버라이딩
	}
}

class Polydraw1{
	public void pdraw(Figure1 f) {
		f.draw();
	}
	public void pcomputeArea(Shape1 s, double a, double b) {
		s.computeArea(a, b);
	}
}

public class InterfaceTest2 {

	public static void main(String[] args) {
		Polydraw1 p = new Polydraw1();	// 일반적인 객체 생성
		
		Figure1 fg1 = new Triangle3();	//	이 두개는	(순서대로 추상, 인터페이스)
		Shape1 sp1 = new Triangle3();	//	형변환 => 다형성
		
		p.pdraw(fg1);
		p.pcomputeArea(sp1, 4, 4);
	}

}
