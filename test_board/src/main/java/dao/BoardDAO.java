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
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("오라클 접속");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("접속 실패");
		}
	}
	
	public int addBoard(BoardVO bvo) {
		int result = 0;
		connDB();
		String sql = "insert into t_board values(t_board_seq.nextval,?,?,?,?)";
		try {
			System.out.println("dao상의 콘텐츠내용 : "+bvo.getContent());
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bvo.getTitle());
			pstmt.setString(2, bvo.getContent());
			pstmt.setString(3, bvo.getWriter());
			pstmt.setDate(4,bvo.getWdate());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public List<BoardVO> listBoard() {
		List<BoardVO> list = new ArrayList<BoardVO>(); 
		connDB();
		String sql = "select * from t_board order by no desc";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO bvo = new BoardVO();
				
				bvo.setNo(rs.getInt("no"));
				bvo.setContent(rs.getString("content"));
				bvo.setTitle(rs.getString("title"));
				bvo.setWdate(rs.getDate("wdate"));
				bvo.setWriter(rs.getString("writer"));
				
				list.add(bvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
