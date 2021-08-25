package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.MemberVO;

public class MemberDAO { // DB접속
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			}catch(Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "oracle");
			System.out.println("오라클 접속");
			}catch(Exception e){
			System.out.println("접속 실패");
			e.printStackTrace();
		}
	}
	
	public int checkId(String user_id,String user_pwd) { // 로그인 체크
		int result = 0;

		try {
			connDB();
			String sql = "select pwd from t_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(user_pwd)) {
				result = 2;
				System.out.println("아이디 찾음");
				}
				else {
				result = 1;
				System.out.println("2번 if: 비밀번호 못 찾음");
			}
		}else {
			result = 0;
			System.out.println("아이디 없음");
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int addMember(MemberVO vo) {
		int result = 0;
		connDB();
		String sql = "insert into t_member values(?,?,?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setDate(5, vo.getDate());
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	public MemberVO getMember(String user_id) {
		connDB();
		MemberVO vo = new MemberVO();
		String sql ="select * from t_member where id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPwd(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setDate(rs.getDate("joindate"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
}
