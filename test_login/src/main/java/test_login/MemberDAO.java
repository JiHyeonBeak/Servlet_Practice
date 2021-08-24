package test_login;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberDAO {
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void ConnDB() { //커넥션 풀 적용, 오라클 접속
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try {
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			String user = "system";
			String pwd = "oracle";
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("오라클 접속");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}
	
	public boolean checkId(String user_id,String user_pwd){
		boolean result = false;
		try {
			ConnDB();
			String sql = "select pwd from t_member where id=?"; // sql 문
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(user_pwd)) {
					result=true;
					System.out.println("rs참값에 pw찾음");
				}else {
					result=false;
					System.out.println("rs참값에 pw못찾음");
				}
			}else {
				result=false;	
				System.out.println("rs거짓");
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public void MemberAdd(){
		try {
			String sql = "insert into t_member values(?,?,?,?,?)"; // sql 문
			pstmt = con.prepareStatement(sql); // 질의
			ResultSet rs = pstmt.executeQuery(); // pstmt의 결과
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
