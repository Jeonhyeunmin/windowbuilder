package T21_SWING;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class T06_Radio extends JFrame{
	JPanel pn1, pn11, pn12, pn13;
	JButton btnExit;
	CheckboxGroup gender;
	Checkbox rdGender1, rdGender2;
	
	public T06_Radio() {
		setTitle("라디오버튼 연습");
		setSize(400, 300);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		setLayout(new FlowLayout());
		
		pn1 = new JPanel();

		gender = new CheckboxGroup();
		rdGender1 = new Checkbox("남자", gender, true);
		rdGender2 = new Checkbox("여자", gender, false);
		Checkbox rdGender3 = new Checkbox("현민", gender, false);
		
		pn1.add(rdGender1);
		pn1.add(rdGender2);
		pn1.add(rdGender3);
		
		add(pn1);
		
		setVisible(true);
		
		/*	=============================================	*/
		
	}
	
	public static void main(String[] args) {
		new T06_Radio();
	}
}
