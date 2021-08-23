package test_login;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.Context;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	
	public MemberDAO() { //커넥션 풀 적용
		try {
			Context ctx = (Context) new InitialContext();
			Context envContext = (Context) ((InitialContext) ctx).lookup("java:/comp/env"); 
			dataFactory = (DataSource) ((InitialContext) envContext).lookup("jdbc/oracle");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void Member() throws SQLException {
		List memberlist = new ArrayList();
		
		con = dataFactory.getConnection();
		String sql = "select * from t_member"; // sql 문
		pstmt = con.prepareStatement(sql); // 질의
		ResultSet rs = pstmt.executeQuery(); // pstmt의 결과
		
		while(rs.next()) { //다음행이 있을때 까지, rs가 참이면...
		String id = rs.getString("id"); //테이블의 id값을 string으로 가져온다.
		String pwd = rs.getString("pwd");
		String name = rs.getString("name");
		String email = rs.getString("email");
		Date joinDate = rs.getDate("joinDate");
		
		MemberVO vo = new MemberVO();
		
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setName(name);
		vo.setJoinDate(joinDate);
		
		}
	}
	public void MemberAdd() throws SQLException{
		con = dataFactory.getConnection();
		String sql = "insert into t_member values(?,?,?,?,?)"; // sql 문
		pstmt = con.prepareStatement(sql); // 질의
		ResultSet rs = pstmt.executeQuery(); // pstmt의 결과
		
	}

}
