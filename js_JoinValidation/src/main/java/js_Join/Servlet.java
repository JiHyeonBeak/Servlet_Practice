package js_Join;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinServ")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");
		
		request.setAttribute("pwd", pwd);
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("email", email);
		request.setAttribute("gender", gender);
		request.setAttribute("birth", birth);
				
		RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
		dis.forward(request, response);
		
	}

}
