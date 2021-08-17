package test01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	private MemberDAO() {
		//싱글톤 패턴을 위한 private 생성자. 다른 클래스에서 인스턴스 생성불가
	}
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
		
	}
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/oracle");
		conn = ds.getConnection();
		return conn;
	}
	
	public int countID(String id) {
		int yn = -1;
		String sql = "select id form t_member where id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
		//	pstmt.setString(1,id);
			
		}catch (Exception e){
			
		}
		
		return yn;
	}
}
