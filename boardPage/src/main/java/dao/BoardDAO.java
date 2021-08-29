package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 드라이버 오류");
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("오라클 접속");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
	}
	
	public void addBoard(BoardVO vo) {
	
		try {
			connDB();
			String sql = "insert into newboard(no,title,content) values(new_seq.nextval,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2, vo.getContent());
			
			pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<BoardVO> readBoard() {
		connDB();
		List<BoardVO> list = new ArrayList<BoardVO>();
		try {
			String sql = "select * from (select * from newboard order by no desc)where rownum <= 5";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setNo(rs.getInt("no"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setWdate(rs.getDate("wdate"));
				
				list.add(bvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	public void delBoard(String no) {
//		connDB();
//		try {
//			String sql = "delete from newboard where no=?";
//			pstmt = con.prepareStatement(sql);
//			
//			pstmt.setString(no);
//			
//			pstmt.executeUpdate();
//			
//			pstmt.close();
//			con.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}


}
