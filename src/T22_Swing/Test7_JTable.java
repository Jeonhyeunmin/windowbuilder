package T22_Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import T23_Hoewon.HoewonDAO;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class Test7_JTable extends JFrame{
	private JTable table;
	JPanel pn1, pn2, pn3;
	JLabel lblTitle;
	JButton btnSelect, btnExit;
	Vector title, vData;
	DefaultTableModel dtm;
	JScrollPane scrollPane;
	
	HoewonDAO dao = new HoewonDAO();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Test7_JTable() {
		setTitle("테이블 연습");
		setSize(600,480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 584, 63);
		getContentPane().add(pn1);
		pn1.setLayout(null);
		
		lblTitle = new JLabel("회 원 리 스 트");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 25));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(12, 10, 560, 43);
		pn1.add(lblTitle);
		
		pn2 = new JPanel();
		pn2.setBounds(10, 73, 562, 273);
		getContentPane().add(pn2);
		pn2.setLayout(null);
		
		pn3 = new JPanel();
		pn3.setBounds(0, 364, 584, 77);
		getContentPane().add(pn3);
		pn3.setLayout(null);
		
		btnSelect = new JButton("선택된 값 출력");
		btnSelect.setFont(new Font("굴림", Font.BOLD, 20));
		btnSelect.setBounds(12, 10, 281, 65);
		pn3.add(btnSelect);
		
		btnExit = new JButton("종료");
		
		btnExit.setFont(new Font("굴림", Font.BOLD, 20));
		btnExit.setBounds(291, 10, 281, 65);
		pn3.add(btnExit);
		
		
//		JTable 설계
//		1. '부제목'을 Vector로 만들어준다. (저장)
		title = new Vector();
		title.add("번호");
		title.add("이름");
		title.add("나이");
		title.add("성별");
		title.add("가입일");
		title.add("주소");
		
//		2.'데이터'를 Vector 타입으로 만들어준다. 회원데이터는 데이터베이스에서 가져온다.
		vData = dao.getHoewonList();
//		System.out.println("vData : " + vData);
		
//		3. DB에서 가져온 자료(vData)와 title을 DefaultTalbeModel 객체에 생성하면서 담아준다.
		dtm = new DefaultTableModel(vData, title);
		
//		4. DefaultTalbeModel에 담긴 백터타입의 '데이터 / 타이틀'을 JTable 객체에 생성시에 담아준다
		table = new JTable(dtm);
		
//		5. 자료가 담긴 JTalbe 객체를 JScrollPane 객체 생성시에 담아준다.		
//		scrollPane.setViewportView(table);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 562, 273);
		pn2.add(scrollPane);
		
//		6. 실행시켜 출력된 화면에서 결과를 확인한다.
		
/*	================================	*/
		setVisible(true);
/*	================================	*/
		
//		선택한 내용 출력	
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row != -1) {
//					System.out.println("선택된 내용 : " + table.getValueAt(row, 0));
					String temp = "성명:"+table.getValueAt(row, 1)+", 나이:"+table.getValueAt(row, 2)+", 성별:"+table.getValueAt(row, 3)+", 가입일:"+table.getValueAt(row, 4).toString().substring(0,10)+", 주소:"+table.getValueAt(row, 5);
					JOptionPane.showMessageDialog(null, temp);
				}
			}
		});
		
//		종료버튼	
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	
	public static void main(String[] args) {
		new Test7_JTable();
	}
}
