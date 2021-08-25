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

@WebServlet("/boardServ")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		BoardVO bvo = new BoardVO();
		BoardDAO dao = new BoardDAO();
		
		List list = dao.listBoard();
		
		request.setAttribute("boardlist", list);
		for(int i=0; i<list.size(); i++) {
			System.out.println("리스트값:"+list.get(i));
		}
			
		RequestDispatcher dis = request.getRequestDispatcher("Board.jsp");
		dis.forward(request, response);
		
	}

}
