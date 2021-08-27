package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.draive.OracleDriver");	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("오라클 접속");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
	}
	
	public int addBoard(BoardVO vo) {
		int result = 0;
		
		try {
			connDB();
			String sql = "insert into newboard values(?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,vo.getContent());
			pstmt.setString(2, vo.getTitle());	
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
