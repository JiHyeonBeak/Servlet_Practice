package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
	private Connection con;
	private Statement stmt;
	
	private void connDB() {
		try {
			String url = "jdbc:Oracle:thin:@localhost:1521:xe";
			String user = "system";
			String pwd = "oracle";
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("오라클 접속");
		}catch(Exception e) {
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
			ResultSet rs = stmt.executeQuery(sql);
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
			stmt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
