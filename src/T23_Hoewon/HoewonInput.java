package T23_Hoewon;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class HoewonInput extends JFrame{
	private JTextField txtName, txtAge, txtAddress;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JPanel pn1, pn2, pn3;
	JLabel lblTitle, lblName, lblAge, lblGender, lbJoinday, lblAddress, lblDD, lbYY, lblMM;
	JComboBox cbYY, cbMM, cbDD;
	JRadioButton rdMale, rdFemale;
	JButton btnInput, btnReset, btnClose;
	
	HoewonVO vo = new HoewonVO();
	HoewonDAO dao = new HoewonDAO();
	int res = 0;
	
	public HoewonInput() {
		setTitle("회원등록");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(12, 10, 760, 77);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("회 원 가 입 폼");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 30));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 760, 77);
		pn1.add(lblTitle);
		
		pn2 = new JPanel();
		pn2.setBounds(12, 97, 760, 367);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		lblName = new JLabel("성       명");
		lblName.setFont(new Font("굴림", Font.BOLD, 20));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(34, 23, 126, 45);
		pn2.add(lblName);
		
		lblAge = new JLabel("나       이");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("굴림", Font.BOLD, 20));
		lblAge.setBounds(34, 91, 126, 45);
		pn2.add(lblAge);
		
		lblGender = new JLabel("성       별");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("굴림", Font.BOLD, 20));
		lblGender.setBounds(34, 159, 126, 45);
		pn2.add(lblGender);
		
		lbJoinday = new JLabel("가  입  일");
		lbJoinday.setHorizontalAlignment(SwingConstants.CENTER);
		lbJoinday.setFont(new Font("굴림", Font.BOLD, 20));
		lbJoinday.setBounds(34, 227, 126, 45);
		pn2.add(lbJoinday);
		
		lblAddress = new JLabel("주       소");
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setFont(new Font("굴림", Font.BOLD, 20));
		lblAddress.setBounds(34, 295, 126, 45);
		pn2.add(lblAddress);
		
		txtName = new JTextField();
		txtName.setFont(new Font("굴림", Font.BOLD, 20));
		txtName.setBounds(186, 23, 524, 45);
		pn2.add(txtName);
		txtName.setColumns(10);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("굴림", Font.BOLD, 20));
		txtAge.setColumns(10);
		txtAge.setBounds(186, 91, 524, 45);
		pn2.add(txtAge);
		
		rdMale = new JRadioButton("남자");
		rdMale.setSelected(true);
		buttonGroup.add(rdMale);
		rdMale.setFont(new Font("굴림", Font.BOLD, 20));
		rdMale.setBounds(186, 159, 133, 45);
		pn2.add(rdMale);
		
		rdFemale = new JRadioButton("여자");
		buttonGroup.add(rdFemale);
		rdFemale.setFont(new Font("굴림", Font.BOLD, 20));
		rdFemale.setBounds(438, 159, 133, 45);
		pn2.add(rdFemale);
		
//	년도 / 월 / 일 초기값 생성하기
		String yy[] = new String[20];
		String mm[] = new String[12];
		String dd[] = new String[31];
		
		int imsi = 0;
		for(int i = 0; i < yy.length; i++) {
			imsi = 2024 - i;
			yy[i] = imsi + "";
		}
		for(int i = 0; i < mm.length; i++) {
			mm[i] = i+1 + "";
		}
		for(int i = 0; i < dd.length; i++) {
			dd[i] = i+1 + "";
		}
		
		cbYY = new JComboBox(yy);
		cbYY.setBounds(186, 227, 120, 45);
		pn2.add(cbYY);
		
		lbYY = new JLabel("년");
		lbYY.setHorizontalAlignment(SwingConstants.CENTER);
		lbYY.setFont(new Font("굴림", Font.BOLD, 20));
		lbYY.setBounds(296, 227, 57, 45);
		pn2.add(lbYY);
		
		cbMM = new JComboBox(mm);
		cbMM.setBounds(364, 227, 120, 45);
		pn2.add(cbMM);
		
		lblMM = new JLabel("월");
		lblMM.setHorizontalAlignment(SwingConstants.CENTER);
		lblMM.setFont(new Font("굴림", Font.BOLD, 20));
		lblMM.setBounds(474, 227, 57, 45);
		pn2.add(lblMM);
		
		cbDD = new JComboBox(dd);
		cbDD.setBounds(543, 227, 120, 45);
		pn2.add(cbDD);
		
		lblDD = new JLabel("일");
		lblDD.setHorizontalAlignment(SwingConstants.CENTER);
		lblDD.setFont(new Font("굴림", Font.BOLD, 20));
		lblDD.setBounds(653, 227, 57, 45);
		pn2.add(lblDD);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("굴림", Font.BOLD, 20));
		txtAddress.setColumns(10);
		txtAddress.setBounds(186, 295, 524, 45);
		pn2.add(txtAddress);
		
		pn3 = new JPanel();
		pn3.setBounds(12, 474, 760, 77);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnInput = new JButton("가입하기");
		btnInput.setFont(new Font("굴림", Font.BOLD, 20));
		btnInput.setBounds(12, 10, 237, 57);
		pn3.add(btnInput);
		
		btnReset = new JButton("다시 입력");
		btnReset.setFont(new Font("굴림", Font.BOLD, 20));
		btnReset.setBounds(261, 10, 237, 57);
		pn3.add(btnReset);
		
		btnClose = new JButton("종료하기");
		btnClose.setFont(new Font("굴림", Font.BOLD, 20));
		btnClose.setBounds(510, 10, 237, 57);
		pn3.add(btnClose);
		
		
/*	============================	*/		
		setVisible(true);
/*	============================	*/
		
//		키보드 엔터키 쳤을 때 수행
		btnInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				setHoewonInput();
			}
		});
		
		
//		가입하기	(마우스)
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setHoewonInput();
			}
		});
		
//		다시 입력		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
//		창닫기		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HoewonMain();
			}
		});
	}

	
//		회원가입처리 메소드	
	protected void setHoewonInput() {
		String name = txtName.getText().trim();
		String age = txtAge.getText().trim();
		String gender = "";
		String joinday = cbYY.getSelectedItem() + "-" + cbMM.getSelectedItem() + "-" + cbDD.getSelectedItem();
		String address = txtAddress.getText().trim();
	
		if(name.equals("")) {
			JOptionPane.showMessageDialog(null, "성명을 입력하세요");
			txtName.requestFocus();
		}
		else if(!Pattern.matches("^[0-9]+$", age)) {
			JOptionPane.showMessageDialog(null, "나이를 숫자로 입력하세요");
			txtAge.requestFocus();
		}
		else {
			if(rdMale.isSelected()) {
				gender = "남자";
			}
			else {
				gender = "여자";
			}	

			vo.setName(name);
			vo.setAge(Integer.parseInt(age));
			vo.setGender(gender);
			vo.setJoinday(joinday);
			vo.setAddress(address);
			
			res = dao.setHoewonInput(vo);
			if(res != 0) {
				JOptionPane.showMessageDialog(null, "회원가입 성공!");
				dispose();
				new HoewonMain();
			}
			else {
				JOptionPane.showMessageDialog(null, "회원가입 실패");
				txtName.requestFocus();
			}
		}
	}
	
	/*
	public static void main(String[] args) {
		new HoewonInput();
	}
	*/
}
