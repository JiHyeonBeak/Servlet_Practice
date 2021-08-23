package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	
	public MemberDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // ojdbc6.jar 를 가지고 와야 했는데 안 되어 있었다.
		} catch(Exception e) {
			System.out.println("드라이버 인식 안됨");
		}
	}
	
	private void connDB() {
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "system";
			String pwd = "oracle";
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("오라클 접속");
			}	
			catch(Exception e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}

	public List listMembers() {
		List list = new ArrayList();
		try {
			connDB();
			String sql = "select * from t_member";
			System.out.println(sql);
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
