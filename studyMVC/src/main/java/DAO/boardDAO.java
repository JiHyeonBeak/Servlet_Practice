package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.BoardVO;

public class boardDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private void connDB() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("드라이버 오류");
		}
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			System.out.println("오라클 접속");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("오라클 접속 실패");
		}
	}
	
	public List<BoardVO> selectAllBoard() {
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setPass(rs.getString("pass"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setReadcount(rs.getInt("readcount"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				
				list.add(vo);

			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}return list;
	}
	
	public void insertBoard(BoardVO vo) {
		String sql = "insert into board(num,name,email,pass,title,content) values(board_seq.nextval,?,?,?,?,?)";
		try {
		connDB();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPass());
		pstmt.setString(4, vo.getTitle());
		pstmt.setString(5, vo.getContent());
		
		pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateReadCount(String num) {
		String sql = "update board set readcount=readcount+1 where num=?";
		
		try {
			connDB();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public BoardVO selectOneBoardByNum(String num) {
		String sql="select * from board where num=?";
		
		BoardVO vo = new BoardVO();
		
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setReadcount(rs.getInt("readcount"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	public void updateBoard(BoardVO vo) {
		String sql = "update board set name=?, email=?, pass=?,title=?,content=? where num=?";
		try {
		connDB();
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getEmail());
		pstmt.setString(3, vo.getPass());
		pstmt.setString(4, vo.getTitle());
		pstmt.setString(5, vo.getContent());
		pstmt.setInt(6, vo.getNum());
		
		pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public BoardVO checkPassWord(String pass, String num) {
		String sql="select * from board where pass=? and num=?";
		BoardVO vo = new BoardVO();
		
		try {
			connDB();
			pstmt =con.prepareStatement(sql);
			
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setNum(rs.getInt("num"));
				vo.setName(rs.getString("name"));
				vo.setPass(rs.getString("pass"));
				vo.setEmail(rs.getString("email"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWritedate(rs.getTimestamp("writedate"));
				vo.setReadcount(rs.getInt("readcount"));
			}
			
			}catch(Exception e) {
				e.printStackTrace();
		}
		return vo;
	}
	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		
		try {
			connDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, num);
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
