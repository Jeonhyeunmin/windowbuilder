package T23_Hoewon;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings({"rawtypes", "unchecked"})
public class HoewonDAO extends DBConn{
	HoewonVO vo = null;
	String sql = "";
	
//		회원 전체 조회
	public Vector getHoewonList() {
		Vector vData = new Vector();
		try {
			sql = "select * from hoewon";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday"));
				vo.add(rs.getString("address"));
				
				vData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

	
//	회원가입처리
	public int setHoewonInput(HoewonVO vo) {
		int res = 0;
		try {
			sql = "insert into hoewon value (default, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getAge());
			pstmt.setString(3, vo.getGender());
			pstmt.setString(4, vo.getJoinday());
			pstmt.setString(5, vo.getAddress());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		
		return res;
	}

// 회원 가입일 오름차순 / 내림차순 정렬
	public Vector getHoewonAlign(String str, String order) {
		Vector vData = new Vector();
		try {
			if(order.equals("a")) {
				sql = "select * from hoewon order by " + str;
			}
			else {
				sql = "select * from hoewon order by " + str + " desc";
			}
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, str);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday").substring(0, 10));
				vo.add(rs.getString("address"));
				
				vData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}

//		조건검색
	public Vector getConditionSearch(String str, String txtCondi, String order, String list) {
		Vector vData = new Vector();
		try {
			if(order.equals("a")) {
				sql = "select * from hoewon where " + str + " like ? order by " + list;
			}
			else {
				sql = "select * from hoewon where " + str + " like ? order by " + list + " desc";				
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + txtCondi + "%");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Vector vo = new Vector();
				vo.add(rs.getInt("idx"));
				vo.add(rs.getString("name"));
				vo.add(rs.getInt("age"));
				vo.add(rs.getString("gender"));
				vo.add(rs.getString("joinday").substring(0, 10));
				vo.add(rs.getString("address"));
				
				vData.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vData;
	}
}