package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDAO;
import dao.BoardVO;
import dao.MemberVO;

@WebServlet("/writeServ")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("Board_write.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO mvo = new MemberVO();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession(true);
		
		
		String url = "Board.jsp";
		String writer = (String) session.getAttribute("loginId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		java.sql.Date wdate = new java.sql.Date(System.currentTimeMillis());
		
		System.out.println("서블릿 writer:"+writer);
		System.out.println("서블릿 title:"+title);
		System.out.println("서블릿 con:"+content);
		System.out.println("서블릿 wdate:"+wdate);
		
		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		bvo.setContent(content);
		bvo.setTitle(title);
		bvo.setWdate(wdate);
		bvo.setWriter(writer);
		
		
		System.out.println("서블릿vo콘:"+bvo.getTitle());
		System.out.println("서블릿vo콘:"+bvo.getContent());
		
		int result = dao.addBoard(bvo);
		
		if(result == 1) {
			System.out.println("글작성 rs:"+result);
			
		}else {
			System.out.println("글작성 rs:"+result);
			url = "Board_write.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
