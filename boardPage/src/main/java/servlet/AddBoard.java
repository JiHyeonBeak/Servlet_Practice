package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dao.BoardVO;

@WebServlet("/addServ")
public class AddBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO vo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		vo.setContent(content);
		vo.setTitle(title);
		
		dao.addBoard(vo);
		
		List list = dao.readBoard();
		request.setAttribute("boardlist", list);
		
		RequestDispatcher dis = request.getRequestDispatcher("Main.jsp");
		dis.forward(request, response);
		
	}

}
