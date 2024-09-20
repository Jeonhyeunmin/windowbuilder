package T21_SWING;

import javax.swing.JFrame;

public class T03_Basic extends JFrame{

	public T03_Basic() {
		super("스윙연습");
//		setBounds(300, 250, 300, 250);
		setSize(1000, 700);
		
//		윈도우 화면 중앙에 위치하기
		setLocationRelativeTo(null);
		
//		화면 크기 고정
		setResizable(false);
		
//		윈도우 창 닫기
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new T03_Basic();
	}
}
