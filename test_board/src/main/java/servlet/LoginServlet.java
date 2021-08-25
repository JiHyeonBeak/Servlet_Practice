package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dao.MemberVO;


@WebServlet("/loginServ")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
		String url = "Login.jsp";
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		int chk = dao.checkId(user_id, user_pwd);
		if(chk == 2) {
			MemberVO vo = dao.getMember(user_id);
			System.out.println("서블릿으로 넘어온 result값:"+chk);
			HttpSession session = request.getSession();
			session.setAttribute("loginId",vo);
			System.out.println("세션:"+session.getAttribute("loginId"));
			url = "Board.jsp";
			
		}
		else if(chk == 1){
			System.out.println(chk);
			url = "Alert.jsp";
			
		}
		else {
			System.out.println(chk);
			url = "Alert.jsp";
		}
	
		RequestDispatcher dis = request.getRequestDispatcher("boardServ");
		dis.forward(request, response);
		
	}

}
